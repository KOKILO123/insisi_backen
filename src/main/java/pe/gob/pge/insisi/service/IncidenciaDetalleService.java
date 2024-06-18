 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.IncidenciaDetalleDTO;

 import java.util.List;

 public interface IncidenciaDetalleService {

     public IncidenciaDetalleDTO create(IncidenciaDetalleDTO tablaDTO);
     public List<IncidenciaDetalleDTO> list();
     public IncidenciaDetalleDTO listId(long id);
     public IncidenciaDetalleDTO update(IncidenciaDetalleDTO tablaDTO, long id);
     public IncidenciaDetalleDTO cambioEstado(long id);
     public void delete(long id);

 }
