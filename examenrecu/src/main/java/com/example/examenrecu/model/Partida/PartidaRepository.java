package com.example.examenrecu.model.Partida;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<BeanPartida, Long> {

}
