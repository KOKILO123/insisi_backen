 package pe.gob.pge.insisi.service;

 import pe.gob.pge.insisi.dto.RequestBodyMenu;
 import pe.gob.pge.insisi.dto.MenuDTO;

 import java.util.List;

 public interface MenuService {

     public MenuDTO create(RequestBodyMenu tablaDTO);
     public List<MenuDTO> list();
     public MenuDTO listId(long id);
     public MenuDTO update(MenuDTO tablaDTO, long id);
     public MenuDTO cambioEstado(long id);
     public void delete(long id);

 }
