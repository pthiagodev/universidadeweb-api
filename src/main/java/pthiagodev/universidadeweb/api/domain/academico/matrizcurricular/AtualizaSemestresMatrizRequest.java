package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;

public record AtualizaSemestresMatrizRequest(

        @Positive(message = "Id deve ser maior que 0.")
        Long id,

        @NotNull
        List<Semestre> semestres) {
}
