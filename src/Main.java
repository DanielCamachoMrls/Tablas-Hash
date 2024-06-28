import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String line;
        String separador = ",";
        HashTable<String, String> tablaHash = new HashTable<>(100);

        // Cargar datos desde el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader("bussines.csv"))) {
            int id = 1;
            while ((line = br.readLine()) != null) {
                String[] bussines = line.split(separador);
                String key = bussines[0].trim();  // Suponiendo que el ID es la clave
                String value = bussines[1].trim() + ", " + bussines[2].trim() + ", " + bussines[3].trim() + ", " + bussines[4].trim();

                // Insertar en la tabla hash
                tablaHash.put(key, value);

                System.out.println("[" + id + "] Negocio [ID=" + bussines[0] + ", Nombre=" + bussines[1] + ", Dirección=" + bussines[2] + ", Ciudad=" + bussines[3] + ", Estado=" + bussines[4] + "]");
                id++;
            }
            System.out.println("Datos cargados correctamente desde el archivo.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}