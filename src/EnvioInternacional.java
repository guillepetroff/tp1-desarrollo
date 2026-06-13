public class EnvioInternacional extends Envio {

    private static final double tarifaPorKilo = 500.0;
    private static final double cargoAduana = 0.20; // 20%

    private final String paisDestino;

    public EnvioInternacional(String ciudadDestino, String paisDestino) {
        super(ciudadDestino + ", " + paisDestino);
        this.paisDestino = paisDestino;
    }

    public EnvioInternacional(String ciudadDestino, String paisDestino, Paquete paquete) {
        this(ciudadDestino, paisDestino);
        agregarPaquete(paquete);
    }

    @Override
    protected double calcularCostoBase() {
        return calcularPesoTotal() * tarifaPorKilo;
    }

    // Parte 5: recargo de aduana encapsulado
    @Override
    protected double aplicarRecargo(double costoBase) {
        return costoBase * cargoAduana;
    }

    public String getPaisDestino() { return paisDestino; }
}

