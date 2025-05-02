package Dario.java.Proyecto.JV.repositories;

import Dario.java.Proyecto.JV.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
}
