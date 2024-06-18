package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.IncidenciaDTO;
import pe.gob.pge.insisi.dto.RequestBodyIncidencia;
import pe.gob.pge.insisi.entity.Incidencia;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.IncidenciaRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IncidenciaRepositorio incidenciaRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public IncidenciaDTO create(RequestBodyIncidencia tablaDTO) {

        Incidencia tabla=new Incidencia();
        tabla.setTipoIncidenciaId(tablaDTO.getTipoIncidenciaId());
        tabla.setAreaId(tablaDTO.getAreId());
        tabla.setPrioridadId(tablaDTO.getPrioridadId());
        //tabla.setFechaSolicitado(tablaDTO.getFechaSolicitado());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        System.out.println(MetodosGenerales.capturarFechaActual());

       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedNow = MetodosGenerales.capturarFechaActual().format(formatter);
        //System.out.println(formattedNow);
        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        Incidencia nuevo = incidenciaRepositorio.save(tabla);
        IncidenciaDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<IncidenciaDTO> list() {
        List<Incidencia> tablas = incidenciaRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public IncidenciaDTO listId(long id) {
        Incidencia tabla = incidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public IncidenciaDTO update(IncidenciaDTO tablaDTO, long id) {
        Incidencia tabla = incidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoIncidenciaId(tablaDTO.getTipoIncidenciaid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Incidencia actualizado = incidenciaRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public IncidenciaDTO cambioEstado(long id) {
        Incidencia tabla = incidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Incidencia actualizado = incidenciaRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Incidencia tabla = incidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incidencia", "id", id));
        incidenciaRepositorio.delete(tabla);
    }




    private IncidenciaDTO mapearDTO(Incidencia tabla) {
        IncidenciaDTO tablaDTO = modelMapper.map(tabla, IncidenciaDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private Incidencia mapearEntidad(IncidenciaDTO tablaDTO) {
        Incidencia tabla = modelMapper.map(tablaDTO, Incidencia.class);
        return tabla;
    }
}
