package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Aplicacion;
import pe.gob.pge.insisi.entity.Area;

import java.util.List;

public interface AreaRepositorio extends JpaRepository<Area, Long> {
    @Query(value="select t from Area t where t.estado=1")
    List<Area> list();
}
