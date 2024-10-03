package org.example;


import java.util.Comparator;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        double[][] matriz = null;
        double[][] sumaFilas = null;
        double[][] matriz_rara = null;

        do {
            System.out.println("Seleccione el ejercicio que desea ejecutar");
            System.out.println("Ejercicio 1");
            System.out.println("Ejercicio 2");
            System.out.println("Ejercicio 3");
            System.out.println("Ejercicio 4");
            System.out.println("Ejercicio 5");
            System.out.println("Ejercicio 6");
            System.out.println("Ejercicio 7");
            System.out.println("0. Salir");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    matriz = ejercicio1(scanner);
                    break;
                case 2:
                    if (matriz != null) {
                        ejercicio2(matriz);
                    } else {
                        System.out.println("Primero debe ingresar los valores en la matriz.");
                    }
                    break;
                case 3:
                    if (matriz != null) {
                        sumaFilas = ejercicio3(matriz);  // Store the result in sumaFilas
                    } else {
                        System.out.println("Se le debe pasar una matriz");
                    }
                    break;

                case 4:
                    if (sumaFilas != null) {  // Check if sumaFilas is not null
                        ejercicio4(sumaFilas);
                    } else {
                        System.out.println("Se le debe pasar una matriz");
                    }
                    break;
                case 5:
                    if (sumaFilas != null) {
                        matriz_rara = ejercicio5(sumaFilas);  // Assign the result to matriz_rara
                    } else {
                        System.out.println("Se le debe pasar una matriz");
                    }
                    break;

                case 6:
                    if (matriz_rara != null) {
                        ejercicio6(matriz_rara);
                    } else {
                        System.out.println("Se le debe pasar una matriz");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo");
            }
            System.out.println();
        } while (option != 0);
        scanner.close();

    }


    public static double[][] ejercicio1(Scanner scanner) {
        int M;
        int N;
        do {
            System.out.println("Ingrese la cantidad de filas de la matriz (mínimo 3)");
            M = scanner.nextInt();
            System.out.println("Ingrese la cantidad de columnas de la matriz (mínimo 2)");
            N = scanner.nextInt();
        } while (M < 3 || N < 2);

        double[][] matriz = new double[M][N];

        // Solicitar y almacenar los valores en la matriz
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println("Ingrese el valor para la posición [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }

    public static void ejercicio2(double[][] matriz) {

        System.out.println("Matriz ingresada:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double[][] ejercicio3(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] sumaFilas = new double[filas][1];

        for (int i = 0; i < filas; i++) {
            double suma = 0;
            for (int j = 0; j < columnas; j++) {
                suma += matriz[i][j];
            }
            sumaFilas[i][0] = suma;
        }

        return sumaFilas;
    }

    public static void ejercicio4(double[][] sumaFilas) {

        System.out.println("Matriz ingresada:");
        for (int i = 0; i < sumaFilas.length; i++) {
            for (int j = 0; j < sumaFilas[i].length; j++) {
                System.out.print(sumaFilas[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static double[][] ejercicio5(double[][] sumaFilas) {
        int filas = sumaFilas.length;
        int col = 2;
        double[][] matriz_rara = new double[filas][col];

        double[][] pares = new double[filas][2];
        for (int i = 0; i < filas; i++) {
            pares[i][0] = sumaFilas[i][0];
            pares[i][1] = i;
        }

        // Sort 'pares' array based on the values in the first column (descending order)
        java.util.Arrays.sort(pares, (a, b) -> Double.compare(b[0], a[0]));

        // Create the final 'matriz_rara'
        for (int i = 0; i < filas; i++) {
            matriz_rara[i][0] = pares[i][0];  // First column with sorted sums
            matriz_rara[i][1] = pares[i][1];  // Second column with original row index
        }

        return matriz_rara;
    }


    public static void ejercicio6(double[][] matriz_rara) {
        int filas = matriz_rara.length;
        double sumaColumnas = 0;

        // Sum the elements of the first column
        for (int i = 0; i < filas; i++) {
            sumaColumnas += matriz_rara[i][0];  // Sum values in the first column
        }

        // Print the sum of the first column
        System.out.println("La sumatoria de la columna 1 es: " + sumaColumnas);
    }


}