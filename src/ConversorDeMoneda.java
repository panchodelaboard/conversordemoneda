import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoneda {
    private static final String apiKey = "6d4aefec8d1753ebda92e6da";
    private static final String baseUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/";

    public double getExchangeRate(String fromMoneda, String toMoneda) {
        URI uri = URI.create(baseUrl + fromMoneda + "/" + toMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio", e);
        }
    }
}
