package banco;

import java.time.LocalDate;
import java.text.DecimalFormat;

public class TestBanco {
    public static void main(String[] args) {
        // Para mostrar los numeros en decimales 
        DecimalFormat df = new DecimalFormat("#,##0.00");

        // Crear acciones
        Accion a1 = new Accion("ALUA", "Aluar", 750, false);
        Accion a2 = new Accion("YPF", "YPF", 36100, true);

        // Crear bonos
        Bono b1 = new Bono("AL30", "Bono AL 30", 73500, LocalDate.of(2030, 6, 30));
        Bono b2 = new Bono("GD35", "Bono GD 35", 74100, LocalDate.of(2035, 9, 30));

        // Crear clientes
        Cliente c1 = new Cliente("Juan", "juan@gmail.com");
        Cliente c2 = new Cliente("Ana", "ana@gmail.com");

        // Registrar compras de activos para los clientes
        c1.comprarActivo(a1, 1200);
        c1.comprarActivo(b1, 12);

        c2.comprarActivo(a2, 150);
        c2.comprarActivo(b2, 45);

        c1.comprarActivo(a1, 1500);
        c2.comprarActivo(b2, 35);

        // Mostrar el total de activos de cada cliente con formato
        System.out.println("Total de activos de " + c1.getNombre() + ": " + df.format(c1.totalActivo()));
        System.out.println("Total de activos de " + c2.getNombre() + ": " + df.format(c2.totalActivo()));

        // Crear un arreglo con los títulos
        Titulo[] titulos = {a1, a2, b1, b2};

        // Recorrer el arreglo y calcular comisiones, impuestos y precios para 100 titulos
        System.out.println("\nCálculos para 100 títulos de cada activo:");
        for (Titulo titulo : titulos) {
            System.out.println("Titulo: " + titulo.getSimbolo());
            System.out.println("  Comision: " + df.format(titulo.calcularComision(100)));
            System.out.println("  Impuesto: " + df.format(titulo.calcularImpuesto(100)));
            System.out.println("  Precio total: " + df.format(titulo.calcularPrecio(100)));
        }
    }
}