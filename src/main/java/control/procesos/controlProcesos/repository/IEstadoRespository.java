package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoRespository extends JpaRepository<Estado, Integer> {
}
