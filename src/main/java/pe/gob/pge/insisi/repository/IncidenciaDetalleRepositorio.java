package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.pge.insisi.entity.IncidenciaDetalle;
import pe.gob.pge.insisi.entity.Usuario;

public interface IncidenciaDetalleRepositorio extends JpaRepository<IncidenciaDetalle, Long> {
}
