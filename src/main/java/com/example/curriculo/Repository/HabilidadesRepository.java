package com.example.curriculo.Repository;

import com.example.curriculo.Model.Cursos;
import com.example.curriculo.Model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
}
