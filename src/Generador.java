import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileWriter;

public class Generador {

        // me salio error en ioEx... pero poniendo el throws ioex.. se solucionó
        public void guardarJson(Moneda moneda) throws IOException{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter escritura = new FileWriter(moneda.base_code() + "_" + moneda.target_code() + ".json");
            escritura.write(gson.toJson(moneda));
            escritura.close();
        }
    }


