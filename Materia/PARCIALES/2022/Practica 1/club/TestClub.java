package club;

public class TestClub {
    public static void main(String[] args) {
        Socio.setValorCuota(1000);

        Actividad act1 = new Actividad(10, "Futbol", 500);
        Actividad act2 = new Actividad(20, "Basquet", 700);
        Actividad act3 = new Actividad(30, "Voley", 900);

        Socio s1 = new SocioActivo(10, "Jairo");
        Socio s2 = new SocioActivo(20, "Alex");
        Socio s3 = new SocioTemporario(30, "Pedro");

        try {
            s1.agregarActividad(act1);
            s1.agregarActividad(act2);
            s1.agregarActividad(act3);

            s2.agregarActividad(act3);

            s3.agregarActividad(act1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        Socio[] socios = { s1, s2, s3 };

        double total = 0;
        for (Socio s : socios) {
            System.out.println("Nombre " + s.getNombre() + " Couta: " + s.calcularCuota());
            total += s.calcularCuota();
        }
        System.out.println("Total: " + total);
    }
}
