package pe.gob.pge.insisi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.pge.insisi.dto.InstitucionDTO;
import pe.gob.pge.insisi.dto.RequestBodyInstitucion;
import pe.gob.pge.insisi.entity.Institucion;
import pe.gob.pge.insisi.exception.ResourceNotFoundException;
import pe.gob.pge.insisi.repository.InstitucionRepositorio;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;
import pe.gob.pge.insisi.utility.MetodosGenerales;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitucionServiceImpl implements InstitucionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private InstitucionRepositorio institucionRepositorio;
    private UsuarioSesionRepositorio usuarioSesionRepositorio;

    @Override
    public InstitucionDTO create(RequestBodyInstitucion tablaDTO) {

        Institucion tabla=new Institucion();
        tabla.setNombre(tablaDTO.getNombre());
        tabla.setDescripcion(tablaDTO.getDescripcion());
        tabla.setSigla(tablaDTO.getSigla());
        tabla.setEstado(1);

        System.out.println(MetodosGenerales.capturarFechaActual());

       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedNow = MetodosGenerales.capturarFechaActual().format(formatter);
        //System.out.println(formattedNow);
        tabla.setCreatedAt(MetodosGenerales.capturarFechaActual());
        //tabla.setCreatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));

        System.out.println(tabla);

        Institucion nuevo = institucionRepositorio.save(tabla);
        InstitucionDTO respuesta = mapearDTO(nuevo);
        return respuesta;
        //return null;
    }

    @Override
    public List<InstitucionDTO> list() {
        List<Institucion> tablas = institucionRepositorio.list();
        return tablas.stream().map(tabla -> mapearDTO(tabla)).collect(Collectors.toList());
        //return Collections.emptyList();
    }

    @Override
    public InstitucionDTO listId(long id) {
        Institucion tabla = institucionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));
        return mapearDTO(tabla);
    }

    @Override
    public InstitucionDTO update(InstitucionDTO tablaDTO, long id) {
        Institucion tabla = institucionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));

        /*tabla.setNombre(tablaDTO.getNombre());
        tabla.setAreaId(tablaDTO.getAreaId());
        tabla.setClave(tablaDTO.getClave());
        tabla.setToken(tablaDTO.getToken());
        tabla.setInstitucionId(tablaDTO.getInstitucionId());
        tabla.setTipoInstitucionId(tablaDTO.getTipoInstitucionid());*/

        tabla.setUpdatedAt(MetodosGenerales.capturarFechaActual());
        tabla.setUpdatedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Institucion actualizado = institucionRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public InstitucionDTO cambioEstado(long id) {
        Institucion tabla = institucionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));
        tabla.setEstado(0);
        tabla.setDeletedBy(MetodosGenerales.captutarUsuarioID(usuarioSesionRepositorio));
        Institucion actualizado = institucionRepositorio.save(tabla);
        return mapearDTO(actualizado);
    }

    @Override
    public void delete(long id) {
        Institucion tabla = institucionRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));
        institucionRepositorio.delete(tabla);
    }




    private InstitucionDTO mapearDTO(Institucion tabla) {
        InstitucionDTO tablaDTO = modelMapper.map(tabla, InstitucionDTO.class);
        return tablaDTO;
    }
    // Convierte de DTO a Entidad
    private Institucion mapearEntidad(InstitucionDTO tablaDTO) {
        Institucion tabla = modelMapper.map(tablaDTO, Institucion.class);
        return tabla;
    }
}
