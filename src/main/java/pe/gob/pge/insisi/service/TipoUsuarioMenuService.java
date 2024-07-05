 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.RequestBodyTipoUsuarioMenu;
 import pe.gob.pge.insisi.dto.TipoUsuarioMenuDTO;
 import pe.gob.pge.insisi.projection.MenuTipoUsuarioProjection;

 import java.util.List;

 public interface TipoUsuarioMenuService {

     public TipoUsuarioMenuDTO create(RequestBodyTipoUsuarioMenu tablaDTO);
     public List<TipoUsuarioMenuDTO> list();
     public TipoUsuarioMenuDTO listId(long id);
     public TipoUsuarioMenuDTO update(TipoUsuarioMenuDTO tablaDTO, long id);
     public TipoUsuarioMenuDTO cambioEstado(long id);
     public void delete(long id);

     public List<MenuTipoUsuarioProjection> listMenuTipoUsuario(long id);

 }
