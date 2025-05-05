public class ConversorMoneda {

    // Servicio encargado de conectarse a la API para obtener tasas de cambio
    private APIService apiService;

    // Constructor que inicializa el servicio de API
    public ConversorMoneda() {
        this.apiService = new APIService();
    }

    // Metodo que realiza la conversión entre dos monedas usando la tasa actual
    public double convertir(Moneda from, Moneda to, double cantidad) throws Exception {
        // Obtiene la tasa de conversión desde la API
        double tasa = apiService.obtenerTasa(from.getCodigo(), to.getCodigo());
        // Retorna el monto convertido aplicando la tasa
        return cantidad * tasa;
    }
}
