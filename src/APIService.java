import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIService {

    // Constante con tu API key personal para autenticarte en el servicio de ExchangeRate
    private static final String API_KEY = "5be46780c32cc434398f4042";

    // URL base del servicio de ExchangeRate API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Instancia de Gson para convertir el JSON de la respuesta en un objeto Java
    private final Gson gson = new Gson();

    // Metodo que obtiene la tasa de cambio entre dos monedas
    public double obtenerTasa(String from, String to) throws Exception {
        // Construye la URL completa para la petición con la moneda base
        String urlStr = BASE_URL + API_KEY + "/latest/" + from;
        URL url = new URL(urlStr);

        // Abre la conexión HTTP con método GET
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Lee la respuesta línea por línea y la concatena en un StringBuilder
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String linea;

        while ((linea = in.readLine()) != null) {
            response.append(linea);
        }
        in.close(); // Cierra el lector

        // Parsea la respuesta JSON a un objeto TipoCambioResponse usando Gson
        TipoCambioResponse tipoCambio = gson.fromJson(response.toString(), TipoCambioResponse.class);

        // Verifica si la respuesta fue exitosa
        if (!"success".equalsIgnoreCase(tipoCambio.getResult())) {
            throw new RuntimeException("Error al obtener datos de la API");
        }

        // Verifica si la moneda de destino existe en la respuesta
        if (!tipoCambio.getConversionRates().containsKey(to)) {
            throw new IllegalArgumentException("Código de moneda destino inválido: " + to);
        }

        // Retorna la tasa de conversión solicitada
        return tipoCambio.getConversionRates().get(to);
    }

}
