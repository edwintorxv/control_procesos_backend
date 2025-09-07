package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IConceptoRespository extends JpaRepository<Concepto, Integer> {

}
