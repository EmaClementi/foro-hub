package com.forohub.foro.domain.topico;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByStatus(Status status);
}
