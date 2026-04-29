package com.hospital.msvc_pacientes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo run no puede ser vacio")
    @Pattern(regexp = "^\\d{7,8}-[\\dkK]$", message = "El formato del run debe ser xxxxxxxx-x")
    private String run;

    @Column(name = "nombre_completo", nullable = false)
    @NotBlank(message = "El campo nombre completo no puede ser vacio")
    private String nombreCompleto;

    @Column(name = "tipo_sangre", nullable = false)
    @NotBlank(message = "El campo tipo de sangre no puede ser vacio")
    private String tipoSangre;

    @Embedded
    private Audit audit = new Audit();
}
