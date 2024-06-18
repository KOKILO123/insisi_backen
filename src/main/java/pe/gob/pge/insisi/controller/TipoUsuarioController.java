package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.TipoUsuarioDTO;
import pe.gob.pge.insisi.dto.RequestBodyTipoUsuario;
import pe.gob.pge.insisi.service.TipoUsuarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipoUsuario")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;


    @GetMapping("/list")
    public List<TipoUsuarioDTO> listTabla(){
        System.out.println("llega");
        return tipoUsuarioService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<TipoUsuarioDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(tipoUsuarioService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TipoUsuarioDTO> createTabla(@RequestBody RequestBodyTipoUsuario tablaDTO) {
        System.out.println("TipoUsuario");
        return new ResponseEntity<>(tipoUsuarioService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoUsuarioDTO> updateTabla(@Valid @RequestBody TipoUsuarioDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        TipoUsuarioDTO respuesta = tipoUsuarioService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        tipoUsuarioService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        tipoUsuarioService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
