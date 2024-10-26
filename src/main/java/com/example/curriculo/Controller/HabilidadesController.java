package com.example.curriculo.Controller;


import com.example.curriculo.Model.Habilidades;
import com.example.curriculo.Service.HabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadesController {

    @Autowired
    private HabilidadesService habilidadesService;

    @GetMapping
    public List<Habilidades> getAllHabilidades() {
        return habilidadesService.getAllHabilidades();
    }

    @GetMapping("/{id}")
    public Habilidades getHabilidadesById(@PathVariable Long id) {
        return habilidadesService.getHabilidadesById(id).orElse(null);
    }

    @PostMapping
    public Habilidades criarHabilidades(@RequestBody Habilidades habilidades) {
        return habilidadesService.criarHabilidades(habilidades);
    }

    @PutMapping("/{id}")
    public Habilidades atualizarHabilidades(@PathVariable Long id, @RequestBody Habilidades habilidadesDetails) throws Exception {
        return habilidadesService.atualizarHabilidades(id, habilidadesDetails);
    }

    @DeleteMapping("/{id}")
    public void deletarHabilidades(@PathVariable Long id) {
        habilidadesService.deletarHabilidades(id);
//Controlle = gerencia o envio de informações enviadas ao banco
//Controller = cria as URLs
    }
}
