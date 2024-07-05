package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.RequestBodyTipoUsuarioMenu;
import pe.gob.pge.insisi.dto.TipoUsuarioMenuDTO;
import pe.gob.pge.insisi.projection.MenuTipoUsuarioProjection;
import pe.gob.pge.insisi.service.TipoUsuarioMenuService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipoUsuarioMenu")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TipoUsuarioMenuController {

    @Autowired
    private TipoUsuarioMenuService tipoUsuarioMenuService;


    @GetMapping("/list")
    public List<TipoUsuarioMenuDTO> listTabla(){
        System.out.println("llega TipoUsuarioMenuDTO");
        return tipoUsuarioMenuService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<TipoUsuarioMenuDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(tipoUsuarioMenuService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TipoUsuarioMenuDTO> createTabla(@RequestBody RequestBodyTipoUsuarioMenu tablaDTO) {
        System.out.println("TipoUsuarioMenu");
        return new ResponseEntity<>(tipoUsuarioMenuService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoUsuarioMenuDTO> updateTabla(@Valid @RequestBody TipoUsuarioMenuDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        TipoUsuarioMenuDTO respuesta = tipoUsuarioMenuService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        tipoUsuarioMenuService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        tipoUsuarioMenuService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


    @GetMapping("/listMenu/{tipoUsuarioId}")
    public List<MenuTipoUsuarioProjection> listTipoUsuarioMenu(@PathVariable(name = "tipoUsuarioId") long tipoUsuarioId){
        System.out.println("llega TipoUsuarioMenuDTO");
        return tipoUsuarioMenuService.listMenuTipoUsuario(tipoUsuarioId);
    }


}
