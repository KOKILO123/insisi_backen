package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.pge.insisi.entity.Institucion;

public interface IntitucionRepositorio extends JpaRepository<Institucion, Long> {
}
