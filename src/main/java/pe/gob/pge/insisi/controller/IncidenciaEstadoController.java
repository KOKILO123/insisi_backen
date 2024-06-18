package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.IncidenciaEstadoDTO;
import pe.gob.pge.insisi.dto.RequestBodyIncidenciaEstado;
import pe.gob.pge.insisi.service.IncidenciaEstadoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/incidenciaEstado")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class IncidenciaEstadoController {

    @Autowired
    private IncidenciaEstadoService incidenciaEstadoService;


    @GetMapping("/list")
    public List<IncidenciaEstadoDTO> listTabla(){
        System.out.println("llega");
        return incidenciaEstadoService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<IncidenciaEstadoDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(incidenciaEstadoService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<IncidenciaEstadoDTO> createTabla(@RequestBody RequestBodyIncidenciaEstado tablaDTO) {
        System.out.println("IncidenciaEstado");
        return new ResponseEntity<>(incidenciaEstadoService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IncidenciaEstadoDTO> updateTabla(@Valid @RequestBody IncidenciaEstadoDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        IncidenciaEstadoDTO respuesta = incidenciaEstadoService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        incidenciaEstadoService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        incidenciaEstadoService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
