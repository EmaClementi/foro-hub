package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.Curso;
import com.forohub.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull LocalDateTime fechaCreacion,
        @NotNull Status status,
        @NotNull Long autorId,
        @NotNull Long cursoId) {
}
