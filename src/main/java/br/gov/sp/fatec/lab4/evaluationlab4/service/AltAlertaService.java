package br.gov.sp.fatec.lab4.evaluationlab4.service;

import br.gov.sp.fatec.lab4.evaluationlab4.entity.AltAlerta;
import br.gov.sp.fatec.lab4.evaluationlab4.repository.AltAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequestMapping("/alerta")
public class AltAlertaService {

    @Autowired
    private AltAlertaRepository altAlertaRepository;

    public AltAlerta cadastrarAltAlerta(AltAlerta altAlerta) {
        if (altAlerta.getAltDataHora() == null) {
            altAlerta.setAltDataHora(LocalDateTime.now());
        }
        if (altAlerta.getAltNivel() == null) {
            altAlerta.setAltNivel(5);
        }
        if (altAlerta.getAltDataHoraVerificacao() != null &&
                altAlerta.getAltDataHoraVerificacao().isAfter(altAlerta.getAltDataHora())) {
            throw new IllegalArgumentException();
        }
        return altAlertaRepository.save(altAlerta);
    }

    public List<AltAlerta> listarTodos() {
        return altAlertaRepository.findAll();
    }

    public List<AltAlerta> buscarAlertas(String altMensagem, int altNivel) {
        return altAlertaRepository.buscarAlertas(altMensagem, altNivel);
    }
}


