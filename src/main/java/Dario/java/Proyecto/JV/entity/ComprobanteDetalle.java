package Dario.java.Proyecto.JV.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPROBANTE_DETALLE")
public class ComprobanteDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comprobante_id", nullable = false)
    @JsonBackReference  // Para evitar ciclos al serializar JSON
    private Comprobante comprobante;

    @ManyToOne
    @JoinColumn(name = "repuesto_id", nullable = false)
    private Repuesto repuesto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private double subtotal;

    @JsonProperty("stockRestante")
    public int getStockRestante() {
        if (repuesto == null) return 0;
        // Stock actual menos la cantidad vendida en este detalle
        return repuesto.getStock() - cantidad;
    }
}
