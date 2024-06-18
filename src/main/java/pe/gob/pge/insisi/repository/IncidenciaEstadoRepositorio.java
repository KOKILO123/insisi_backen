package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Area;
import pe.gob.pge.insisi.entity.IncidenciaEstado;

import java.util.List;

public interface IncidenciaEstadoRepositorio extends JpaRepository<IncidenciaEstado, Long> {
    @Query(value="select t from IncidenciaEstado t where t.estado=1")
    List<IncidenciaEstado> list();
}
