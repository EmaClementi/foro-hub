package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.ValidacionException;
import com.forohub.foro.domain.curso.CursoRepository;
import com.forohub.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public DatosRespuestaTopico crearTopico(DatosCrearTopico datos){

        if(!usuarioRepository.existsById(datos.autorId())){
            throw new ValidacionException("No existe un usuario con ese id");
        }
        if(!cursoRepository.existsById(datos.cursoId())){
            throw new ValidacionException("No existe un curso con ese id");
        }

        var curso = cursoRepository.findById(datos.cursoId()).get();
        var usuario = usuarioRepository.findById(datos.autorId()).get();


        var topico = new Topico(null,datos.titulo(),datos.mensaje(),datos.fechaCreacion(),datos.status(),usuario,curso);

        topicoRepository.save(topico);

        return new DatosRespuestaTopico(topico);
    }

    public List<DatosListaTopico> listar() {

        List<DatosListaTopico> topicos = topicoRepository.findAll()
                .stream()
                .map(t -> new DatosListaTopico(t.getId(),t.getTitulo(),t.getMensaje(),t.getFechaCreacion(),t.getStatus(),t.getAutor().getId(), t.getCurso().getId()))
                        .toList();

        return topicos;
    }

    public Topico buscarTopico(Long id) {

        if(!topicoRepository.existsById(id)){
            throw new ValidacionException("No existe un topico con ese id");
        }
        var topico = topicoRepository.findById(id).get();

        return topico;
    }

    public void editarTopico(Topico topico,DatosActualizarTopico datos){

        if(!usuarioRepository.existsById(datos.autorId())){
            throw new ValidacionException("No existe un usuario con ese id");
        }
        if(!cursoRepository.existsById(datos.cursoId())){
            throw new ValidacionException("No existe un curso con ese id");
        }

        var autor = usuarioRepository.findById(datos.autorId()).get();
        var curso = cursoRepository.findById(datos.cursoId()).get();


        topico.actualizarTopico(datos, autor,curso);
    }


    public void eliminar(Long id) {
        if(!topicoRepository.existsById(id)){
            throw new ValidacionException("No existe un topico con ese id");
        }
        topicoRepository.deleteById(id);
    }

    public List<DatosListaTopico> buscarTopicoPorEstado(Status status) {
        List<DatosListaTopico> topicos = topicoRepository.findByStatus(status).stream()
                .map(t -> new DatosListaTopico(t.getId(),t.getTitulo(),t.getMensaje(),t.getFechaCreacion(),t.getStatus(),t.getAutor().getId(),t.getCurso().getId()))
                .toList();

        if(topicos != null && !topicos.isEmpty()){

            return topicos;
        }else {
            throw new ValidacionException("No existe un topico con ese estado");
        }

    }
}
