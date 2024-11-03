import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Consulta {
    private static final String API = "4ee75cc91a09290e1b305570"; // Asegúrate de tener la API key correcta
    private static final String URL = "https://v6.exchangerate-api.com/v6/" + API + "/pair/";

    public Moneda buscaMoneda (int numeroDeMoneda, String cantidad) throws IOException, InterruptedException{
       String deMoneda;
       String aMoneda;

        switch (numeroDeMoneda) {
            case 1:
                deMoneda = "USD";
                aMoneda = "ARS";
                break;
            case 2:
                deMoneda = "ARS";
                aMoneda = "USD";
                break;
            case 3:
                deMoneda = "USD";
                aMoneda = "BRL";
                break;
            case 4:
                deMoneda = "BRL";
                aMoneda = "USD";
                break;
            case 5:
                deMoneda = "USD";
                aMoneda = "PEN";
                break;
            case 6:
                deMoneda = "PEN";
                aMoneda = "USD";
                break;
            case 7:
                System.out.println("Salir.");
                System.exit(0);
            default:
                throw new IllegalArgumentException("Opción inválida");
        }

        String url = URL + deMoneda + "/" + aMoneda;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> respuesta = cliente
                .send(solicitud, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(respuesta.body(), Moneda.class);

    }

}

