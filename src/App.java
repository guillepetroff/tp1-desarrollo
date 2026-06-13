import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println("--- SISTEMA DE GESTIÓN DE ENVÍOS ---\n");

        // creo paquetes de prueba
        Paquete p1 = new Paquete("cod01", "polenta", 2.5, EstadoPaquete.recibido);                          // mínimo
        Paquete p2 = new Paquete("cod02", "arroz", 3.0, EstadoPaquete.recibido);        // completo
        Paquete p3 = new Paquete("cod03", "fideos", 3.5, EstadoPaquete.recibido);
        Paquete p4 = new Paquete("cod04", "tomate", 4, EstadoPaquete.recibido);
        Paquete p5 = new Paquete("cod05", "hongos", 2.5, EstadoPaquete.recibido) ;

        
        //muestro los paquetes creados
        System.out.println("-- Paquetes creados --");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
       // ─creo envíos de distintos tipos con constructores ──
        EnvioEstandar envio1 = new EnvioEstandar("El Bolsón", p1);
        envio1.agregarPaquete(p2);

        EnvioExpress envio2 = new EnvioExpress("Villa la Angostura",p3);
        envio2.agregarPaquete(p4);

        EnvioInternacional envio3 = new EnvioInternacional("San Pablo", "Brasil", p5);

        System.out.println(envio1);
        System.out.println(envio2);
        System.out.println(envio3);


        // ── Parte 6: lista de envíos para la jornada ──
        List<Envio> jornada = new ArrayList<>();
        jornada.add(envio1);
        jornada.add(envio2);
        jornada.add(envio3);

        // ── Parte 4: iniciar envíos y observar cómo cambian los paquetes ──
        System.out.println("\n-- Iniciando envíos --");
        for (Envio e : jornada) {
            e.iniciar();
        }
        //Los envios comienzan su viaje  y pasan a estado en distribución
        System.out.println("\n-- Estado de paquetes tras iniciar envíos --");
        System.out.println(p1.getEstado());
        System.out.println(p2.getEstado());
        System.out.println(p3.getEstado());
        System.out.println(p4.getEstado());
        System.out.println(p5.getEstado());

       // ── Parte 4: finalizar envíos ──
        System.out.println("\n-- Finalizando envíos --");
        for (Envio e : jornada) {
            e.finalizar();
        }

        System.out.println("\n-- Estado final de paquetes --");
        System.out.println(p1.getEstado());
        System.out.println(p3.getEstado());
        System.out.println(p4.getEstado());

        // ── Parte 6: resumen ded día con todos los envíos ──
        System.out.println("\n-- Resumen de la jornada --");
        for (Envio e : jornada) {
            e.mostrarResumen();
        }
}
}
