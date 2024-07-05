package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.RequestBodyMenu;
import pe.gob.pge.insisi.dto.MenuDTO;
import pe.gob.pge.insisi.entity.Menu;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.MenuRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MenuRepositorio menuRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public MenuDTO create(RequestBodyMenu tablaDTO) {

        Menu tabla=new Menu();
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        Menu nuevo = menuRepositorio.save(tabla);
        MenuDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<MenuDTO> list() {
        List<Menu> tablas = menuRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public MenuDTO listId(long id) {
        Menu tabla = menuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public MenuDTO update(MenuDTO tablaDTO, long id) {
        Menu tabla = menuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoMenuId(tablaDTO.getTipoMenuid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Menu actualizado = menuRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public MenuDTO cambioEstado(long id) {
        Menu tabla = menuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Menu actualizado = menuRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Menu tabla = menuRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", id));
        menuRepositorio.delete(tabla);
    }




    private MenuDTO mapearDTO(Menu tabla) {
        MenuDTO tablaDTO = modelMapper.map(tabla, MenuDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private Menu mapearEntidad(MenuDTO tablaDTO) {
        Menu tabla = modelMapper.map(tablaDTO, Menu.class);
        return tabla;
    }
}
