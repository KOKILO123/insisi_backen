package pe.gob.pge.insisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.pge.insisi.dto.AreaDTO;
import pe.gob.pge.insisi.dto.RequestBodyArea;
import pe.gob.pge.insisi.projection.DashboardProjection;
import pe.gob.pge.insisi.service.AreaService;
import pe.gob.pge.insisi.service.IncidenciaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DashboardController {

    @Autowired
    private IncidenciaService incidenciaService;


    @GetMapping("/list/{estado}")
    public List<DashboardProjection> listTabla(@PathVariable(name = "estado") Integer estado){
        System.out.println("llega DashboardProjection");
        return incidenciaService.getListDashboard(estado);
    }




}
