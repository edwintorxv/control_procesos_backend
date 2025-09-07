package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.CiudadMunicipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadMunicipioRepository extends JpaRepository<CiudadMunicipio, Integer> {

    @Query(value =  "SELECT * FROM ciudad_municipio cm WHERE cm.fk_departamento = :idDepartamento", nativeQuery = true)
    List<CiudadMunicipio> lstCiudadMunicipioPorDepartamento(@Param("idDepartamento") Integer idDepartamento);
}
