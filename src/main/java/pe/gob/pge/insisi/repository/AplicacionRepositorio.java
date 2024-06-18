package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Aplicacion;
import pe.gob.pge.insisi.entity.Usuario;

import java.util.List;

public interface AplicacionRepositorio extends JpaRepository<Aplicacion, Long> {
    @Query(value="select t from Aplicacion t where t.estado=1")
    List<Aplicacion> list();
}
