package Dario.java.Proyecto.JV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REPUESTO")

public class REPUESTOS {
    @Column(name = "NOMBRE")
    private String nombre;
    @Id
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "PRECIO")
    private int precio;
    @Column(name = "CODIGO")
    private int codigo;
}
