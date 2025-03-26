import java.util.Scanner;

public class Hola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hola Mundo");

        System.out.println("Ingrese su nombre: ");
        String nombre = input.nextLine();
        System.out.println("Hola " + nombre + "!");
        input.close();

    }
}