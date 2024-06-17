package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.pge.insisi.entity.Incidencia;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Long> {
}
