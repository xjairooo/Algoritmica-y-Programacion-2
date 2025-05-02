package spacedisk;

import java.util.Scanner;
import java.io.File;

/**
 * Permite calcular el uso total de espacio en disco, la cantidad de archivos y
 * directorios
 * dentro de un sistema de archivos desde un directorio dado.
 */
public class DiskSpace {

  /**
   * Calcula el uso total de espacio en disco (en bytes), la cantidad de archivos
   * y directorios
   * de la parte del sistema de archivos que tiene como raíz la ruta dada.
   * 
   * @param root designa una ubicación en el sistema de archivos
   * @return un arreglo de tres elementos:
   *         [0] = total de bytes utilizados,
   *         [1] = cantidad de archivos,
   *         [2] = cantidad de directorios.
   */
  public static long[] diskUsage(File root) {
    long[] result = { 0, 0, 0 }; // [totalBytes, numFiles, numDirectories]
    result[0] += root.length(); // suma el tamaño del archivo o directorio actual

    if (root.isDirectory()) { // si es un directorio
      result[2]++; // incrementa el contador de directorios
      for (String childname : root.list()) { // para cada hijo
        File child = new File(root, childname); // compone la ruta completa al hijo
        long[] childResult = diskUsage(child); // llamada recursiva
        result[0] += childResult[0]; // suma los bytes del hijo
        result[1] += childResult[1]; // suma los archivos del hijo
        result[2] += childResult[2]; // suma los directorios del hijo
      }
    } else {
      result[1]++; // si no es un directorio, es un archivo
    }

    // Traza del algoritmo
    System.out
        .println("Bytes: " + result[0] + ", Archivos: " + result[1] + ", Directorios: " + result[2] + " -> " + root);
    return result; // devuelve el resultado acumulado
  }

  /**
   * Calcula el uso de espacio en disco, cantidad de archivos y directorios desde
   * una ruta dada.
   * Ejemplo de uso: java DiskSpace C:\Users\campe
   */
  public static void main(String[] args) {
    String start;
    if (args.length > 0) {
      start = args[0];
    } else {
      System.out.print("Ingrese la ubicación inicial: ");
      start = new Scanner(System.in).next();
    }

    long[] result = diskUsage(new File(start));
    System.out.println("\nResumen:");
    System.out.println("Total de bytes utilizados: " + result[0]);
    System.out.println("Cantidad de archivos: " + result[1]);
    System.out.println("Cantidad de directorios: " + result[2]);
  }

}