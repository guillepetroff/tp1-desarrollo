

import java.util.ArrayList;
import java.util.List;


public abstract class Envio {
     
    private static int contadorId = 1;      

    private final int id;
    private final String destino;
    private final List<Paquete> paquetes;
    private boolean iniciado;
    private boolean finalizado;

    // Constructor 
    public Envio(String destino) {
        this.id = contadorId++;
        this.destino = destino;
        this.paquetes = new ArrayList<>();
        this.iniciado = false;
        this.finalizado = false;
    }

    // Constructor con un paquete inicial
    public Envio(String destino, Paquete paquete) {
        this(destino);
        agregarPaquete(paquete);
     //   this.iniciado=true;
    }

    // Agrega un paquete respetando el límite de 3
    public void agregarPaquete(Paquete paquete) {
        if (paquetes.size() >= 3) {
            throw new IllegalStateException("No se pueden enviar mas de 3 paquetes.");
        }
        if (paquete == null) {
            throw new IllegalArgumentException("El paquete no puede ser nulo.");
        }
        paquetes.add(paquete);
    }

    // inicia un envio
    public void iniciar() {
        if (paquetes.isEmpty()) {
            throw new IllegalStateException("No se puede iniciar un envío sin paquetes.");
        }
        if (iniciado) {
            throw new IllegalStateException("El envío ya fue iniciado.");
        }
        iniciado = true;
        for (Paquete p : paquetes) {
            p.estadoEnPreparacion();
            p.estadoEnDistribucion();
        }
        System.out.println("Envío con ID " + id + " iniciado hacia " + destino);
    }

    // Parte 4: al finalizar, los paquetes actualizan su estado
    public void finalizar() {
        if (!iniciado) {
            throw new IllegalStateException("El envío no ha sido iniciado.");
        }
        if (finalizado) {
            throw new IllegalStateException("El envío ya fue finalizado.");
        }
        finalizado = true;
        for (Paquete p : paquetes) {
            p.estadoEntregado();
        }
        System.out.println("Envío con ID " + id + " finalizado. Paquetes entregados en: " + destino);
    }

    // Parte 5 y 7: cálculo de costo delegado a cada subclase
    public double calcularCosto() {
        double base = calcularCostoBase();
        double recargo = aplicarRecargo(base);
        return base + recargo;
    }

    // cada tipo de envio lo implementa a su manera por eso es abstracto
    protected abstract double calcularCostoBase();

    //lógica interna de recargo, puede sobreescribirse
    protected double aplicarRecargo(double costoBase) {
        return 0;
    }

    // peso total encapsulado, usado internamente
    protected double calcularPesoTotal() {
        double suma = 0; 
        for (Paquete p : paquetes) {
            suma = suma + p.getPesoKg();
        }
        return suma;
    }

    // Getters
    public int getId() { return id; }
    public String getDestino() { return destino; }
    public List<Paquete> getPaquetes() { return List.copyOf(paquetes); }
    public boolean isIniciado() { return iniciado; }
    public boolean isFinalizado() { return finalizado; }

    public void mostrarResumen() {
        System.out.printf("Envío #%d | Tipo: %-15s | Destino: %-15s | Paquetes: %d | Costo: $%.2f%n",
            id, getClass().getSimpleName(), destino, paquetes.size(), calcularCosto());
    }

    @Override
    public String toString() {
        return String.format("Envío #%d hacia %s (%s) - Costo: $%.2f",
            id, destino, getClass().getSimpleName(), calcularCosto());
    }
}

