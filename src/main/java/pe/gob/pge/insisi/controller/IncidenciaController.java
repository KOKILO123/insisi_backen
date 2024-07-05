package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.IncidenciaDTO;
import pe.gob.pge.insisi.dto.RequestBodyIncidencia;
import pe.gob.pge.insisi.service.IncidenciaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/incidencia")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;


    @GetMapping("/list")
    public List<IncidenciaDTO> listTabla(){
        System.out.println("llega IncidenciaDTO");
        return incidenciaService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<IncidenciaDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(incidenciaService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<IncidenciaDTO> createTabla(@RequestBody RequestBodyIncidencia tablaDTO) {
        System.out.println("Incidencia");
        return new ResponseEntity<>(incidenciaService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IncidenciaDTO> updateTabla(@Valid @RequestBody IncidenciaDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        IncidenciaDTO respuesta = incidenciaService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        incidenciaService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        incidenciaService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
