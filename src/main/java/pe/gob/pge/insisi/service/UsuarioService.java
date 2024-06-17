 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.RequestBodyUsuario;
 import pe.gob.pge.insisi.dto.UsuarioDTO;

 import java.util.List;

 public interface UsuarioService {

     public UsuarioDTO create(RequestBodyUsuario tablaDTO);
     public List<UsuarioDTO> list();
     public UsuarioDTO listId(long id);
     public UsuarioDTO update(UsuarioDTO tablaDTO, long id);
     public UsuarioDTO cambioEstado(long id);
     public void delete(long id);

     public List<UsuarioDTO> listLogin(String usuario,String clave);
 }
