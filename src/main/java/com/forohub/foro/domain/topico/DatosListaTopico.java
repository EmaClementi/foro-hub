package com.forohub.foro.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListaTopico(
        @NotNull Long id,
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull LocalDateTime fechaCreacion,
        @NotNull Status status,
        @NotNull Long autorId,
        @NotNull Long cursoId
) {
    public DatosListaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
