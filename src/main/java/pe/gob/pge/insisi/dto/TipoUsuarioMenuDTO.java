package pe.gob.pge.insisi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoUsuarioMenuDTO {
    private Long tipoUsuarioMenuId;
    private Long tipoUsuarioId;
    private Long menuId;
    private Integer estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
