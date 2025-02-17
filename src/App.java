import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🚀 Hola, recluta, estás a punto de vivir un viaje interestelar!");

        // Selección de planeta
        String planeta = seleccionarPlaneta(scanner);
        if (planeta == null) {
            System.out.println("Selección no válida. Cerrando programa...");
            scanner.close();
            return;
        }

        // Selección de nave
        Nave nave = Nave.seleccionarNave(scanner);

        // Estado inicial del jugador
        int oxigeno = 100;
        int comida = 100;
        int estadoNave = 100;
        int propulsores = 3;
        int atajos = 3;
        double distancia = obtenerDistancia(planeta);

        System.out.println("\nHas elegido el planeta " + planeta + " y viajarás en la nave " + nave.getNombre());
        System.out.println("Distancia desde la Tierra: " + distancia + " millones de kilómetros.");
        System.out.println("Velocidad de la nave: " + nave.getVelocidad() + " km/s");

        // Iniciar simulación de viaje
        iniciarViaje(scanner, distancia, planeta, oxigeno, comida, estadoNave, propulsores, atajos);
    }

    // Método para seleccionar un planeta
    public static String seleccionarPlaneta(Scanner scanner) {
        System.out.println("\n🌍 Selecciona un planeta para tu viaje interplanetario:");
        System.out.println("1. Mercurio (77.3M km)");
        System.out.println("2. Venus (41.4M km)");
        System.out.println("3. Marte (78.3M km)");
        System.out.println("4. Júpiter (628.7M km)");
        System.out.println("5. Saturno (1275M km)");
        System.out.print("➡️ Ingresa el número correspondiente: ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return "Mercurio";
            case 2: return "Venus";
            case 3: return "Marte";
            case 4: return "Júpiter";
            case 5: return "Saturno";
            default:
                System.out.println("❌ Opción no válida.");
                return null;
        }
    }

    // Método para obtener la distancia de un planeta
    public static double obtenerDistancia(String planeta) {
        switch (planeta) {
            case "Mercurio": return 77.3;
            case "Venus": return 41.4;
            case "Marte": return 78.3;
            case "Júpiter": return 628.7;
            case "Saturno": return 1275.0;
            default: return 0.0;
        }
    }

    // Método para manejar el viaje
    public static void iniciarViaje(Scanner scanner, double distancia, String planeta, int oxigeno, int comida, int estadoNave, int propulsores, int atajos) {
        Random random = new Random();

        while (distancia > 0) {
            System.out.println("\n🛰️ Estado del viaje:");
            System.out.println("🌬️ Oxígeno: " + oxigeno + "%");
            System.out.println("🍖 Comida: " + comida + "%");
            System.out.println("🛠️ Estado de la nave: " + estadoNave + "%");
            System.out.println("🚀 Propulsores: " + propulsores);
            System.out.println("🛤️ Atajos: " + atajos);
            System.out.println("📏 Distancia restante: " + distancia + " millones de km");

            System.out.println("\n📡 Opciones de viaje:");
            System.out.println("1️⃣ Activar armas");
            System.out.println("2️⃣ Buscar provisiones y oxígeno");
            System.out.println("3️⃣ Usar propulsores");
            System.out.println("4️⃣ Tomar atajo");
            System.out.println("5️⃣ Continuar viaje normalmente");
            System.out.print("➡️ Elige una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("💥 Activaste las armas, pero no hay enemigos cerca.");
                    break;
                case 2:
                    oxigeno = Math.min(100, oxigeno + 20);
                    comida = Math.min(100, comida + 20);
                    System.out.println("🌿 Encontraste recursos, oxígeno y comida aumentaron.");
                    break;
                case 3:
                    if (propulsores > 0) {
                        propulsores--;
                        distancia -= 50;
                        System.out.println("🚀 Usaste un propulsor, distancia reducida 50M km.");
                    } else {
                        System.out.println("❌ No tienes propulsores.");
                    }
                    break;
                case 4:
                    if (atajos > 0) {
                        atajos--;
                        distancia -= 100;
                        System.out.println("🌀 Tomaste un atajo, distancia reducida 100M km.");
                    } else {
                        System.out.println("❌ No tienes atajos disponibles.");
                    }
                    break;
                case 5:
                    System.out.println("🚀 Sigues viajando...");
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }

            // Eventos aleatorios
            int evento = random.nextInt(5);
            switch (evento) {
                case 0:
                    System.out.println("👽 ¡Un extraterrestre dañó la nave un 10%!");
                    estadoNave -= 10;
                    break;
                case 1:
                    System.out.println("⚡ Un campo de asteroides dañó la nave un 15%!");
                    estadoNave -= 15;
                    break;
                case 2:
                    System.out.println("🕳️ ¡Entraste en un agujero de gusano! Distancia reducida 200M km.");
                    distancia -= 200;
                    break;
                case 3:
                    System.out.println("🔋 Encontraste una estación espacial, reparaste la nave y recargaste recursos.");
                    estadoNave = 100;
                    comida = 100;
                    oxigeno = 100;
                    break;
                default:
                    System.out.println("🛸 No ocurrió nada inusual.");
            }

            if (estadoNave <= 0) {
                System.out.println("💀 La nave se destruyó... Fin del viaje.");
                return;
            }
        }

        System.out.println("\n🎉 ¡Felicidades, soldado! Has colonizado " + planeta + " con éxito.");
    }
}