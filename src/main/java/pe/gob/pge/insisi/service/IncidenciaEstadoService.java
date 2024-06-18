 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.IncidenciaEstadoDTO;
 import pe.gob.pge.insisi.dto.RequestBodyIncidenciaEstado;

 import java.util.List;

 public interface IncidenciaEstadoService {

     public IncidenciaEstadoDTO create(RequestBodyIncidenciaEstado tablaDTO);
     public List<IncidenciaEstadoDTO> list();
     public IncidenciaEstadoDTO listId(long id);
     public IncidenciaEstadoDTO update(IncidenciaEstadoDTO tablaDTO, long id);
     public IncidenciaEstadoDTO cambioEstado(long id);
     public void delete(long id);

 }
