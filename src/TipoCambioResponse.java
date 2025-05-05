import java.util.Map;

public class TipoCambioResponse {
    // Almacena el estado del resultado de la solicitud a la API (por ejemplo: "success")
    private String result;

    // Almacena el código de moneda base desde el cual se hace la conversión (ej: "USD")
    private String base_code;

    // Mapa que contiene las tasas de conversión: clave = código de moneda destino, valor = tasa de cambio
    private Map<String, Double> conversion_rates;

    // Getter para el resultado de la solicitud
    public String getResult() {
        return result;
    }

    // Getter para el código de moneda base
    public String getBaseCode() {
        return base_code;
    }

    // Getter para el mapa de tasas de conversión
    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}
