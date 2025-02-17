
import java.util.Scanner;

public class Nave {
    private String nombre;
    private double velocidad;

    public Nave(String nombre, double velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public static Nave seleccionarNave(Scanner scanner) {
        System.out.println("\n🚀 Selecciona una nave:");
        System.out.println("1. Falcon X (200 km/s)");
        System.out.println("2. Orion 7 (300 km/s)");
        System.out.println("3. Enterprise Z (500 km/s)");
        System.out.print("➡️ Ingresa el número correspondiente: ");
        System.out.println("jaja");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return new Nave("Falcon X", 200);
            case 2: return new Nave("Orion 7", 300);
            case 3: return new Nave("Enterprise Z", 500);
            default:
                System.out.println("❌ Opción no válida. Se seleccionará Falcon X por defecto.");
                return new Nave("Falcon X", 200);
                
        }
    }
}

