package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.RequestBodyMenu;
import pe.gob.pge.insisi.dto.MenuDTO;
import pe.gob.pge.insisi.service.MenuService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/list")
    public List<MenuDTO> listTabla(){
        System.out.println("llega MenuDTO");
        return menuService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<MenuDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(menuService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<MenuDTO> createTabla(@RequestBody RequestBodyMenu tablaDTO) {
        System.out.println("Menu");
        return new ResponseEntity<>(menuService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MenuDTO> updateTabla(@Valid @RequestBody MenuDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        MenuDTO respuesta = menuService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        menuService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        menuService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
