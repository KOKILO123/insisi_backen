package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "INCIDENCIA")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="incidenciaid")
    private Long incidenciaId;
    @Column(name="tipoincidenciaid")
    private Long tipoIncidenciaId;
    @Column(name="areaid")
    private Long areaId;
    @Column(name="prioridadid")
    private Long prioridadId;
    @Column(name="usuarioid")
    private Long usuarioId;
    @Column(name="fechasolicitado")
    private LocalDateTime fechaSolicitado;
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
