package Dario.java.Proyecto.JV.services;

import Dario.java.Proyecto.JV.entity.Cliente;
import Dario.java.Proyecto.JV.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void save(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return this.clienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> updateClient(Long id, Cliente cliente) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findById(id);

        if (clienteOpt.isEmpty()) {
            return Optional.empty();
        }

        Cliente clienteDb = clienteOpt.get();


        clienteDb.setNombre(cliente.getNombre());
        clienteDb.setDireccion(cliente.getDireccion());
        clienteDb.setTelefono(cliente.getTelefono());
        clienteDb.setEmail(cliente.getEmail());

        this.clienteRepository.save(clienteDb);

        return Optional.of(clienteDb);
    }

    public Optional<Cliente> deleteClient(Long id) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findById(id);

        if (clienteOpt.isEmpty()) {
            return Optional.empty();
        }

        this.clienteRepository.delete(clienteOpt.get());
        return Optional.of(clienteOpt.get());
    }


}
