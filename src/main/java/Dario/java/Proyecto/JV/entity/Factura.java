
package Dario.java.Proyecto.JV.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
import Dario.java.Proyecto.JV.entity.Repuesto;

@Data
@Entity
@Table(name = "FACTURAS")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST) // Aquí agregás el cascade
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) // Aquí también
    @JoinTable(
            name = "factura_repuesto",
            joinColumns = @JoinColumn(name = "factura_id"),
            inverseJoinColumns = @JoinColumn(name = "repuesto_codigo")
    )
    private List<Repuesto> repuestos; // Solo una vez esta propiedad

    @Column(name = "FECHA_EMISION")
    private Date fechaEmision;

    @Column(name = "TOTAL")
    private double total;
}
