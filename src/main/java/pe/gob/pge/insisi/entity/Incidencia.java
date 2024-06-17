package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "INCIDENCIA")
public class Incidencia {
    @Id
    @Column(name="incidenciaid")
    private Long incidenciaId;
    @Column(name="tipoIncidenciaid")
    private Long tipoIncidenciaId;
    @Column(name="areaid")
    private Long areaId;
    @Column(name="prioridadid")
    private Long prioridadId;
    @Column(name="fechasolicitado")
    private LocalDateTime fechaSolicitado;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="estado")
    private Integer estado;
    @Column(name="createdat")
    private LocalDateTime createdAt;
    @Column(name="updatedat")
    private LocalDateTime updatedAt;
    @Column(name="createdby")
    private Long createdBy;
    @Column(name="updatedby")
    private Long updatedBy;
    @Column(name="deletedby")
    private Long deletedBy;
}
