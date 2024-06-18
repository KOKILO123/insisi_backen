package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.IncidenciaEstadoDTO;
import pe.gob.pge.insisi.dto.RequestBodyIncidenciaEstado;
import pe.gob.pge.insisi.entity.IncidenciaEstado;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.IncidenciaEstadoRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidenciaEstadoServiceImpl implements IncidenciaEstadoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IncidenciaEstadoRepositorio incidenciaEstadoRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public IncidenciaEstadoDTO create(RequestBodyIncidenciaEstado tablaDTO) {

        IncidenciaEstado tabla=new IncidenciaEstado();
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        IncidenciaEstado nuevo = incidenciaEstadoRepositorio.save(tabla);
        IncidenciaEstadoDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<IncidenciaEstadoDTO> list() {
        List<IncidenciaEstado> tablas = incidenciaEstadoRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public IncidenciaEstadoDTO listId(long id) {
        IncidenciaEstado tabla = incidenciaEstadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaEstado", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public IncidenciaEstadoDTO update(IncidenciaEstadoDTO tablaDTO, long id) {
        IncidenciaEstado tabla = incidenciaEstadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaEstado", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoIncidenciaEstadoId(tablaDTO.getTipoIncidenciaEstadoid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        IncidenciaEstado actualizado = incidenciaEstadoRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public IncidenciaEstadoDTO cambioEstado(long id) {
        IncidenciaEstado tabla = incidenciaEstadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaEstado", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        IncidenciaEstado actualizado = incidenciaEstadoRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        IncidenciaEstado tabla = incidenciaEstadoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaEstado", "id", id));
        incidenciaEstadoRepositorio.delete(tabla);
    }




    private IncidenciaEstadoDTO mapearDTO(IncidenciaEstado tabla) {
        IncidenciaEstadoDTO tablaDTO = modelMapper.map(tabla, IncidenciaEstadoDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private IncidenciaEstado mapearEntidad(IncidenciaEstadoDTO tablaDTO) {
        IncidenciaEstado tabla = modelMapper.map(tablaDTO, IncidenciaEstado.class);
        return tabla;
    }
}
