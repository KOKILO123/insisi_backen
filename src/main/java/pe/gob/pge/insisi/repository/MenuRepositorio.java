package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Menu;
import pe.gob.pge.insisi.entity.TipoUsuario;

import java.util.List;

public interface MenuRepositorio extends JpaRepository<Menu, Long> {
    @Query(value="select t from Menu t where t.estado=1")
    List<Menu> list();
}
