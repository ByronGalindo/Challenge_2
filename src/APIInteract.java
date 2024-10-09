import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

public class APIInteract {

    private String endpoint;
    private double exchangeRate;
    private String exchange;
    private String exchangeObj;


    public double getExchangeRate() {
        return exchangeRate;
    }

    public String getEndpoint() {
        return endpoint;
    }


    public APIInteract(String baseURL, String apikey, String Exchange, String ExchangeObj) throws InterruptedException {
        this.endpoint = baseURL + apikey + "/latest/" + Exchange;
        this.exchange = Exchange;
        this.exchangeObj = ExchangeObj;
        this.exchangeRate = 0.0;
        getExchangeRate(endpoint);
    }

    private void getExchangeRate(String endpoint) throws InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() < 400){

                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

                try {

                    JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

                    JsonElement rate = conversionRates.get(this.exchangeObj);

                    if (rate != null) {
                        System.out.println("Tasa de cambio para " + this.exchangeObj + ": " + rate.getAsDouble());
                        this.exchangeRate = rate.getAsDouble();

                    } else {
                        System.out.println("La tasa de cambio para " + this.exchangeObj + " no se encontró.");
                        this.exchangeRate = 0.0;
                    }
                } catch (Exception e) {
                    JsonObject type_error = jsonObject.getAsJsonObject("error-type");
                    System.out.println("Ha ocurrido un error....\n type_error: " + type_error.getAsString());
                    this.exchangeRate = 0.0;

                }
            }else{

                System.out.println("Fallas de comunicacion con el API\n Valide la integridad del endpoint\n Endpoint usado: " + endpoint + " \n Reintente mas tarde.....");
                Loader.startLoader(20,200,"Cerrando Sistema...  ");
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fallas de comunicacion con el API\n Valide la integridad del endpoint\n Endpoint usado: " + endpoint + " \n Reintente mas tarde.....");
            Loader.startLoader(20,200,"Cerrando Sistema...  ");
            System.exit(1);
        }
    }
}
