package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.agendamento.Agendamento;
import med.voll.api.domain.agendamento.AgendamentoRepository;
import med.voll.api.domain.agendamento.DadosAgendamento;
import med.voll.api.domain.agendamento.DadosCancelamentoAegendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @PostMapping
    @Transactional
    public void agendaConsulta(@RequestBody @Valid DadosAgendamento dados) throws ParseException {
        dados.consisteData(dados.dataHora().data());
        dados.consisteHora(dados.dataHora().hora());
        repository.save(new Agendamento(dados));
    }

    @PutMapping
    @Transactional
    public void cancelaCOnsulta(@RequestBody @Valid DadosCancelamentoAegendamento dados){
        var agendamento = repository.getReferenceById(dados.id());
        agendamento.cancelaAgendamento(dados);
    }
}
