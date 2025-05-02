package Dario.java.Proyecto.JV.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import Dario.java.Proyecto.JV.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import Dario.java.Proyecto.JV.entity.Cliente;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;


import java.util.List;



@RestController
@RequestMapping("/cliente")
public class ClienteControllers {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(this.clienteService.findAll());
  }
  @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getById(@PathVariable Long id) {
      Optional<Cliente> cliente = this.clienteService.findById(id);

      if (cliente.isEmpty()) {
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(cliente);
  }

  @PostMapping(consumes = "application/json")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
      try {
          this.clienteService.save(cliente);
          return ResponseEntity.ok(cliente);
      } catch (Exception error) {
          return ResponseEntity.badRequest().build();
      }
  }

  @PutMapping(value= "/{id}", consumes = "application/json")
    public ResponseEntity<Optional<Cliente>> update(@PathVariable Long id, @RequestBody Cliente cliente) {
      Optional<Cliente> clienteOpt = this.clienteService.updateClient(id, cliente);

      if (clienteOpt.isEmpty()) {
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(clienteOpt);
  }

  @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> delete(@PathVariable Long id) {
      Optional<Cliente> clienteOpt = this.clienteService.deleteClient(id);

      if (clienteOpt.isEmpty()) {
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(clienteOpt);
    }
}
