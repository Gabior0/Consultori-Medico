package med.voll.api.agendamento;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoAegendamento(@NotNull Long id, @Enumerated(EnumType.STRING) @NotBlank MotivoCancemento motivo) {
}
