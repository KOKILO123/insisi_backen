package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "INCIDENCIA_DETALLE")
public class IncidenciaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="incidenciadetid")
    private Long incidenciaDetId;
    @Column(name="incidenciaid")
    private Long incidenciaId;
    @Column(name="usuarioasigid")
    private Long usuarioAsigId;
    @Column(name="incidenciaestadoid")
    private Long incidenciaEstadoId;
    @Column(name="fecha")
    private LocalDateTime fecha;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="estado")
    private Integer estado;
    @Column(name="createdat")
    private Date createdAt;
    @Column(name="updatedat")
    private Date updatedAt;
    @Column(name="createdby")
    private Long createdBy;
    @Column(name="updatedby")
    private Long updatedBy;
    @Column(name="deletedby")
    private Long deletedBy;
}
