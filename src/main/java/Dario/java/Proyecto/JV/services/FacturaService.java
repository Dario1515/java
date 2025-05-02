package Dario.java.Proyecto.JV.services;

import Dario.java.Proyecto.JV.entity.Factura;
import Dario.java.Proyecto.JV.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public void save(Factura factura) {
        this.facturaRepository.save(factura);
    }

    public Optional<Factura> findById(Long id) {
        return this.facturaRepository.findById(id);
    }

    public List<Factura> findAll() {
        return this.facturaRepository.findAll();
    }

    public Optional<Factura> updateFactura(Long id, Factura factura) {
        Optional<Factura> facturaOpt = this.facturaRepository.findById(id);

        if (facturaOpt.isEmpty()) {
            return Optional.empty();
        }

        Factura facturaDb = facturaOpt.get();
        facturaDb.setCliente(factura.getCliente());
        facturaDb.setRepuestos(factura.getRepuestos());
        facturaDb.setFechaEmision(factura.getFechaEmision());
        facturaDb.setTotal(factura.getTotal());

        this.facturaRepository.save(facturaDb);
        return Optional.of(facturaDb);
    }

    public Optional<Factura> deleteFactura(Long id) {
        Optional<Factura> facturaOpt = this.facturaRepository.findById(id);

        if (facturaOpt.isEmpty()) {
            return Optional.empty();
        }

        this.facturaRepository.delete(facturaOpt.get());
        return Optional.of(facturaOpt.get());
    }
}
