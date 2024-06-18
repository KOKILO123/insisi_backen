package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.IncidenciaDetalleDTO;
import pe.gob.pge.insisi.entity.IncidenciaDetalle;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.IncidenciaDetalleRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidenciaDetalleServiceImpl implements IncidenciaDetalleService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IncidenciaDetalleRepositorio incidenciaDetalleRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public IncidenciaDetalleDTO create(IncidenciaDetalleDTO tablaDTO) {

        IncidenciaDetalle tabla=new IncidenciaDetalle();
        //IncidenciaDetalle tabla = mapearEntidad(IncidenciaDetalleDTO);
       /* tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setTipoIncidenciaDetalleId(tablaDTO.getTipoIncidenciaDetalleid());
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setIncidenciaDetalle(tablaDTO.getIncidenciaDetalle());
        tabla.setClave(tablaDTO.getClave());*/
        tabla.setEstado(1);

        System.out.println(MetodosGenerales.capturarFechaActual());

       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedNow = MetodosGenerales.capturarFechaActual().format(formatter);
        //System.out.println(formattedNow);
        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        IncidenciaDetalle nuevo = incidenciaDetalleRepositorio.save(tabla);
        IncidenciaDetalleDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<IncidenciaDetalleDTO> list() {
        List<IncidenciaDetalle> tablas = incidenciaDetalleRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public IncidenciaDetalleDTO listId(long id) {
        IncidenciaDetalle tabla = incidenciaDetalleRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaDetalle", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public IncidenciaDetalleDTO update(IncidenciaDetalleDTO tablaDTO, long id) {
        IncidenciaDetalle tabla = incidenciaDetalleRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaDetalle", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoIncidenciaDetalleId(tablaDTO.getTipoIncidenciaDetalleid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        IncidenciaDetalle actualizado = incidenciaDetalleRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public IncidenciaDetalleDTO cambioEstado(long id) {
        IncidenciaDetalle tabla = incidenciaDetalleRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaDetalle", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        IncidenciaDetalle actualizado = incidenciaDetalleRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        IncidenciaDetalle tabla = incidenciaDetalleRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IncidenciaDetalle", "id", id));
        incidenciaDetalleRepositorio.delete(tabla);
    }




    private IncidenciaDetalleDTO mapearDTO(IncidenciaDetalle tabla) {
        IncidenciaDetalleDTO tablaDTO = modelMapper.map(tabla, IncidenciaDetalleDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private IncidenciaDetalle mapearEntidad(IncidenciaDetalleDTO tablaDTO) {
        IncidenciaDetalle tabla = modelMapper.map(tablaDTO, IncidenciaDetalle.class);
        return tabla;
    }
}
