package com.example.curriculo.Repository;

import com.example.curriculo.Model.Trabalhos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhosRepository  extends JpaRepository<Trabalhos, Long> {
}
