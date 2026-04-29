package com.hospital.msvc_pacientes.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AtencionDTO {
    private Long atencionId;
    private Long medicoId;
    private Long pacienteId;
    private Double costo;
    private String comentario;
}
