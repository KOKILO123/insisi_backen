package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyPrioridad {
    private String nombre;
    private String descripcion;
    private Integer estado;
}
