package pe.gob.pge.insisi.dto;

import java.time.LocalDateTime;

public class TipoUsuarioDTO {
    private Long tipoUsuarioId;
    private String nombre;
    private String descripcion;
    private Integer estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
