package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.AplicacionDTO;
import pe.gob.pge.insisi.dto.AplicacionListDTO;
import pe.gob.pge.insisi.dto.RequestBodyAplicacion;
import pe.gob.pge.insisi.service.AplicacionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/aplicacion")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AplicacionController {

    @Autowired
    private AplicacionService aplicacionService;


    @GetMapping("/list")
    public List<AplicacionListDTO> listTabla(){
        System.out.println("llega AplicacionListDTO");
        System.out.println("apl   "+aplicacionService.list());
        return aplicacionService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<AplicacionDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(aplicacionService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AplicacionDTO> createTabla(@RequestBody RequestBodyAplicacion tablaDTO) {
        System.out.println("Aplicacion ");
        return new ResponseEntity<>(aplicacionService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AplicacionDTO> updateTabla(@Valid @RequestBody AplicacionDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        AplicacionDTO respuesta = aplicacionService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        aplicacionService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        aplicacionService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
