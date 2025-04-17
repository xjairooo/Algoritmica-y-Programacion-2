/**
 * Simulación de un juego de Tatetí (Tic-Tac-Toe) con tamaño de tablero
 * variable.
 */
public class TicTacToe {
  // Constantes para representar a los jugadores y celdas vacías
  public static final int X = 1, O = -1;
  public static final int EMPTY = 0;

  private int[][] board; // Tablero de juego con tamaño variable
  private int player; // Jugador actual
  private int size; // Tamaño del tablero

  /**
   * Constructor con tamaño especificado.
   * 
   * @param size Tamaño del tablero (debe ser mayor que 0)
   * @throws IllegalArgumentException si el tamaño es inválido
   */
  public TicTacToe(int size) throws IllegalArgumentException {
    if (size <= 0) {
      throw new IllegalArgumentException("El tamaño del tablero debe ser mayor que 0");
    }
    this.size = size;
    board = new int[size][size];
    clearBoard();
  }

  /**
   * Limpia el tablero, dejando todas las celdas vacías.
   */
  public void clearBoard() {
    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        board[i][j] = EMPTY;
    player = X; // El primer jugador es 'X'
  }

  /**
   * Devuelve el jugador actual.
   * 
   * @return Código del jugador actual (X o O)
   */
  public int getCurrentPlayer() {
    return player;
  }

  /**
   * Coloca una marca X u O en la posición i,j.
   * 
   * @param i Fila
   * @param j Columna
   * @throws IllegalArgumentException si la posición es inválida o ya está ocupada
   */
  public void putMark(int i, int j) throws IllegalArgumentException {
    if ((i < 0) || (i >= size) || (j < 0) || (j >= size))
      throw new IllegalArgumentException("Posición de tablero inválida");
    if (board[i][j] != EMPTY)
      throw new IllegalArgumentException("Posición de tablero ocupada");
    board[i][j] = player;
    player = -player; // Cambio de jugador (utiliza el hecho de que O = -X)
  }

  /**
   * Verifica si la configuración del tablero es una victoria para el jugador
   * indicado.
   * 
   * @param mark Código del jugador a verificar
   * @return true si el jugador ha ganado, false en caso contrario
   */
  public boolean isWin(int mark) {
    // Verificar filas
    for (int i = 0; i < size; i++) {
      boolean win = true;
      for (int j = 0; j < size; j++) {
        if (board[i][j] != mark) {
          win = false;
          break;
        }
      }
      if (win)
        return true;
    }

    // Verificar columnas
    for (int j = 0; j < size; j++) {
      boolean win = true;
      for (int i = 0; i < size; i++) {
        if (board[i][j] != mark) {
          win = false;
          break;
        }
      }
      if (win)
        return true;
    }

    // Verificar diagonal principal (de izquierda a derecha)
    boolean win = true;
    for (int i = 0; i < size; i++) {
      if (board[i][i] != mark) {
        win = false;
        break;
      }
    }
    if (win)
      return true;

    // Verificar diagonal inversa (de derecha a izquierda)
    win = true;
    for (int i = 0; i < size; i++) {
      if (board[i][size - 1 - i] != mark) {
        win = false;
        break;
      }
    }
    return win;
  }

  /**
   * Devuelve el código del jugador ganador, o 0 para indicar empate o juego sin
   * terminar.
   * 
   * @return Código del ganador o 0 si no hay ganador
   */
  public int winner() {
    if (isWin(X))
      return X;
    else if (isWin(O))
      return O;
    else
      return 0;
  }

  /**
   * Verifica si el tablero está lleno.
   * 
   * @return true si el tablero está lleno, false si hay al menos una celda vacía
   */
  public boolean isFull() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == EMPTY) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Devuelve una representación en cadena del tablero actual.
   * 
   * @return Cadena que muestra el estado actual del tablero
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    // Imprimir números de columna
    sb.append("  ");
    for (int j = 0; j < size; j++) {
      sb.append(j).append(" ");
    }
    sb.append("\n");

    for (int i = 0; i < size; i++) {
      sb.append(i).append(" "); // Número de fila
      for (int j = 0; j < size; j++) {
        switch (board[i][j]) {
          case X:
            sb.append("X");
            break;
          case O:
            sb.append("O");
            break;
          case EMPTY:
            sb.append(" ");
            break;
        }
        if (j < size - 1)
          sb.append("|"); // Separador de columnas
      }
      if (i < size - 1) {
        sb.append("\n  ");
        for (int j = 0; j < size * 2 - 1; j++) {
          sb.append("-"); // Separador de filas
        }
        sb.append("\n");
      }
    }
    return sb.toString();
  }
}