package p2a_clase3;

import java.util.Scanner;

public class P2A_Clase3 {

    private static String[][] ma = new String[8][8];

    public static void main(String[] args) {
        int op = 0;
        Scanner entrada = new Scanner(System.in);
        while (op != 5) {
            System.out.println("");
            System.out.println("***MENU***");
            System.out.println("1. Columnas en X");
            System.out.println("2. L con while");
            System.out.println("3. L y L inversa");
            System.out.println("4. Sumas de Matriz");
            System.out.println("5. Salir");
            System.out.println("Ingrese la opcion que desee.");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    cargaMatriz();
                    columnasX();
                    imprimirDecorado();
                    break;
                case 2:
                    cargaMatriz();
                    columnasL();
                    imprimirDecorado();
                    break;
                case 3:
                    cargaMatriz();
                    columnasLeInvertida();
                    imprimirDecorado();
                    break;
                case 4:
                    MatrizUsuario();
                    break;
                case 5:
                    System.out.println("Adiooosssss");
                    break;
                default:
                    System.out.println("La opcion escogida no es valida.");
            }
        }
    }
    private static int[][] matrix;

    public static void MatrizUsuario() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas que desea para su matriz: ");
        int f = teclado.nextInt();

        System.out.println("Ingrese el numero de columnas que desea para su matriz: ");
        int c = teclado.nextInt();

        matrix = new int[f][c];
        System.out.println("Ingrese la matriz: ");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("Posicion [" + i + "] [" + j + "]= ");
                matrix[i][j] = teclado.nextInt();
            }
        }
        int totalF = 0, totalC = 0, totalDP = 0, totalDI = 0, totalMat = 0;
        float media = 0;
        //DP = 00, 11, 22, etc.
        //DI = 02, 11, 20, etc.
        System.out.println("Escoja el numero de fila que desee sumar: ");
        int SumaF = teclado.nextInt();
        if (SumaF - 1 >= f) {
            System.out.println("El numero de fila que escogio, es incorrecto.");
            System.exit(SumaF);
        }
        System.out.println("Escoja el numero de columna que desee sumar: ");
        int SumaC = teclado.nextInt();
        if (SumaC - 1 >= c) {
            System.out.println("El numero de columna que escogio, es incorrecto.");
            System.exit(SumaC);
        }

        for (int i = 0; i < c; i++) {
            totalF += matrix[SumaF - 1][i];
        }
        for (int i = 0; i < f; i++) {
            totalC += matrix[i][SumaC - 1];

        }
        for (int i = 0; i < f; i++) {
            int j = i;
            totalDP += matrix[i][j];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + j == (matrix.length - 1)) {
                    totalDI += matrix[i][j];
                }
            }
        }
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                totalMat += matrix[i][j];
            }
        }
        media = totalMat / (f * c);
        System.out.println("Suma de la fila: " + SumaF + " " + totalF);
        System.out.println("Suma de la columna: " + SumaC + " " + totalC);
        System.out.println("Suma de la diagonal principal: " + totalDP);
        System.out.println("Suma de la diagonal inversa: " + totalDI);
        System.out.println("Media de toda la matriz: " + media);
        Imprimir2();
    }

    public static void imprimirDecorado() {
        for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print(ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }

    public static void columnasL() {
        int columnas = 0;
        int f = 0;
        while (f < 8) {
            ma[f][columnas] = "♦";
            f++;
        }
        f = 7;
        for (int col = 0; col < ma.length; col++) {
            if (col != 8) {
                ma[f][col] = "♦";
            }
        }
    }

    public static void columnasLeInvertida() {
        int columnas = 0;
        int f = 1;
        while (f < 8) {
            ma[f][columnas] = "♥";
            f++;
        }
        f = 7;
        for (int col = 0; col < ma.length; col++) {
            if (col != 7) {
                ma[f][col] = "♥";
            }
        }
        f = 0;
        for (int col = 0; col < ma.length; col++) {
            if (col != 8) {
                ma[f][col] = "☻";
            }
        }
        columnas = 7;
        while (f < 8) {
            ma[f][columnas] = "☻";
            f++;
        }
    }

    private static void cargaMatriz() {
        for (int c = 0; c < ma.length; c++) {
            for (int f = 0; f < ma.length; f++) {
                ma[c][f] = "X";
            }
        }
    }

    public static void columnasX() {
        int columnas = 0;

        for (int f = 0; f < ma.length; f++) {
            ma[f][f] = "\\";
            columnas = ma.length - f;
            if (columnas != 8) {
                ma[f - 1][columnas] = "/";
            }
        }
    }

    private static void Imprimir2() {
        for (int x = 0; x < matrix.length; x++) {
            System.out.print("|");
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print(matrix[x][y]);
                if (y != matrix[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
}
