package pe.gob.pge.insisi.id;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Builder
@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@IdClass(InstitucionId.class)
public class InstitucionId implements Serializable {

    static final long serialVersionUID = -1372485264771082695L;
    @Column(name="INSTITUCION_ID")
    Integer institucionId;

    @Column(name="USUARIO_ID")
    Integer usuarioId;
}
