package ar.unrn.tp3.modelo;

public class Telefono {

    private String numero;

    public  Telefono(String numero){
        if (numero == null || numero.isEmpty())
            throw new RuntimeException("Debe ingresar un teléfono");
        if (!validarNumeroTelefono(numero))
            throw new RuntimeException("Debe ingresar un número válido");
        this.numero = numero;
    }

    private boolean validarNumeroTelefono(String numero) {
        String regex = "\\d{4}-\\d{6}";
        return numero.matches(regex);
    }

    public String getNumero() {
        return numero;
    }
}
