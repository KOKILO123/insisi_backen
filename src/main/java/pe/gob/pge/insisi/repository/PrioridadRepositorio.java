package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Aplicacion;
import pe.gob.pge.insisi.entity.Prioridad;
import pe.gob.pge.insisi.entity.Usuario;

import java.util.List;

public interface PrioridadRepositorio extends JpaRepository<Prioridad, Long> {
    @Query(value="select t from Prioridad t where t.estado=1")
    List<Prioridad> list();
}
