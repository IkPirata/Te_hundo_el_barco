import java.util.Scanner;
public class Ejercicio11 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char [][] matrix;
        matrix = new char[8][8];
        boolean gameOver = false;
        int disparo = 0;
        int hundido = 0;
        int numBarco = 10;

        for (int fila = 0; fila < matrix.length; fila++){
            for (int col = 0; col < matrix[0].length; col++){
                matrix[fila][col] = ' ';
            }
        }

        addShips(matrix);
        while (!gameOver){
            printMatrix(matrix,true);
            int row = getRow(input);
            int col = getCol(input);

            disparo++;
            System.out.println("Disparos: " + disparo);

            if (matrix[row][col] == 'S' ) {
                matrix[row][col] = 'X';
                hundido++;
                numBarco--;
            } else {
                matrix[row][col] = 'O';
            }
            System.out.println("Hundidos: " + hundido);
            if (numBarco == 0){
                System.out.println("Ganas!");
                break;
            }
        }
    }

    static void addShips(char[][] tabla){
        int numShips = 0;
        while (numShips < 10) {
            int row = (int) (Math.random() * tabla.length);
            int col = (int) (Math.random() * tabla[0].length);
            if (tabla[row][col] != 'S') {
                tabla[row][col] = 'S';
                numShips++;
            }
        }
    }
    // debug a true imprime los barcos. Solo para depuración
    static void printMatrix(char[][] tabla, boolean debug){
        System.out.print("  ");
        for (int i = 1; i <= 8; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < tabla.length; row++){
            System.out.print((char)(65 + row) + " ");
            for (int col = 0; col < tabla[0].length; col++){
                //Imprimo la matriz
                if (tabla[row][col] == 'S' && debug){
                    System.out.print(" ");
                }
                else {
                    System.out.print(tabla[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
    static int getRow(Scanner input){
        System.out.print("Dame la letra de la fila: ");
        char letter = input.next().charAt(0);
        int row = letter - 65;
        return row;
    }
    static int getCol(Scanner input){
        System.out.print("Dame el número de la columna: ");
        int col = input.nextInt() - 1;
        return col;
    }
}