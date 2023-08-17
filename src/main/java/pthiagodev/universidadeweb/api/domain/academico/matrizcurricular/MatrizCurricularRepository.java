package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatrizCurricularRepository extends JpaRepository<MatrizCurricular, Long> {
    MatrizCurricular findByCodigo(String codMatriz);
}
