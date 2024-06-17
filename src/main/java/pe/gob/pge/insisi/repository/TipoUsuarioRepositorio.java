package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.pge.insisi.entity.TipoUsuario;
import pe.gob.pge.insisi.entity.Usuario;

public interface TipoUsuarioRepositorio extends JpaRepository<TipoUsuario, Long> {
}
