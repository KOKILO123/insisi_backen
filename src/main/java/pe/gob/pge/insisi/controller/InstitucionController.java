package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.InstitucionDTO;
import pe.gob.pge.insisi.dto.RequestBodyInstitucion;
import pe.gob.pge.insisi.service.InstitucionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/institucion")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;


    @GetMapping("/list")
    public List<InstitucionDTO> listTabla(){
        System.out.println("llega");
        return institucionService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<InstitucionDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(institucionService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<InstitucionDTO> createTabla(@RequestBody RequestBodyInstitucion tablaDTO) {
        System.out.println("Institucion");
        return new ResponseEntity<>(institucionService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InstitucionDTO> updateTabla(@Valid @RequestBody InstitucionDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        InstitucionDTO respuesta = institucionService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        institucionService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        institucionService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
