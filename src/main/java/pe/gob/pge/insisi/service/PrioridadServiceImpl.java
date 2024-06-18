package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.PrioridadDTO;
import pe.gob.pge.insisi.dto.RequestBodyPrioridad;
import pe.gob.pge.insisi.entity.Prioridad;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.PrioridadRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrioridadServiceImpl implements PrioridadService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PrioridadRepositorio prioridadRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public PrioridadDTO create(RequestBodyPrioridad tablaDTO) {

        Prioridad tabla=new Prioridad();
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        //System.out.println(tabla);

        Prioridad nuevo = prioridadRepositorio.save(tabla);
        PrioridadDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<PrioridadDTO> list() {
        List<Prioridad> tablas = prioridadRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public PrioridadDTO listId(long id) {
        Prioridad tabla = prioridadRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prioridad", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public PrioridadDTO update(PrioridadDTO tablaDTO, long id) {
        Prioridad tabla = prioridadRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prioridad", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoPrioridadId(tablaDTO.getTipoPrioridadid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Prioridad actualizado = prioridadRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public PrioridadDTO cambioEstado(long id) {
        Prioridad tabla = prioridadRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prioridad", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Prioridad actualizado = prioridadRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Prioridad tabla = prioridadRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prioridad", "id", id));
        prioridadRepositorio.delete(tabla);
    }




    private PrioridadDTO mapearDTO(Prioridad tabla) {
        PrioridadDTO tablaDTO = modelMapper.map(tabla, PrioridadDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private Prioridad mapearEntidad(PrioridadDTO tablaDTO) {
        Prioridad tabla = modelMapper.map(tablaDTO, Prioridad.class);
        return tabla;
    }
}
