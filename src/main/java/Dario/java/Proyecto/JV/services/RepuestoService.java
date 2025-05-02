package Dario.java.Proyecto.JV.services;

import Dario.java.Proyecto.JV.entity.Repuesto;
import Dario.java.Proyecto.JV.repositories.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepuestoService {

    @Autowired
    private RepuestoRepository repuestoRepository;

    public void save(Repuesto repuesto) {
        this.repuestoRepository.save(repuesto);
    }

    public Optional<Repuesto> findById(Long id) {
        return this.repuestoRepository.findById(id);
    }

    public List<Repuesto> findAll() {
        return this.repuestoRepository.findAll();
    }

    public Optional<Repuesto> updateRepuesto(Long id, Repuesto repuesto) {
        Optional<Repuesto> repuestoOpt = this.repuestoRepository.findById(id);

        if (repuestoOpt.isEmpty()) {
            return Optional.empty();
        }

        Repuesto repuestoDb = repuestoOpt.get();
        repuestoDb.setNombre(repuesto.getNombre());
        repuestoDb.setPrecio(repuesto.getPrecio());

        this.repuestoRepository.save(repuestoDb);
        return Optional.of(repuestoDb);
    }

    public Optional<Repuesto> deleteRepuesto(Long id) {
        Optional<Repuesto> repuestoOpt = this.repuestoRepository.findById(id);

        if (repuestoOpt.isEmpty()) {
            return Optional.empty();
        }

        this.repuestoRepository.delete(repuestoOpt.get());
        return Optional.of(repuestoOpt.get());
    }
}
