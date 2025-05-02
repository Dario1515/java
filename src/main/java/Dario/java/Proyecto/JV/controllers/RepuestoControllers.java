package Dario.java.Proyecto.JV.controllers;

import Dario.java.Proyecto.JV.entity.Repuesto;
import Dario.java.Proyecto.JV.services.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repuesto")
public class RepuestoControllers {

    @Autowired
    private RepuestoService repuestoService;

    @GetMapping
    public ResponseEntity<List<Repuesto>> getAll() {
        return ResponseEntity.ok(this.repuestoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Repuesto>> getById(@PathVariable Long codigo) {
        Optional<Repuesto> repuesto = this.repuestoService.findById(codigo);

        if (repuesto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repuesto);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Repuesto> create(@RequestBody Repuesto repuesto) {
        try {
            this.repuestoService.save(repuesto);
            return ResponseEntity.ok(repuesto);
        } catch (Exception error) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Optional<Repuesto>> update(@PathVariable Long codigo, @RequestBody Repuesto repuesto) {
        Optional<Repuesto> repuestoOpt = this.repuestoService.updateRepuesto(codigo, repuesto);

        if (repuestoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repuestoOpt);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Optional<Repuesto>> delete(@PathVariable Long codigo) {
        Optional<Repuesto> repuestoOpt = this.repuestoService.deleteRepuesto(codigo);

        if (repuestoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repuestoOpt);
    }
}
