package Dario.java.Proyecto.JV.controllers;

import Dario.java.Proyecto.JV.entity.Factura;
import Dario.java.Proyecto.JV.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
public class FacturaControllers {

    @Autowired
    private FacturaService facturaService;


    @GetMapping
    public ResponseEntity<List<Factura>> getAll() {
        return ResponseEntity.ok(this.facturaService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Factura>> getById(@PathVariable Long id) {
        Optional<Factura> factura = this.facturaService.findById(id);

        if (factura.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factura);
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<Factura> create(@RequestBody Factura factura) {
        try {
            this.facturaService.save(factura);
            return ResponseEntity.ok(factura);
        } catch (Exception error) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Optional<Factura>> update(@PathVariable Long id, @RequestBody Factura factura) {
        Optional<Factura> facturaOpt = this.facturaService.updateFactura(id, factura);

        if (facturaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaOpt);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Factura>> delete(@PathVariable Long id) {
        Optional<Factura> facturaOpt = this.facturaService.deleteFactura(id);

        if (facturaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaOpt);
    }
}

