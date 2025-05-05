public class Moneda {
    // Atributo que almacena el código de la moneda (ej: "USD", "EUR")
    private String codigo;

    // Constructor que recibe el código y lo guarda en mayúsculas para estandarizarlo
    public Moneda(String codigo) {
        this.codigo = codigo.toUpperCase();
    }

    // Getter para obtener el código de la moneda
    public String getCodigo() {
        return codigo;
    }

}
