package com.example.curriculo.Service;

import com.example.curriculo.Model.Trabalhos;
import com.example.curriculo.Repository.TrabalhosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhosService {

    @Autowired
    private TrabalhosRepository trabalhosRepository;

    public List<Trabalhos> getAllTrabalhos() {
        return trabalhosRepository.findAll();
    }

    public Optional<Trabalhos> getTrabalhosById(Long id) {
        return trabalhosRepository.findById(id);
    }

    public Trabalhos criarTrabalhos(Trabalhos trabalhos) {
        return trabalhosRepository.save(trabalhos);
    }

    public Trabalhos atualizarTrabalhos(Long id, Trabalhos trabalhosDetails) throws Exception {
        Optional<Trabalhos> Trabalhos = trabalhosRepository.findById(id);

        if (Trabalhos.isPresent()) {
            Trabalhos trabalhos = Trabalhos.get();

            trabalhos.setNome(trabalhosDetails.getNome());
            trabalhos.setTempo(trabalhosDetails.getTempo());
            return trabalhosRepository.save(trabalhos);
        }
        else {
            throw new Exception("Trabalhos não encontrado com o id: " + id);
        }
    }

    public void deletarTrabalhos(@PathVariable Long id) {
        Optional<Trabalhos> optionalTrabalhos = trabalhosRepository.findById(id);

        if (optionalTrabalhos.isPresent()) {
            Trabalhos trabalhos= optionalTrabalhos.get();
           trabalhosRepository.delete(trabalhos);
        }
    }

}