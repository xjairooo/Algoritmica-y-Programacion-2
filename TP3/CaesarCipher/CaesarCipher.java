/**
 * Clase para realizar encriptacion y desencriptacion usando el Cifrado Cesar
 * con alfabeto español.
 */
public class CaesarCipher {
  // Alfabeto español (incluye Ñ)
  protected char[] encoderUpper = new char[27]; // Mayusculas para encriptar
  protected char[] decoderUpper = new char[27]; // Mayusculas para desencriptar
  protected char[] encoderLower = new char[27]; // Minusculas para encriptar
  protected char[] decoderLower = new char[27]; // Minusculas para desencriptar
  protected char[] encoderDigit = new char[10]; // Digitos para encriptar
  protected char[] decoderDigit = new char[10]; // Digitos para desencriptar

  // Alfabetos de referencia para español, incluyendo Ñ y ñ
  private static final char[] SPANISH_UPPER = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
      'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  private static final char[] SPANISH_LOWER = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
      'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

  /** Constructor que inicializa los arrays de encriptacion y desencriptacion */
  public CaesarCipher(int rotation) {
    // Inicializar arrays para mayusculas y minusculas (alfabeto español)
    for (int k = 0; k < 27; k++) {
      encoderUpper[k] = SPANISH_UPPER[(k + rotation) % 27];
      decoderUpper[k] = SPANISH_UPPER[(k - rotation + 27) % 27]; // +27 para evitar indices negativos

      encoderLower[k] = SPANISH_LOWER[(k + rotation) % 27];
      decoderLower[k] = SPANISH_LOWER[(k - rotation + 27) % 27];
    }

    // Inicializar arrays para digitos (0-9)
    for (int k = 0; k < 10; k++) {
      encoderDigit[k] = (char) ('0' + (k + rotation) % 10);
      decoderDigit[k] = (char) ('0' + (k - rotation + 10) % 10);
    }
  }

  /** Devuelve un String que representa el mensaje encriptado. */
  public String encrypt(String message) {
    return transform(message, encoderUpper, encoderLower, encoderDigit);
  }

  /** Devuelve el mensaje desencriptado dado un texto secreto. */
  public String decrypt(String secret) {
    return transform(secret, decoderUpper, decoderLower, decoderDigit);
  }

  /** Devuelve la transformacion del String original usando los codigos dados. */
  private String transform(String original, char[] codeUpper, char[] codeLower, char[] codeDigit) {
    char[] msg = original.toCharArray();
    for (int k = 0; k < msg.length; k++) {
      char c = msg[k];

      // Procesar mayusculas (incluida Ñ)
      if ((c >= 'A' && c <= 'Z') || c == 'Ñ') {
        int index = indexOf(SPANISH_UPPER, c);
        if (index != -1) {
          msg[k] = codeUpper[index];
        }
      }
      // Procesar minusculas (incluida ñ)
      else if ((c >= 'a' && c <= 'z') || c == 'ñ') {
        int index = indexOf(SPANISH_LOWER, c);
        if (index != -1) {
          msg[k] = codeLower[index];
        }
      }
      // Procesar digitos
      else if (Character.isDigit(c)) {
        int index = c - '0';
        msg[k] = codeDigit[index];
      }
      // Otros caracteres se mantienen sin cambios
    }
    return new String(msg);
  }

  /** Metodo auxiliar para encontrar el indice de un caracter en un array */
  private int indexOf(char[] array, char target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1; // No encontrado
  }

  /** Metodo main simple para probar el cifrado Cesar */
  public static void main(String[] args) {
    CaesarCipher cipher = new CaesarCipher(3);

    System.out.println("Codificacion mayusculas: " + new String(cipher.encoderUpper));
    System.out.println("Decodificacion mayusculas: " + new String(cipher.decoderUpper));
    System.out.println("Codificacion minusculas: " + new String(cipher.encoderLower));
    System.out.println("Codificacion digitos: " + new String(cipher.encoderDigit));

    String message = "Hola Ñundo 07";
    String coded = cipher.encrypt(message);
    System.out.println("Original: " + message);
    System.out.println("Cifrado: " + coded);
    String answer = cipher.decrypt(coded);
    System.out.println("Descifrado: " + answer);
  }
}