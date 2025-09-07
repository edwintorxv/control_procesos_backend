package control.procesos.controlProcesos.response;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Getter
public class ResponseRest {

    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public void setMetadata(String tipo, String codigo, String descripcion){
        HashMap<String, String> map = new LinkedHashMap<>();

        map.put("tipo", tipo);
        map.put("codigo", codigo);
        map.put("descripcion", descripcion);
        map.put("fecha y hora", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        metadata.add(map);
    }

}
