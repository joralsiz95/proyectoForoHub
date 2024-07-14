package com.example.proyectoForoHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime fechaCreacion;
    private Long idUsuario;
    private Boolean estado;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.mensaje = datosRegistroTopico.mensaje();
        this.titulo = datosRegistroTopico.titulo();
        this.fechaCreacion = LocalDateTime.now();
        this.idUsuario = datosRegistroTopico.idUsuario();
        this.estado = true;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void actualizarDatos(DatosActualizrTopico datosActualizrTopico) {
        if (datosActualizrTopico.titulo() != null){
            this.titulo = datosActualizrTopico.titulo();
        }
        if (datosActualizrTopico.mensaje() != null){
            this.mensaje = datosActualizrTopico.mensaje();
        }
    }

    public void desactivarTopico() {
        this.estado = false;
    }
}
