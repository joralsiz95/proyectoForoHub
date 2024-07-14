package com.example.proyectoForoHub.controller;

import com.example.proyectoForoHub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        System.out.println("El request llego correctamente");
        System.out.println(datosRegistroTopico);
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(Pageable paginacion){
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); Muestra los topicos activos y no activos
        return topicoRepository.findByEstadoTrue(paginacion).map(DatosListadoTopico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizrTopico datosActualizrTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizrTopico.id());
        topico.actualizarDatos(datosActualizrTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
//    Eliminar por completo un topico de la base de datos
//    public void eliminarTopico(@PathVariable Long id){
//        Topico topico = topicoRepository.getReferenceById(id);
//        topicoRepository.delete(topico);
//    }

    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }
}
