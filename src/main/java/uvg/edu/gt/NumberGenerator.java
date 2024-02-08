package uvg.edu.gt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;

public class NumberGenerator {

    // Método para generar números aleatorios y escribirlos en un archivo
    public static void generateToFile(String filename, int count) throws IOException {
        Random random = new Random();
        // Utilizando Files.newBufferedWriter para abrir y escribir en el archivo
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename), StandardOpenOption.CREATE)) {
            for (int i = 0; i < count; i++) {
                int number = random.nextInt(100000); // número aleatorio entre 0 y 99999
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        }
    }

    // Método para leer números desde un archivo y devolver un arreglo de enteros
    public static int[] readFromFile(String filename) throws IOException {
        // Utilizando Files.readAllLines para leer todas las líneas del archivo en una lista
        List<String> lines = Files.readAllLines(Paths.get(filename));
        // Usando streams y método de referencia para convertir las líneas a enteros
        return lines.stream().mapToInt(Integer::parseInt).toArray();
    }
}
