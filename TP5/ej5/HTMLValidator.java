package ej5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class HTMLValidator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java HTMLValidator archivo_test.txt");
            return;
        }

        String filename = args[0];
        try {
            if (isBalanced(filename)) {
                System.out.println("El archivo esta balanceado");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Metodo para verificar el balance de caracteres en el archivo
    public static boolean isBalanced(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Stack<Character> stack = new Stack<>();
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) { // obtener cada linea del archivo de texto
                for (char c : line.toCharArray()) { // recorrer cada caracter de la linea
                    if (isOpenBracket(c)) { // verifica si es un caracter abierto
                        stack.push(c); // lo guarda en la pila
                    } else if (isCloseBracket(c)) {
                        if (stack.isEmpty() || !matches(stack.pop(), c)) {
                            System.out.println(" Error: Desbalaceando en la linea " + lineNumber);
                            return false;
                        }
                    }
                }
                lineNumber++;
            }
            if (!stack.isEmpty()) {
                System.out.println(" Error: Desbalanceado en la linea " + (lineNumber - 1));
                return false;
            }
        }
        return true; // todas las aperturas tienen su cierre
    }

    // Metodo auxiliar para verificar si es un caracter abierto
    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    // Metodo auxiliar para verificar si es un caracter cerrado
    private static boolean isCloseBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    // Verifica si abre y cierra
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}
