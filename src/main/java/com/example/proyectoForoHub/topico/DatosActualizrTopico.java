package com.example.proyectoForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizrTopico(@NotNull Long id, String titulo, String mensaje) {

}
