package pe.gob.pge.insisi.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyIncidencia {
    private Long tipoIncidenciaId;
    private Long areId;
    private Long prioridadId;
    private Date fechaSolicitado;
    private String descripcion;
    private Integer estado;
}
