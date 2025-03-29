// Archivo: Time2.java
// Declaración de la clase Time2 con constructores sobrecargados
package time;

public class Time2 {
   private int hora;    // 0 - 23
   private int minuto;  // 0 - 59
   private int segundo; // 0 - 59

   // Constructor sin argumentos: inicializa todas las variables a cero
   public Time2() {
      this(0, 0, 0); // Llama al constructor con tres argumentos
   }

   // Constructor con hora, minuto y segundo por defecto a 0
   public Time2(int h) {
      this(h, 0, 0); // Llama al constructor con tres argumentos
   }

   // Constructor con hora y minuto, segundo por defecto a 0
   public Time2(int h, int m) {
      this(h, m, 0); // Llama al constructor con tres argumentos
   }

   // Constructor principal con hora, minuto y segundo
   public Time2(int h, int m, int s) {
      setTime(h, m, s); // Llama a setTime para validar los valores
   }

   // Constructor que recibe otro objeto Time2 (constructor de copia)
   public Time2(Time2 time) {
      this(time.getHour(), time.getMinute(), time.getSecond());
   }

   // Métodos Set (Establecer valores)
   public void setTime(int h, int m, int s) {
      setHour(h);   // Establece la hora
      setMinute(m); // Establece el minuto
      setSecond(s); // Establece el segundo
   }

   // Valida y establece la hora (0-23)
   public void setHour(int h) {
      hora = ((h >= 0 && h < 24) ? h : 0);
   }

   // Valida y establece el minuto (0-59)
   public void setMinute(int m) {
      minuto = ((m >= 0 && m < 60) ? m : 0);
   }

   // Valida y establece el segundo (0-59)
   public void setSecond(int s) {
      segundo = ((s >= 0 && s < 60) ? s : 0);
   }

   // Métodos Get (Obtener valores)
   public int getHour() {
      return hora;
   }

   public int getMinute() {
      return minuto;
   }

   public int getSecond() {
      return segundo;
   }

   // Convierte a String en formato universal (HH:MM:SS)
   public String toUniversalString() {
      return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   }

   // Convierte a String en formato estándar (H:MM:SS AM/PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s",
            ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
            getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   }
}