package br.gov.sp.fatec.lab4.evaluationlab4.controller;

import br.gov.sp.fatec.lab4.evaluationlab4.entity.AltAlerta;
import br.gov.sp.fatec.lab4.evaluationlab4.service.AltAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/alerta")
public class AltAlertaController {

    @Autowired
    private AltAlertaService altAlertaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<AltAlerta> cadastrar(@RequestBody AltAlerta altAlerta) {
        AltAlerta novoAlerta = altAlertaService.cadastrarAltAlerta(altAlerta);
        return ResponseEntity.ok(novoAlerta);
    }


    @GetMapping("/listar")
    public ResponseEntity<Iterable<AltAlerta>> listarTodos() {
        Iterable<AltAlerta> alertas = altAlertaService.listarTodos();
        return ResponseEntity.ok(alertas);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Iterable<AltAlerta>> buscarTodosAlertas(@RequestParam String altMensagem, @RequestParam int altNivel) {
        Iterable<AltAlerta> alertas = altAlertaService.buscarAlertas(altMensagem, altNivel);
        return ResponseEntity.ok(alertas);
    }
}

