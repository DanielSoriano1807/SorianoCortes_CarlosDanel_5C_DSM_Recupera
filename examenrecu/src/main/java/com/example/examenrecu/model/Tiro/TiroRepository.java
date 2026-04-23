package com.example.examenrecu.model.Tiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiroRepository extends JpaRepository<BeanTiro, Long> {
}
