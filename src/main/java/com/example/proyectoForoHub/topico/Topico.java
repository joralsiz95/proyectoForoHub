package com.example.proyectoForoHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private Long idUsuario;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.mensaje = datosRegistroTopico.mensaje();
        this.titulo = datosRegistroTopico.titulo();
        this.fechaCreacion = LocalDate.now();
        this.idUsuario = datosRegistroTopico.idUsuario();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void actualizarDatos(DatosActualizrTopico datosActualizrTopico) {
        if (datosActualizrTopico.titulo() != null){
            this.titulo = datosActualizrTopico.titulo();
        }
        if (datosActualizrTopico.mensaje() != null){
            this.mensaje = datosActualizrTopico.mensaje();
        }
    }
}
