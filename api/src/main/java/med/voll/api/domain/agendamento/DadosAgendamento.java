package med.voll.api.domain.agendamento;


import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.datahora.DadosDataHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public record DadosAgendamento(
        @NotBlank String paciente,
        @NotBlank String medico,
        @NotBlank DadosDataHora dataHora,
        boolean cancelamento,
        String motivo
) {

    public void consisteHora(String hora) {
        String[] horasSplit = (hora.split(":" ));
        int horas = Integer.parseInt(horasSplit[0]);
        if(horas < 7 || horas > 19){
            throw new ExceptionInInitializerError("Atendimento somente das 07:00 às 19:00");
        }
    }

    public void consisteData(String data) throws ParseException {
        int diaSemana = converteDiaSemana(data);
        if(diaSemana < 2 || diaSemana > 6){
            throw new ExceptionInInitializerError("Atendimento somente de segunda a sexta");
        }
    }

    public int converteDiaSemana(String data) throws ParseException {
        Date dataAgendamento = (new SimpleDateFormat("dd/MM/yyyy")).parse(data);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataAgendamento);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
        return diaDaSemana;
    }
}
