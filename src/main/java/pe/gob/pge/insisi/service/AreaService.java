 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.AreaDTO;
 import pe.gob.pge.insisi.dto.RequestBodyArea;

 import java.util.List;

 public interface AreaService {

     public AreaDTO create(RequestBodyArea tablaDTO);
     public List<AreaDTO> list();
     public AreaDTO listId(long id);
     public AreaDTO update(AreaDTO tablaDTO, long id);
     public AreaDTO cambioEstado(long id);
     public void delete(long id);

 }
