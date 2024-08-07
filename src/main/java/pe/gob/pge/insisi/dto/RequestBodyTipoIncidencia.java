package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyTipoIncidencia {
    private Long aplicacionId;
    private String nombre;
    private String descripcion;
    private Integer estado;
}
