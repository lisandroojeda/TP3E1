package ar.unrn.tp3.modelo;

import java.util.ArrayList;

public class Region {
    private String nombre;
    private final String US = "US";
    private final String Europa = "Europa";
    private final String China = "China";
    public Region (String nombre){
        if (regionConocida(nombre))
            this.nombre = nombre;
        throw new RuntimeException("Debe ingresar una región conocida");
    }

    private boolean regionConocida(String nombre){
        if ((nombre == US)||(nombre == Europa)||(nombre == China))
            return true;
       return false;
    }

    public String getNombre() {
        return nombre;
    }
}
