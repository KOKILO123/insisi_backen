package pe.gob.pge.insisi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestBodyInstitucion {
    private String nombre;
    private String descripcion;
    private String sigla;
    private Integer estado;
}
