package Dario.java.Proyecto.JV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Repuestos")

public class Repuesto {
    @Id
    @Column(name = "CODIGO")
    private int codigo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "PRECIO")
    private int precio;
}
