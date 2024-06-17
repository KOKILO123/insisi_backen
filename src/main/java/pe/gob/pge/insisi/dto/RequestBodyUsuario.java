package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyUsuario {
    private Long institucionId;
    private Long areaId;
    private Long tipoUsuarioid;
    private String nombre;
    private String usuario;
    private String clave;
    private Integer estado;
}
