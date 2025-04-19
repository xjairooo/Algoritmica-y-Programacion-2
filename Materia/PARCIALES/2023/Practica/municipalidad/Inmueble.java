public class Inmueble extends Bien {

    private String partida;
    private double valuacionFiscal;
    private static double alicuotaBaldio;
    private static double alicuotaEdificado;
    private boolean baldio;

    // Constructor
    public Inmueble(String fechaAlta, Titular titular, String partida, double valuacionFiscal, boolean baldio) {
        super(fechaAlta, titular);
        this.partida = partida;
        this.valuacionFiscal = valuacionFiscal;
        this.baldio = baldio;
    }

    // Getters and Setters
    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public double getValuacionFiscal() {
        return valuacionFiscal;
    }

    public void setValuacionFiscal(double valuacionFiscal) {
        this.valuacionFiscal = valuacionFiscal;
    }

    public static double getAlicuotaBaldio() {
        return alicuotaBaldio;
    }

    public static void setAlicuotaBaldio(double alicuotaBaldio) {
        Inmueble.alicuotaBaldio = alicuotaBaldio;
    }

    public static double getAlicuotaEdificado() {
        return alicuotaEdificado;
    }

    public static void setAlicuotaEdificado(double alicuotaEdificado) {
        Inmueble.alicuotaEdificado = alicuotaEdificado;
    }

    public boolean isBaldio() {
        return baldio;
    }

    public void setBaldio(boolean baldio) {
        this.baldio = baldio;
    }

    // HashCode and Equals methods
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((partida == null) ? 0 : partida.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inmueble other = (Inmueble) obj;
        if (partida == null) {
            if (other.partida != null)
                return false;
        } else if (!partida.equals(other.partida))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Inmueble [partida=" + partida + ", valuacionFiscal=" + valuacionFiscal + ", baldio=" + baldio
                + ", getFechaAlta()=" + getFechaAlta() + ", getTitular()=" + getTitular() + "]";
    }

    // Implementacion del metodo calcularImpuesto
    // Si el inmueble es baldío, se calcula el impuesto con la alícuota de baldío
    // Si el inmueble es edificado, se calcula el impuesto con la alícuota de
    // edificado
    @Override
    public double calcularImpuesto() {
        if (baldio) {
            return (valuacionFiscal * alicuotaBaldio);
        } else {
            return (valuacionFiscal * alicuotaEdificado);
        }
    }

}
