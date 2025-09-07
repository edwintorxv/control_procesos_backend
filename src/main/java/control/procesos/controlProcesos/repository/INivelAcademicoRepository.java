package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.NivelAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INivelAcademicoRepository extends JpaRepository<NivelAcademico, Integer> {
}
