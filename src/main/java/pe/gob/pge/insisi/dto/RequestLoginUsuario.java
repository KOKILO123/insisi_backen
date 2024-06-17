package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestLoginUsuario {
    private String usuario;
    private String clave;
}
