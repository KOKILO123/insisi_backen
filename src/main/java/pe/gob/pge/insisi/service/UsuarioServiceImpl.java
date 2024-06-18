package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.RequestBodyUsuario;
import pe.gob.pge.insisi.dto.UsuarioDTO;
import pe.gob.pge.insisi.entity.Usuario;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.UsuarioRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public UsuarioDTO create(RequestBodyUsuario tablaDTO) {

        Usuario tabla=new Usuario();
        //Usuario tabla = mapearEntidad(usuarioDTO);
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setTipoUsuarioId(tablaDTO.getTipoUsuarioid());
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setUsuario(tablaDTO.getUsuario());
        tabla.setClave(tablaDTO.getClave());
        tabla.setEstado(1);

        System.out.println(MetodosGenerales.capturarFechaActual());

       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedNow = MetodosGenerales.capturarFechaActual().format(formatter);
        //System.out.println(formattedNow);
        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println("tablaaaa "+tabla);

        Usuario nuevo = usuarioRepositorio.save(tabla);
        UsuarioDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<UsuarioDTO> list() {
        List<Usuario> tablas = usuarioRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public UsuarioDTO listId(long id) {
        Usuario tabla = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO tablaDTO, long id) {
        Usuario tabla = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));

        tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoUsuarioId(tablaDTO.getTipoUsuarioid());

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Usuario actualizado = usuarioRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public UsuarioDTO cambioEstado(long id) {
        Usuario tabla = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Usuario actualizado = usuarioRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Usuario tabla = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        usuarioRepositorio.delete(tabla);
    }

    @Override
    public List<UsuarioDTO> listLogin(String usuario, String clave) {
        List<Usuario> tablas = usuarioRepositorio.listLogin(usuario,clave);
        //System.out.println("tabla "+tabla);
       /* if(tabla==null){
            UsuarioDTO usuarioDTO=new UsuarioDTO();
            return usuarioDTO;
        }*/
       // return mapearDTO(tabla);
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
    }


    private UsuarioDTO mapearDTO(Usuario tabla) {
        UsuarioDTO usuarioDTO = modelMapper.map(tabla, UsuarioDTO.class);
        return usuarioDTO;
    }
    // Convierte de DTO a Entidad
    private Usuario mapearEntidad(UsuarioDTO tablaDTO) {
        Usuario tabla = modelMapper.map(tablaDTO, Usuario.class);
        return tabla;
    }
}
