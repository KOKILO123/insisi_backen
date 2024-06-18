package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.TipoIncidenciaDTO;
import pe.gob.pge.insisi.dto.RequestBodyTipoIncidencia;
import pe.gob.pge.insisi.service.TipoIncidenciaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipoIncidencia")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TipoIncidenciaController {

    @Autowired
    private TipoIncidenciaService tipoIncidenciaService;


    @GetMapping("/list")
    public List<TipoIncidenciaDTO> listTabla(){
        System.out.println("llega");
        return tipoIncidenciaService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<TipoIncidenciaDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(tipoIncidenciaService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TipoIncidenciaDTO> createTabla(@RequestBody RequestBodyTipoIncidencia tablaDTO) {
        System.out.println("TipoIncidencia");
        return new ResponseEntity<>(tipoIncidenciaService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoIncidenciaDTO> updateTabla(@Valid @RequestBody TipoIncidenciaDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        TipoIncidenciaDTO respuesta = tipoIncidenciaService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        tipoIncidenciaService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        tipoIncidenciaService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
