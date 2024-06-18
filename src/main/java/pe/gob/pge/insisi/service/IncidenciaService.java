 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.IncidenciaDTO;

 import java.util.List;

 public interface IncidenciaService {

     public IncidenciaDTO create(IncidenciaDTO tablaDTO);
     public List<IncidenciaDTO> list();
     public IncidenciaDTO listId(long id);
     public IncidenciaDTO update(IncidenciaDTO tablaDTO, long id);
     public IncidenciaDTO cambioEstado(long id);
     public void delete(long id);

 }
