package pe.gob.pge.insisi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IncidenciaDetalleDTO {
    private Long incidenciaDetId;
    private Long incidenciaId;
    private Long usuarioAsigId;
    private Long incidenciaEstadoId;
    private LocalDateTime fecha;
    private String descripcion;
    private Integer estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
