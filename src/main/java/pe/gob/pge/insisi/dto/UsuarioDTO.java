package pe.gob.pge.insisi.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDTO {
    private Long usuarioId;
    private Long institucionId;
    private Long areaId;
    private Long tipoUsuarioid;
    private String nombre;
    private String usuario;
    private String clave;
    private Integer estado;
    private String token;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
