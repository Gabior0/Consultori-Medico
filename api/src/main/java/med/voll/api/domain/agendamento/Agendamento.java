package med.voll.api.domain.agendamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.datahora.DataHora;

@Table(name = "agendamento")
@Entity(name = "Agendamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String paciente;
    String medico;

    @Embedded
    DataHora dataHora;
    boolean cancelamento;
    MotivoCancemento motivo;

    public Agendamento(DadosAgendamento dados) {
        this.paciente = dados.paciente();
        this.medico = dados.medico();
        this.dataHora = new DataHora(dados.dataHora());
        this.cancelamento = false;
        this.motivo = MotivoCancemento.Ativa;

    }

    public void cancelaAgendamento(DadosCancelamentoAegendamento dados) {
        this.cancelamento = true;
        this.motivo = dados.motivo();
    }
}
