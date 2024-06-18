package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.RequestBodyTipoUsuario;
import pe.gob.pge.insisi.dto.TipoUsuarioDTO;
import pe.gob.pge.insisi.entity.TipoUsuario;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.TipoUsuarioRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public TipoUsuarioDTO create(RequestBodyTipoUsuario tablaDTO) {

        TipoUsuario tabla=new TipoUsuario();
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        TipoUsuario nuevo = tipoUsuarioRepositorio.save(tabla);
        TipoUsuarioDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<TipoUsuarioDTO> list() {
        List<TipoUsuario> tablas = tipoUsuarioRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public TipoUsuarioDTO listId(long id) {
        TipoUsuario tabla = tipoUsuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuario", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public TipoUsuarioDTO update(TipoUsuarioDTO tablaDTO, long id) {
        TipoUsuario tabla = tipoUsuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuario", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoTipoUsuarioId(tablaDTO.getTipoTipoUsuarioid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        TipoUsuario actualizado = tipoUsuarioRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public TipoUsuarioDTO cambioEstado(long id) {
        TipoUsuario tabla = tipoUsuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuario", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        TipoUsuario actualizado = tipoUsuarioRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        TipoUsuario tabla = tipoUsuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuario", "id", id));
        tipoUsuarioRepositorio.delete(tabla);
    }




    private TipoUsuarioDTO mapearDTO(TipoUsuario tabla) {
        TipoUsuarioDTO tablaDTO = modelMapper.map(tabla, TipoUsuarioDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private TipoUsuario mapearEntidad(TipoUsuarioDTO tablaDTO) {
        TipoUsuario tabla = modelMapper.map(tablaDTO, TipoUsuario.class);
        return tabla;
    }
}
