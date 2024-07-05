package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.RequestBodyTipoUsuarioMenu;
import pe.gob.pge.insisi.dto.TipoUsuarioMenuDTO;
import pe.gob.pge.insisi.entity.TipoUsuarioMenu;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.projection.MenuTipoUsuarioProjection;
import pe.gob.pge.insisi.repository.TipoUsuarioMenuRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoUsuarioMenuServiceImpl implements TipoUsuarioMenuService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TipoUsuarioMenuRepositorio tipoUsuarioMenuRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public TipoUsuarioMenuDTO create(RequestBodyTipoUsuarioMenu tablaDTO) {

        TipoUsuarioMenu tabla=new TipoUsuarioMenu();
        tabla.setTipoUsuarioId(tablaDTO.getTipoUsuarioId());
        tabla.setMenuId(tablaDTO.getMenuId());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        TipoUsuarioMenu nuevo = tipoUsuarioMenuRepositorio.save(tabla);
        TipoUsuarioMenuDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<TipoUsuarioMenuDTO> list() {
        List<TipoUsuarioMenu> tablas = tipoUsuarioMenuRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public TipoUsuarioMenuDTO listId(long id) {
        TipoUsuarioMenu tabla = tipoUsuarioMenuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuarioMenu", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public TipoUsuarioMenuDTO update(TipoUsuarioMenuDTO tablaDTO, long id) {
        TipoUsuarioMenu tabla = tipoUsuarioMenuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuarioMenu", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoTipoUsuarioMenuId(tablaDTO.getTipoTipoUsuarioMenuid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        TipoUsuarioMenu actualizado = tipoUsuarioMenuRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public TipoUsuarioMenuDTO cambioEstado(long id) {
        TipoUsuarioMenu tabla = tipoUsuarioMenuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuarioMenu", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        TipoUsuarioMenu actualizado = tipoUsuarioMenuRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        TipoUsuarioMenu tabla = tipoUsuarioMenuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoUsuarioMenu", "id", id));
        tipoUsuarioMenuRepositorio.delete(tabla);
    }

    @Override
    public List<MenuTipoUsuarioProjection> listMenuTipoUsuario(long id) {
        List<MenuTipoUsuarioProjection> tablas = tipoUsuarioMenuRepositorio.getlistMenuTipoUsuario(id);
        return tablas;
        //return Collections.emptyList();
    }


    private TipoUsuarioMenuDTO mapearDTO(TipoUsuarioMenu tabla) {
        TipoUsuarioMenuDTO tablaDTO = modelMapper.map(tabla, TipoUsuarioMenuDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private TipoUsuarioMenu mapearEntidad(TipoUsuarioMenuDTO tablaDTO) {
        TipoUsuarioMenu tabla = modelMapper.map(tablaDTO, TipoUsuarioMenu.class);
        return tabla;
    }



}
