 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.RequestBodyTipoUsuario;
 import pe.gob.pge.insisi.dto.TipoUsuarioDTO;

 import java.util.List;

 public interface TipoUsuarioService {

     public TipoUsuarioDTO create(RequestBodyTipoUsuario tablaDTO);
     public List<TipoUsuarioDTO> list();
     public TipoUsuarioDTO listId(long id);
     public TipoUsuarioDTO update(TipoUsuarioDTO tablaDTO, long id);
     public TipoUsuarioDTO cambioEstado(long id);
     public void delete(long id);

 }
