package com.forohub.foro.controller;

import com.forohub.foro.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {


    @Autowired
    TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity crearTopico(@RequestBody @Valid DatosCrearTopico datos){

        var topico = topicoService.crearTopico(datos);

        return ResponseEntity.ok(topico);
    }

    @GetMapping
    @Transactional
    public ResponseEntity listarTopicos(){
        List<DatosListaTopico> topicos = topicoService.listar();

        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/id/{id}")
    @Transactional
    public ResponseEntity mostrarUnTopico(@PathVariable Long id){
        var topico = topicoService.buscarTopico(id);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @GetMapping("/status/{status}")
    @Transactional
    public ResponseEntity buscarPorEstado(@PathVariable Status status){
        List<DatosListaTopico> topicos = topicoService.buscarTopicoPorEstado(status);

        return ResponseEntity.ok(topicos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity modificarTopico(@RequestBody @Valid DatosActualizarTopico datos ){
        var topico = topicoService.buscarTopico(datos.id());
        topicoService.editarTopico(topico,datos);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico));

    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){

        topicoService.eliminar(id);

        return ResponseEntity.noContent().build();

    }
}
