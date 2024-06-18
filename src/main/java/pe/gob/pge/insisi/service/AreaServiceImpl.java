package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.AreaDTO;
import pe.gob.pge.insisi.dto.RequestBodyArea;
import pe.gob.pge.insisi.dto.RequestBodyUsuario;
import pe.gob.pge.insisi.entity.Area;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.AreaRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AreaRepositorio areaRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public AreaDTO create(RequestBodyArea tablaDTO) {

        Area tabla=new Area();

        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println("tablaaaa "+tabla);

        Area nuevo = areaRepositorio.save(tabla);
        AreaDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<AreaDTO> list() {
        List<Area> tablas = areaRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public AreaDTO listId(long id) {
        Area tabla = areaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public AreaDTO update(AreaDTO tablaDTO, long id) {
        Area tabla = areaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoAreaId(tablaDTO.getTipoAreaid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Area actualizado = areaRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public AreaDTO cambioEstado(long id) {
        Area tabla = areaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Area actualizado = areaRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Area tabla = areaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", "id", id));
        areaRepositorio.delete(tabla);
    }




    private AreaDTO mapearDTO(Area tabla) {
        AreaDTO tablaDTO = modelMapper.map(tabla, AreaDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private Area mapearEntidad(AreaDTO tablaDTO) {
        Area tabla = modelMapper.map(tablaDTO, Area.class);
        return tabla;
    }
}
