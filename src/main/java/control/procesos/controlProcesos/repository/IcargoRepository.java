package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcargoRepository extends JpaRepository<Cargo, Integer> {
}
