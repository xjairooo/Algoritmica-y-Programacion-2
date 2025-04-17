import java.util.Scanner;

public class TestTateti {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de Tatetí!");
        System.out.print("Ingrese el tamaño del tablero: ");
        int size = scanner.nextInt();

        // Corregir la creación de la instancia TicTacToe
        TicTacToe game = null;
        try {
            game = new TicTacToe(size);
        } catch (Exception e) {
            System.out.println("Error al crear el tablero: " + e.getMessage());
            System.exit(1);
        }

        boolean gameEnded = false;

        // Bucle principal del juego
        while (!gameEnded) {
            // Mostrar el tablero
            System.out.println("\nTablero actual:");
            System.out.println(game);

            // Mostrar de quién es el turno
            char currentPlayerMark = (game.getCurrentPlayer() == TicTacToe.X) ? 'X' : 'O';
            System.out.println("Turno del jugador " + currentPlayerMark);

            // Solicitar jugada
            boolean validMove = false;
            while (!validMove) {
                try {
                    System.out.print("Ingrese fila: ");
                    int row = scanner.nextInt();
                    System.out.print("Ingrese columna: ");
                    int col = scanner.nextInt();

                    game.putMark(row, col);
                    validMove = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage() + ". Intente nuevamente.");
                }
            }

            // Verificar si hay ganador
            int winningPlayer = game.winner();
            if (winningPlayer != 0) {
                System.out.println("\nTablero final:");
                System.out.println(game);
                System.out.println("¡El jugador " + (winningPlayer == TicTacToe.X ? "X" : "O") + " ha ganado!");
                gameEnded = true;
            }
            // Verificar si hay empate
            else if (game.isFull()) {
                System.out.println("\nTablero final:");
                System.out.println(game);
                System.out.println("¡El juego ha terminado en empate!");
                gameEnded = true;
            }
        }

        scanner.close();
    }
}