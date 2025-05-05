import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIService {

    private static final String API_KEY = "5be46780c32cc434398f4042";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final Gson gson = new Gson();

    public double obtenerTasa(String from, String to) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/latest/" + from;
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String linea;

        while ((linea = in.readLine()) != null) {
            response.append(linea);
        }
        in.close();

        TipoCambioResponse tipoCambio = gson.fromJson(response.toString(), TipoCambioResponse.class);

        if (!"success".equalsIgnoreCase(tipoCambio.getResult())) {
            throw new RuntimeException("Error al obtener datos de la API");
        }

        if (!tipoCambio.getConversionRates().containsKey(to)) {
            throw new IllegalArgumentException("Código de moneda destino inválido: " + to);
        }

        return tipoCambio.getConversionRates().get(to);
    }

}
