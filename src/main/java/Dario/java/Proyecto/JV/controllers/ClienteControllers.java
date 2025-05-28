package Dario.java.Proyecto.JV.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import io.swagger.v3.oas.annotations.Operation;


import java.util.Optional;


import java.util.List;


@Tag(name = "Cliente", description = "Servicio de Clientes")
@RestController
@RequestMapping("/cliente")
public class ClienteControllers {

  @Autowired
  private ClienteService clienteService;


  @Operation(
          summary = "nos devuelve todos los clientes que viven en una api externa",
          description = "nos devuelve todos los clientes de jsonplaceholder "
  )
          @ApiResponse(
                  responseCode = "200",
                  description = "Clientes encontrados exitosamente",
                  content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Cliente.class))})



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

  @Operation(
          summary = "Genera un nuevo cliente en nuestra API",
          description = "Realiza un HTTP POST para agregar un nuevo cliente",
          requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                  description = "Cliente que se desea crear",
                  required = true,
                  content = @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation = Cliente.class),
                          examples = {
                                  @io.swagger.v3.oas.annotations.media.ExampleObject(
                                          name = "Cliente ejemplo",
                                          value = "{ \"nombre\": \"María López\", \"direccion\": \"Av. Siempre Viva 123\", \"telefono\": \"1122334455\", \"email\": \"maria@example.com\" }"
                                  )
                          }
                  )
          )
  )
  @ApiResponses({
          @ApiResponse(
                  responseCode = "200",
                  description = "Cliente creado exitosamente :)",
                  content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
          ),
          @ApiResponse(
                  responseCode = "400",
                  description = "Error al crear el cliente",
                  content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
          )
  })

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
