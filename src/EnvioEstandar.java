// Parte 7: envío estándar — costo base por peso
public class EnvioEstandar extends Envio {

    private static final double precioPorKilo = 2000.0;

    public EnvioEstandar(String destino) {
        super(destino);
    }

    public EnvioEstandar(String destino, Paquete paquete) {
        super(destino, paquete);
    }

    @Override
    protected double calcularCostoBase() {
        return calcularPesoTotal() * precioPorKilo ;
    }
}
