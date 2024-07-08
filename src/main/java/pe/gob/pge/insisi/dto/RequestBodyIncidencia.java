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
    private Long areaId;
    private Long prioridadId;
    private Long usuarioId;
    private String fechaSolicitado;
    private String descripcion;
    private Integer estado;
}
