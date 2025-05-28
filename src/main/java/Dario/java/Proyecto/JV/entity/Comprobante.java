package Dario.java.Proyecto.JV.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "COMPROBANTES")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobante")
    @JsonManagedReference  // Para evitar referencias circulares en JSON
    private List<ComprobanteDetalle> detalles;

    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "total")
    private double total;

    public void setFechaEmision(Date fecha) {
        this.fechaEmision = fecha;
    }

    public void setFecha(Date date) {
        // si usás este método, implementalo o eliminálo si no es necesario
    }

    // Método para calcular la cantidad total de productos vendidos en este comprobante
    public int getCantidadTotal() {
        if (detalles == null) return 0;
        return detalles.stream()
                .mapToInt(detalle -> detalle.getCantidad())
                .sum();
    }
}
