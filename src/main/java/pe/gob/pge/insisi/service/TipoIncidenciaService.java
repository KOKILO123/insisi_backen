 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.RequestBodyTipoIncidencia;
 import pe.gob.pge.insisi.dto.TipoIncidenciaDTO;

 import java.util.List;

 public interface TipoIncidenciaService {

     public TipoIncidenciaDTO create(RequestBodyTipoIncidencia tablaDTO);
     public List<TipoIncidenciaDTO> list();
     public TipoIncidenciaDTO listId(long id);
     public TipoIncidenciaDTO update(TipoIncidenciaDTO tablaDTO, long id);
     public TipoIncidenciaDTO cambioEstado(long id);
     public void delete(long id);

 }
