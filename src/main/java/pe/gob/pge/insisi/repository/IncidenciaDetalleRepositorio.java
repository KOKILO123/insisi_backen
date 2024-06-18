package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Area;
import pe.gob.pge.insisi.entity.IncidenciaDetalle;
import pe.gob.pge.insisi.entity.Usuario;

import java.util.List;

public interface IncidenciaDetalleRepositorio extends JpaRepository<IncidenciaDetalle, Long> {
    @Query(value="select t from IncidenciaDetalle t where t.estado=1")
    List<IncidenciaDetalle> list();
}
