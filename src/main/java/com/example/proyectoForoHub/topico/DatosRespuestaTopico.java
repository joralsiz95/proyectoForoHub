package com.example.proyectoForoHub.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion) {
}
