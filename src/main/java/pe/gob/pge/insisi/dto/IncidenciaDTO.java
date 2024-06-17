package pe.gob.pge.insisi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IncidenciaDTO {
    private Long incidenciaId;
    private Long tipoIncidenciaId;
    private Long areaId;
    private Long prioridadId;
    private LocalDateTime fechaSolicitado;
    private String descripcion;
    private Integer estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
