package ar.unrn.tp3.modelo;

public class Participante {

    private String nombre;
    private Telefono telefono;
    private Region region;

    public Participante (String nombre, Telefono telefono, Region region){
        if (nombre == null || nombre.isEmpty())
            throw new RuntimeException("Debe cargar un nombre");

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;

        }

    public String getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }


    public Region getRegion() {
        return region;
    }

}
