package Dario.java.Proyecto.JV.entity;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;


@Data
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "pk del endpoint consumido", example = "1" ,requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    @Schema(description = "nombre del cliente", example = "Juan Pérez",requiredMode = Schema.RequiredMode.AUTO)
    private String nombre;

    @Column(name = "DIRECCION")
    @Schema(description = "direccion del cliente", example = "Calle Falsa 123",requiredMode = Schema.RequiredMode.AUTO)
    private String direccion;

    @Column(name = "TELEFONO")
    @Schema(description = "telefono del cliente", example = "1234567890",requiredMode = Schema.RequiredMode.AUTO)
    private String telefono;

    @Column(name = "EMAIL")
    @Schema(description = "email del cliente", example = "juan@example.com",requiredMode = Schema.RequiredMode.AUTO)
    private String email;

}

