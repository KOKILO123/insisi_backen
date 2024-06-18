 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.PrioridadDTO;
 import pe.gob.pge.insisi.dto.RequestBodyPrioridad;

 import java.util.List;

 public interface PrioridadService {

     public PrioridadDTO create(RequestBodyPrioridad tablaDTO);
     public List<PrioridadDTO> list();
     public PrioridadDTO listId(long id);
     public PrioridadDTO update(PrioridadDTO tablaDTO, long id);
     public PrioridadDTO cambioEstado(long id);
     public void delete(long id);

 }
