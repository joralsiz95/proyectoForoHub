package com.example.proyectoForoHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record DatosRegistroTopico(

        @NotBlank String titulo,

        @NotBlank String mensaje,

        LocalDate fechaCreacion,

        @NotNull
        @Positive
        Long idUsuario) {
}
