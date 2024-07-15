public class Moneda {
    private String nombreMoneda;
    private double valor;

    public Moneda(String nombreMoneda, double valor) {
        this.nombreMoneda = nombreMoneda;
        this.valor = valor;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " " + nombreMoneda;
    }
}
