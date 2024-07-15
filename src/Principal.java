import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        System.out.println("Ingrese la moneda base (por ejemplo, USD,MXN,EUR,KRW):");

        try {
            String fromMoneda = scanner.nextLine().toUpperCase();

            System.out.println("Ingrese el valor a convertir:");
            double monto = Double.parseDouble(scanner.nextLine());

            System.out.println("Ingrese la moneda de destino (por ejemplo, USD,MXN,EUR,KRW):");
            String toMoneda = scanner.nextLine().toUpperCase();

            double ratioDeCambio = conversor.getExchangeRate(fromMoneda, toMoneda);
            double convertedAmount = monto * ratioDeCambio;

            Moneda monedaInicial = new Moneda(fromMoneda, monto);
            Moneda monedaFinal = new Moneda(toMoneda, convertedAmount);

            System.out.println("La tasa de cambio de " + fromMoneda + " a " + toMoneda + " es: " + ratioDeCambio);
            System.out.println("El valor convertido es: " + monedaFinal);

        } catch (NumberFormatException e) {
            System.out.println("Número no válido: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            System.out.println("Finalizando la aplicación");
        }
    }

}
