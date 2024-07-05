 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.AplicacionDTO;
 import pe.gob.pge.insisi.dto.AplicacionListDTO;
 import pe.gob.pge.insisi.dto.RequestBodyAplicacion;

 import java.util.List;

 public interface AplicacionService {

     public AplicacionDTO create(RequestBodyAplicacion tablaDTO);
     public List<AplicacionListDTO> list();
     public AplicacionDTO listId(long id);
     public AplicacionDTO update(AplicacionDTO tablaDTO, long id);
     public AplicacionDTO cambioEstado(long id);
     public void delete(long id);

 }
