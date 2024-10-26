package com.example.curriculo.Controller;

import com.example.curriculo.Model.Cursos;
import com.example.curriculo.Service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @GetMapping
    public List<Cursos> getAllCursos() {
        return cursosService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Cursos getCursosById(@PathVariable Long id) {
        return cursosService.getCursosById(id).orElse(null);
    }

    @PostMapping
    public Cursos criarCurso(@RequestBody Cursos cursos) {
        return cursosService.criarCurso(cursos);
    }

    @PutMapping("/{id}")
    public Cursos atualizarCurso(@PathVariable Long id, @RequestBody Cursos cursoDetails) throws Exception {
        return cursosService.atualizarCurso(id, cursoDetails);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable Long id) {
        cursosService.deletarCurso(id);
//Controlle = gerencia o envio de informações enviadas ao banco
//Controller = cria as URLs
    }
}
