package med.voll.api.domain.datahora;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataHora {
    public String data;
    private String hora;

    public DataHora(DadosDataHora dadosDataHora) {
        this.data = dadosDataHora.data();
        this.hora = dadosDataHora.hora();
    }
}
