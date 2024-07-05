package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.RequestBodyArea;
import pe.gob.pge.insisi.dto.AreaDTO;
import pe.gob.pge.insisi.service.AreaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/area")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AreaController {

    @Autowired
    private AreaService AreaService;


    @GetMapping("/list")
    public List<AreaDTO> listTabla(){
        System.out.println("llega AreaDTO");
        return AreaService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<AreaDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(AreaService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AreaDTO> createTabla(@RequestBody RequestBodyArea tablaDTO) {
        System.out.println("area");
        return new ResponseEntity<>(AreaService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AreaDTO> updateTabla(@Valid @RequestBody AreaDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        AreaDTO respuesta = AreaService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        AreaService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        AreaService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }


}
