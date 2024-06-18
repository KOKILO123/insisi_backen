package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Prioridad;
import pe.gob.pge.insisi.entity.TipoUsuario;
import pe.gob.pge.insisi.entity.Usuario;

import java.util.List;

public interface TipoUsuarioRepositorio extends JpaRepository<TipoUsuario, Long> {
    @Query(value="select t from TipoUsuario t where t.estado=1")
    List<TipoUsuario> list();
}
