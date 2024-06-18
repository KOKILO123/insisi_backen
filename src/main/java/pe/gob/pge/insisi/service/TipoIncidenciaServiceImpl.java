package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.RequestBodyTipoIncidencia;
import pe.gob.pge.insisi.dto.TipoIncidenciaDTO;
import pe.gob.pge.insisi.entity.TipoIncidencia;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.TipoIncidenciaRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoIncidenciaServiceImpl implements TipoIncidenciaService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TipoIncidenciaRepositorio tipoIncidenciaRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public TipoIncidenciaDTO create(RequestBodyTipoIncidencia tablaDTO) {

        TipoIncidencia tabla=new TipoIncidencia();
        tabla.setAplicacionId(tablaDTO.getApliacionId());
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setEstado(1);

        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        TipoIncidencia nuevo = tipoIncidenciaRepositorio.save(tabla);
        TipoIncidenciaDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<TipoIncidenciaDTO> list() {
        List<TipoIncidencia> tablas = tipoIncidenciaRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public TipoIncidenciaDTO listId(long id) {
        TipoIncidencia tabla = tipoIncidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoIncidencia", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public TipoIncidenciaDTO update(TipoIncidenciaDTO tablaDTO, long id) {
        TipoIncidencia tabla = tipoIncidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoIncidencia", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoTipoIncidenciaId(tablaDTO.getTipoTipoIncidenciaid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        TipoIncidencia actualizado = tipoIncidenciaRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public TipoIncidenciaDTO cambioEstado(long id) {
        TipoIncidencia tabla = tipoIncidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoIncidencia", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        TipoIncidencia actualizado = tipoIncidenciaRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        TipoIncidencia tabla = tipoIncidenciaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoIncidencia", "id", id));
        tipoIncidenciaRepositorio.delete(tabla);
    }




    private TipoIncidenciaDTO mapearDTO(TipoIncidencia tabla) {
        TipoIncidenciaDTO tablaDTO = modelMapper.map(tabla, TipoIncidenciaDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private TipoIncidencia mapearEntidad(TipoIncidenciaDTO tablaDTO) {
        TipoIncidencia tabla = modelMapper.map(tablaDTO, TipoIncidencia.class);
        return tabla;
    }
}
