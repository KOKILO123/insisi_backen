package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.TipoUsuario;
import pe.gob.pge.insisi.entity.TipoUsuarioMenu;
import pe.gob.pge.insisi.projection.DashboardProjection;
import pe.gob.pge.insisi.projection.MenuTipoUsuarioProjection;

import java.util.List;

public interface TipoUsuarioMenuRepositorio extends JpaRepository<TipoUsuarioMenu, Long> {
    @Query(value="select t from TipoUsuarioMenu t where t.estado=1")
    List<TipoUsuarioMenu> list();


    @Query(value = "EXEC listaMenuXTipousuario ?1 ", nativeQuery=true)
    List<MenuTipoUsuarioProjection> getlistMenuTipoUsuario(long id);
}
