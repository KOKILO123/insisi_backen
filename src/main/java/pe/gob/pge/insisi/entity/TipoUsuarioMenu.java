package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TIPO_USUARIO_MENU")
public class TipoUsuarioMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipousuariomenuid")
    private Long tipoUsuarioMenuId;
    @Column(name="tipousuarioid")
    private Long tipoUsuarioId;
    @Column(name="menuid")
    private Long menuId;
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
