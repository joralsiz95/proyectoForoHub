package com.example.proyectoForoHub.topico;

import java.time.LocalDate;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDate fechaCreacion) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
