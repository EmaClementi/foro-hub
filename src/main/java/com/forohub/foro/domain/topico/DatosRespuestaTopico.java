package com.forohub.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion());
    }
}
