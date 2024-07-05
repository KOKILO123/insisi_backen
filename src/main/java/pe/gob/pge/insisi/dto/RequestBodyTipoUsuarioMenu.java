package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyTipoUsuarioMenu {
    private long tipoUsuarioId;
    private long menuId;
    private Integer estado;
}
