package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.AplicacionDTO;
import pe.gob.pge.insisi.dto.RequestBodyAplicacion;
import pe.gob.pge.insisi.entity.Aplicacion;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.AplicacionRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AplicacionServiceImpl implements AplicacionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AplicacionRepositorio aplicacionRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public AplicacionDTO create(RequestBodyAplicacion tablaDTO) {

        Aplicacion tabla=new Aplicacion();
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        Aplicacion nuevo = aplicacionRepositorio.save(tabla);
        AplicacionDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<AplicacionDTO> list() {
        List<Aplicacion> tablas = aplicacionRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public AplicacionDTO listId(long id) {
        Aplicacion tabla = aplicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aplicacion", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public AplicacionDTO update(AplicacionDTO tablaDTO, long id) {
        Aplicacion tabla = aplicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aplicacion", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoAplicacionId(tablaDTO.getTipoAplicacionid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Aplicacion actualizado = aplicacionRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public AplicacionDTO cambioEstado(long id) {
        Aplicacion tabla = aplicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aplicacion", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Aplicacion actualizado = aplicacionRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Aplicacion tabla = aplicacionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aplicacion", "id", id));
        aplicacionRepositorio.delete(tabla);
    }




    private AplicacionDTO mapearDTO(Aplicacion tabla) {
        AplicacionDTO tablaDTO = modelMapper.map(tabla, AplicacionDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private Aplicacion mapearEntidad(AplicacionDTO tablaDTO) {
        Aplicacion tabla = modelMapper.map(tablaDTO, Aplicacion.class);
        return tabla;
    }
}
