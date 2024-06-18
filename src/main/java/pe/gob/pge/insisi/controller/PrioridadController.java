package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.PrioridadDTO;
import pe.gob.pge.insisi.dto.RequestBodyPrioridad;
import pe.gob.pge.insisi.service.PrioridadService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/prioridad")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PrioridadController {

    @Autowired
    private PrioridadService prioridadService;


    @GetMapping("/list")
    public List<PrioridadDTO> listTabla(){
        System.out.println("llega");
        return prioridadService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<PrioridadDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(prioridadService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PrioridadDTO> createTabla(@RequestBody RequestBodyPrioridad tablaDTO) {
        System.out.println("Prioridad");
        return new ResponseEntity<>(prioridadService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PrioridadDTO> updateTabla(@Valid @RequestBody PrioridadDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        PrioridadDTO respuesta = prioridadService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        prioridadService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        prioridadService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
