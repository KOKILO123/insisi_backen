package pe.gob.pge.insisi.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "INSTITUCION")
public class Institucion {
    @Id
    @Column(name="institucionid")
    private Long institucionId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="sigla")
    private String sigla;
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
