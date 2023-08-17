package pthiagodev.universidadeweb.api.domain.academico.semestre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    List<Semestre> findAllByMatrizCurricularId(Long id);
}
