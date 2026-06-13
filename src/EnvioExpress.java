// Parte 7: envío express — tarifa mayor + recargo por rapidez en entrega
public class EnvioExpress extends Envio {

    private static final double tarifaPorKilo = 300.0;
    private static final double recargo = 500.0;

    public EnvioExpress(String destino) {
        super(destino);
    }

    public EnvioExpress(String destino, Paquete paquete) {
        super(destino, paquete);
    }

    @Override
    protected double calcularCostoBase() {
        return calcularPesoTotal() * tarifaPorKilo;
    }

    // Parte 5: recargo interno por urgencia
    @Override
    protected double aplicarRecargo(double costoBase) {
        return recargo;
    }
}
