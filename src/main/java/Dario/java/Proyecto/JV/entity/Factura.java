package Dario.java.Proyecto.JV.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "FACTURAS")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;


    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "FACTURA_REPUESTO",
            joinColumns = @JoinColumn(name = "FACTURA_ID"),
            inverseJoinColumns = @JoinColumn(name = "REPUESTO_CODIGO")
    )
    private List<Repuesto> repuestos;

    @Column(name = "FECHA_EMISION")
    private LocalDate fechaEmision;

    @Column(name = "TOTAL")
    private BigDecimal total;
}

