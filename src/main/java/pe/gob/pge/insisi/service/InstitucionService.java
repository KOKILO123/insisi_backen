 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.InstitucionDTO;
 import pe.gob.pge.insisi.dto.RequestBodyInstitucion;

 import java.util.List;

 public interface InstitucionService {

     public InstitucionDTO create(RequestBodyInstitucion tablaDTO);
     public List<InstitucionDTO> list();
     public InstitucionDTO listId(long id);
     public InstitucionDTO update(InstitucionDTO tablaDTO, long id);
     public InstitucionDTO cambioEstado(long id);
     public void delete(long id);

 }
