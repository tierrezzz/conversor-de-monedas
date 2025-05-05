import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        while (true) {
            try {
                System.out.print("\nMoneda origen (ej: USD): ");
                String origen = sc.nextLine();

                System.out.print("Moneda destino (ej: EUR): ");
                String destino = sc.nextLine();

                System.out.print("Cantidad a convertir: ");
                double cantidad = Double.parseDouble(sc.nextLine());

                Moneda monedaOrigen = new Moneda(origen);
                Moneda monedaDestino = new Moneda(destino);

                double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);

                System.out.printf("%.2f %s = %.2f %s%n",
                        cantidad, origen.toUpperCase(), resultado, destino.toUpperCase());

            } catch (Exception e) {
                System.out.println("Error en la conversión: " + e.getMessage());
            }

            System.out.print("\n¿Desea realizar otra conversión? (si/no): ");
            String opcion = sc.nextLine().trim().toLowerCase();
            if (!opcion.equals("si")) {
                System.out.println("¡Gracias por usar el conversor de monedas!");
                break;
            }
        }

        sc.close();
    }
}
