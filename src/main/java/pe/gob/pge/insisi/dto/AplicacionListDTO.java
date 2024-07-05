package pe.gob.pge.insisi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AplicacionListDTO {
    private Long aplicacionId;
    private String nombre;
    private String descripcion;
    private Integer estado;
}
