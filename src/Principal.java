import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {
        // Inicialización del scanner para entrada por consola
        // y del conversor de monedas que se encargará de la lógica de conversión
        Scanner sc = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        // Bucle principal que permite al usuario realizar múltiples conversiones
        while (true) {
            try {
                // Solicita al usuario los datos necesarios para la conversión
                System.out.print("\nMoneda origen (ej: USD): ");
                String origen = sc.nextLine();

                System.out.print("Moneda destino (ej: EUR): ");
                String destino = sc.nextLine();

                System.out.print("Cantidad a convertir: ");
                double cantidad = Double.parseDouble(sc.nextLine());

                // Crea los objetos Moneda con los códigos ingresados
                Moneda monedaOrigen = new Moneda(origen);
                Moneda monedaDestino = new Moneda(destino);

                // Realiza la conversión utilizando el conversor y muestra el resultado
                double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);

                System.out.printf("%.2f %s = %.2f %s%n",
                        cantidad, origen.toUpperCase(), resultado, destino.toUpperCase());

            } catch (Exception e) {
                // Captura errores como códigos inválidos o fallos de conexión
                System.out.println("Error en la conversión: " + e.getMessage());
            }

            // Pregunta al usuario si desea realizar otra conversión
            System.out.print("\n¿Desea realizar otra conversión? (si/no): ");
            String opcion = sc.nextLine().trim().toLowerCase();

            // Si la respuesta no es "si", se finaliza el programa
            if (!opcion.equals("si")) {
                System.out.println("¡Gracias por usar el conversor de monedas!");
                break;
            }
        }

        // Cierra el scanner para liberar recursos
        sc.close();
    }
}
