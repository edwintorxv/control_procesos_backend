package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IClienteRespository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM cliente cl WHERE cl.nit =:nitCliente", nativeQuery = true)
    Optional<Cliente> validacionExisteCliente(@Param("nitCliente") String nitCliente);

}
