package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyIncidenciaEstado {
    private String nombre;
    private String descripcion;
    private Integer estado;
}
