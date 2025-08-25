package CodigosPostalesHermosillo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CodigosPostalesHMO {
    public static void main(String[] args) {
        String archivoCSV = ".idea/codigos_postales_hmo.csv";
        String linea;
        String separador = ",";

        // Mapa para almacenar el conteo de asentamientos por código postal
        HashMap<String, Integer> conteoCodigosPostales = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // Saltar la primera línea si contiene encabezados
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                if (datos.length >= 2) {
                    String codigoPostal = datos[1].trim();

                    // Actualizar el conteo
                    conteoCodigosPostales.put(codigoPostal,
                            conteoCodigosPostales.getOrDefault(codigoPostal, 0) + 1);
                }
            }

            // Mostrar resultados
            for (String codigo : conteoCodigosPostales.keySet()) {
                System.out.println("Código postal: " + codigo +
                        " - Número de asentamientos: " + conteoCodigosPostales.get(codigo));
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
