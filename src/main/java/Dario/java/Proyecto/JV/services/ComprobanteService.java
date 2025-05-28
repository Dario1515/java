package Dario.java.Proyecto.JV.services;

import Dario.java.Proyecto.JV.entity.Cliente;
import Dario.java.Proyecto.JV.entity.Comprobante;
import Dario.java.Proyecto.JV.entity.ComprobanteDetalle;
import Dario.java.Proyecto.JV.entity.Repuesto;
import Dario.java.Proyecto.JV.repositories.ClienteRepository;
import Dario.java.Proyecto.JV.repositories.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ComprobanteService {

    @Autowired
    private Dario.java.Proyecto.JV.repository.ComprobanteRepository comprobanteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Transactional
    public Comprobante crearComprobante(Comprobante comprobante) {
        // Validar cliente
        Cliente cliente = clienteRepository.findById(comprobante.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no existe con ID: " + comprobante.getCliente().getId()));
        comprobante.setCliente(cliente);

        BigDecimal total = BigDecimal.ZERO;

        for (ComprobanteDetalle detalle : comprobante.getDetalles()) {
            Long codigo = Long.valueOf(detalle.getRepuesto().getCodigo());
            Repuesto repuesto = repuestoRepository.findById(codigo)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + codigo));

            if (detalle.getCantidad() > repuesto.getStock()) {
                throw new RuntimeException("Stock insuficiente para " + repuesto.getNombre());
            }

            // Restar stock
            repuesto.setStock(repuesto.getStock() - detalle.getCantidad());
            repuestoRepository.save(repuesto);

            // Asignar repuesto completo al detalle
            detalle.setRepuesto(repuesto);
            detalle.setComprobante(comprobante);

            // Calcular subtotal y asignar al detalle
            BigDecimal precioUnitario = repuesto.getPrecio();
            BigDecimal cantidadBD = BigDecimal.valueOf(detalle.getCantidad());
            BigDecimal subtotal = precioUnitario.multiply(cantidadBD);

            detalle.setSubtotal(subtotal.doubleValue());

            // Sumar al total
            total = total.add(subtotal);
        }

        comprobante.setTotal(total.doubleValue());

        // Setear la fecha actual (no olvides ajustar el nombre del setter si es distinto)
        comprobante.setFechaEmision(new Date());

        return comprobanteRepository.save(comprobante);
    }
}
