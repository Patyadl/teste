package com.example.curriculo.Service;

import com.example.curriculo.Model.Habilidades;
import com.example.curriculo.Repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadesService {

    @Autowired
    private HabilidadesRepository habilidadesRepository;

    public List<Habilidades> getAllHabilidades() {
        return habilidadesRepository.findAll();
    }

    public Optional<Habilidades> getHabilidadesById(Long id) {
        return habilidadesRepository.findById(id);
    }

    public Habilidades criarHabilidades(Habilidades Habilidades) {
        return habilidadesRepository.save(Habilidades);
    }

    public Habilidades atualizarHabilidades(Long id, Habilidades habilidadesDetails) throws Exception {
        Optional<Habilidades> Habilidades = habilidadesRepository.findById(id);

        if (Habilidades.isPresent()) {
            Habilidades habilidades = Habilidades.get();

            habilidades.setNome(habilidadesDetails.getNome());
            habilidades.setTempo(habilidadesDetails.getTempo());
            return habilidadesRepository.save(habilidades);
        }
        else {
            throw new Exception("Habilidades não encontrado com o id: " + id);
        }
    }

    public void deletarHabilidades(@PathVariable Long id) {
        Optional<Habilidades> optionalHabilidades = habilidadesRepository.findById(id);

        if (optionalHabilidades.isPresent()) {
            Habilidades habilidades= optionalHabilidades.get();
            habilidadesRepository.delete(habilidades);
        }
    }

}