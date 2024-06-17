package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuarioid")
    private Long usuarioId;
    @Column(name="institucionid")
    private Long institucionId;
    @Column(name="areaid")
    private Long areaId;
    @Column(name="tipousuarioid")
    private Long tipoUsuarioId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="usuario")
    private String usuario;
    @Column(name="clave")
    private String clave;
    @Column(name="estado")
    private Integer estado;
    @Column(name="token")
    private String token;
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
