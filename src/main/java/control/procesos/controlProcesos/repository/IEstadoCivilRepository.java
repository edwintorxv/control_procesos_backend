package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoCivilRepository extends JpaRepository<EstadoCivil, Integer> {
}
