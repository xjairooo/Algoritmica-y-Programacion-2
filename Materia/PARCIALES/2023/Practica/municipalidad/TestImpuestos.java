public class TestImpuestos {
    public static void main(String[] args) {
        Titular titular1 = new Titular("Jairo Campero", "20-46823520-0");
        Titular titular2 = new Titular("Thiago Quispe", "20-47859789-0");

        Inmueble inmueble1 = new Inmueble("2023-01-01", titular1, "123456", 150000.99, false);
        Vehiculo vehiculo1 = new Vehiculo("2022-02-03", titular1, "LKB-970", "Ford F100", 2000, 1115670.50);

        Inmueble inmueble2 = new Inmueble("1980-03-06", titular2, "654321", 200000.99, true);
        Vehiculo vehiculo2 = new Vehiculo("2020-04-07", titular2, "LG-890-KM", "Toyota Corolla", 2015, 1500000.00);

        // Array de bienes para almacenar los objetos creados
        Bien bienes[] = new Bien[4];
        bienes[0] = inmueble1;
        bienes[1] = vehiculo1;
        bienes[2] = inmueble2;
        bienes[3] = vehiculo2;

        // Cargar alícuotas
        Inmueble.setAlicuotaBaldio(0.006);
        Inmueble.setAlicuotaEdificado(0.002);
        Vehiculo.setAlicuotaAntiguo(0.004);

        double impuesto;
        double total = 0;

        for (int i = 0; i < bienes.length; i++) {
            impuesto = bienes[i].calcularImpuesto();
            total += impuesto;
            System.out.println("El impuesto del bien " + (i + 1) + " es: " + impuesto);
        }
        System.out.println("El total de impuestos es: " + total);

        System.out.println("--------------------------------------------------");
        for (int i = 0; i < bienes.length; i++) {
            if (bienes[i].getTitular().equals(titular1)) {
                impuesto = bienes[i].calcularImpuesto();
                System.out.println("El impuesto del bien " + (i + 1) + " es: " + impuesto);
                total += impuesto;
            }
        }
        System.out.println("El total de impuestos para el titular " + titular1.getNombre() + " es: " + total);
    }
}
