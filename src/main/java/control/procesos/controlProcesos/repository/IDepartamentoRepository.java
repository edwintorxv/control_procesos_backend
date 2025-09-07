package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
