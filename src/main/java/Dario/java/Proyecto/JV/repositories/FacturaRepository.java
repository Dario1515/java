package Dario.java.Proyecto.JV.repositories;

import Dario.java.Proyecto.JV.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
