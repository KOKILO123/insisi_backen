package pe.gob.pge.insisi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstitucionDTO {
    private Long institucionId;
    private String nombre;
    private String descripcion;
    private String sigla;
    private Integer estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
