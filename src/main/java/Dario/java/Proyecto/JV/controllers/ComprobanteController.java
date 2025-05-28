package Dario.java.Proyecto.JV.controllers;

import Dario.java.Proyecto.JV.entity.Comprobante;
import Dario.java.Proyecto.JV.services.ComprobanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @Operation(summary = "Crear un nuevo comprobante de venta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comprobante creado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comprobante.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o validaciones fallidas",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<?> crearComprobante(@RequestBody Comprobante comprobante) {
        try {
            Comprobante nuevoComprobante = comprobanteService.crearComprobante(comprobante);
            return ResponseEntity.ok(nuevoComprobante);
        } catch (Exception e) {
            // Capturamos la excepción y respondemos con 400 y el mensaje del error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}