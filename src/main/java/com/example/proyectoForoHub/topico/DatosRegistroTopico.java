package com.example.proyectoForoHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        @NotBlank String titulo,

        @NotBlank String mensaje,

        LocalDateTime fechaCreacion,

        @NotNull
        @Positive
        Long idUsuario,

        Boolean estado) {
}
