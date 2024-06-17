package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Usuario;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    @Query(value="select t from Usuario t where t.estado=1")
    List<Usuario> list();

    @Query(value="select t from Usuario t where t.estado=1 and t.usuario=?1 and t.clave=?2")
    List<Usuario>  listLogin(String usuario,String clave);

}
