package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Prioridad;
import pe.gob.pge.insisi.entity.TipoIncidencia;

import java.util.List;

public interface TipoIncidenciaRepositorio extends JpaRepository<TipoIncidencia, Long> {
    @Query(value="select t from TipoIncidencia t where t.estado=1")
    List<TipoIncidencia> list();
}
