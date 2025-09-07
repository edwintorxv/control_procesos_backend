package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.EmpleadoDocumento;
import control.procesos.controlProcesos.response.EmpleadoDocumentoResponseRest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface IEmpleadoDocumentoService {

    public ResponseEntity<EmpleadoDocumentoResponseRest> lstEmpleadoDocumento();

    public ResponseEntity<EmpleadoDocumentoResponseRest> crearEmpleadoDocumento(EmpleadoDocumento empleadoDocumento);

    public ResponseEntity<EmpleadoDocumentoResponseRest> eliminarEmpleadoDocumento(Integer idDocumentoEmpleado);

    public ResponseEntity<EmpleadoDocumentoResponseRest> lstEmpleadoDocumentoPorEmpleado(Integer idEmpleado);

}
