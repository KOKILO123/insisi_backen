package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.RequestBodyUsuario;
import pe.gob.pge.insisi.dto.RequestLoginUsuario;
import pe.gob.pge.insisi.dto.UsuarioDTO;
import pe.gob.pge.insisi.service.UsuarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/list")
    public List<UsuarioDTO> listTabla(){
        System.out.println("llega UsuarioDTO");
        return usuarioService.list();
    }

    @GetMapping("/listId/{id}")
    public ResponseEntity<UsuarioDTO> listIdTabla(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(usuarioService.listId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createTabla(@RequestBody RequestBodyUsuario tablaDTO) {
        System.out.println("dfsdfsdfsdfsdfs");
        return new ResponseEntity<>(usuarioService.create(tablaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioDTO> updateTabla(@Valid @RequestBody UsuarioDTO tablaDTO,
                                                  @PathVariable(name = "id") long id) {
        UsuarioDTO respuesta = usuarioService.update(tablaDTO, id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/cambioEstado/{id}")
    public ResponseEntity<String> updateDeleteTabla(@PathVariable(name = "id") long id) {
        usuarioService.cambioEstado(id);
        return new ResponseEntity<>("Se realizó el cambio de estado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTabla(@PathVariable(name = "id") long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>("Se realizó la eliminación con éxito", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<List<UsuarioDTO>> loginUser(@RequestBody RequestLoginUsuario login) {
        //System.out.println("dfsdfsdfsdfsdfs u :"+login.getUsuario()+" - clave : "+login.getClave());
        //return new ResponseEntity<>(usuarioService.create(tablaDTO), HttpStatus.CREATED);
        List<UsuarioDTO> respuesta = usuarioService.listLogin(login.getUsuario(),login.getClave());
        //System.out.println(respuesta.getUsuario());
        //if(respuesta.getUsuario())
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
