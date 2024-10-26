package com.example.curriculo.Controller;

import com.example.curriculo.Model.Trabalhos;
import com.example.curriculo.Service.TrabalhosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhosController {

    @Autowired
    private TrabalhosService trabalhosService;

    @GetMapping
    public List<Trabalhos> getAllTrabalhos() {
        return trabalhosService.getAllTrabalhos();
    }

    @GetMapping("/{id}")
    public Trabalhos getTrabalhosById(@PathVariable Long id) {
        return trabalhosService.getTrabalhosById(id).orElse(null);
    }

    @PostMapping
    public Trabalhos criarTrabalhos(@RequestBody Trabalhos trabalhos) {
        return trabalhosService.criarTrabalhos(trabalhos);
    }

    @PutMapping("/{id}")
    public Trabalhos atualizarTrabalhos(@PathVariable Long id, @RequestBody Trabalhos trabalhosDetails) throws Exception {
        return trabalhosService.atualizarTrabalhos(id,trabalhosDetails);
    }

    @DeleteMapping("/{id}")
    public void deletarTrabalhos(@PathVariable Long id) {
       trabalhosService.deletarTrabalhos(id);
    }
}
