 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.IncidenciaDTO;
 import pe.gob.pge.insisi.dto.RequestBodyIncidencia;

 import java.util.List;

 public interface IncidenciaService {

     public IncidenciaDTO create(RequestBodyIncidencia tablaDTO);
     public List<IncidenciaDTO> list();
     public IncidenciaDTO listId(long id);
     public IncidenciaDTO update(IncidenciaDTO tablaDTO, long id);
     public IncidenciaDTO cambioEstado(long id);
     public void delete(long id);

 }
