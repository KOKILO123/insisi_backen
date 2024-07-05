package pe.gob.pge.insisi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "MENU")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menuid")
    private Long menuId;
    @Column(name="nombre")
    private String nombre;
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
