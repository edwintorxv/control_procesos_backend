package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.DocumentoMaestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IDocumentoMaestroRepository extends JpaRepository<DocumentoMaestro, Integer> {

    @Query(value = "SELECT * FROM documento_maestro dm WHERE dm.fk_tipo_documento =:idTipoDocumento", nativeQuery = true)
    List<DocumentoMaestro> lstDocumentoMaestroPorTipoDocumento(Integer idTipoDocumento);

}
