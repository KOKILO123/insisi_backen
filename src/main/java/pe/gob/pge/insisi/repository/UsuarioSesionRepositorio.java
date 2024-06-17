package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.gob.pge.insisi.entity.Usuario;


import java.util.Optional;


public  interface UsuarioSesionRepositorio extends JpaRepository<Usuario, Long> {

	@Query(value="select u from Usuario u where u.usuario=:usuario")
	public Optional<Usuario> BuscarUsuario(@Param("usuario") String usuario);

}
