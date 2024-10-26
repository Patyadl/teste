package com.example.curriculo.Service;

import com.example.curriculo.Model.Cursos;
import com.example.curriculo.Repository.CursosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    public List<Cursos> getAllCursos() {
        return cursosRepository.findAll();
    }

    public Optional<Cursos> getCursosById(Long id) {
        return cursosRepository.findById(id);
    }


    public Cursos criarCurso(Cursos cursos) {
        return cursosRepository.save(cursos);
    }


    public Cursos atualizarCurso(Long id, Cursos cursosDetails) throws Exception {
        Optional<Cursos> Cursos = cursosRepository.findById(id);

        if (Cursos.isPresent()) {
            Cursos cursos = Cursos.get();

            cursos.setNome(cursosDetails.getNome());
            cursos.setInstituicao(cursosDetails.getInstituicao());
            cursos.setInicio(cursosDetails.getInicio());
            cursos.setFim(cursosDetails.getFim());
            cursos.setDescricao(cursosDetails.getDescricao());
            return cursosRepository.save(cursos);
        }
        else {
            throw new Exception("Curso não encontrado com o id: " + id);
        }
    }

    public void deletarCurso(@PathVariable Long id) {
        Optional<Cursos> optionalCurso = cursosRepository.findById(id);

        if (optionalCurso.isPresent()) {
            Cursos cursos = optionalCurso.get();
            cursosRepository.delete(cursos);
        }
    }

}


