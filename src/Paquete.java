public class Paquete {

    private String idPaquete;
    private String contenido;
    private double peso;
    private EstadoPaquete estado;

    //constructor
    public Paquete(String idPaquete, String contenido, double peso, EstadoPaquete estado) {
        this.idPaquete = idPaquete;
        this.contenido = contenido;
        this.peso = peso;
        this.estado = estado;
    }

        // Getters — sin setters directos para proteger el estado
    public String getId() { return idPaquete; }
    public String getDescripcion() { return contenido; }
    public double getPesoKg() { return peso; }
    public EstadoPaquete getEstado() { return estado; }


    public void estadoRecibido(){
        this.estado = EstadoPaquete.recibido; 

    }
    
    public void estadoEnPreparacion(){
        this.estado = EstadoPaquete.enPreparacion;

    }

        public void estadoEnDistribucion(){
        this.estado = EstadoPaquete.enDistribucion; 

    }
    
    public void estadoEntregado(){
        this.estado = EstadoPaquete.entregado;

    }

    public String imprimirPaquete(){
        return ("Información del paquete: " + this.contenido + " Pesa:" + this.peso);

    }

}