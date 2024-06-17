package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario {
    @Id
    @Column(name="tipousuarioid")
    private Long tipoUsuarioId;
    @Column(name="nombre")
    private String nombre;
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
