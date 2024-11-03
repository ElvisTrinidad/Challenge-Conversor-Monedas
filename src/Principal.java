import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Consulta consulta = new Consulta();

        while (true) {
            String datos = """
                    ********************************************
                    Sea bienvenido(a) al conversor de monedas:
                    1. Dólar =>> Peso Argentino
                    2. Peso Argentino =>> Dólar
                    3. Dólar =>> Real Brasileño
                    4. Real Brasileño =>> Dólar
                    5. Dólar =>> Soles Peruano
                    6. Soles Peruano =>> Dólar
                    7. Salir
                    """;
            System.out.println(datos);

            System.out.println("Elija una opción válida:");
            System.out.println("***************************");

            try {
                var opcionDeMoneda = Integer.valueOf(lectura.nextLine());
                if (opcionDeMoneda < 1 || opcionDeMoneda > 7) {
                    System.out.println("Opción no válida");
                    continue;
                }
                if (opcionDeMoneda == 7) {
                    System.out.println("Salir.");
                    break;
                }
                System.out.println("Ingrese la Cantidad a convertir: ");
                String cantidad = lectura.nextLine();

                Moneda moneda = consulta.buscaMoneda(opcionDeMoneda, cantidad);
                double cantidadConvertida = moneda.conversion_rate() * Double.parseDouble(cantidad);

                System.out.printf("El valor de %.2f [%s] corresponde al valor final de =>> %.2f[%s]%n",
                        Double.parseDouble(cantidad), moneda.base_code(), cantidadConvertida, moneda.target_code());

                Generador generador = new Generador();
                generador.guardarJson(moneda); // llamamos de class Generador
            } catch (NumberFormatException e) {
                System.out.println("Número no válido: " + e.getMessage());
            } catch (RuntimeException | IOException | InterruptedException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
                break;
            }
        }
    }
}


