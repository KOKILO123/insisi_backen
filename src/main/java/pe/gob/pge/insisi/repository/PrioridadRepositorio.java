package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.pge.insisi.entity.Prioridad;
import pe.gob.pge.insisi.entity.Usuario;

public interface PrioridadRepositorio extends JpaRepository<Prioridad, Long> {
}
