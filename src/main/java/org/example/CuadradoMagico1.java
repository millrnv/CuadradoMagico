package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CuadradoMagico1 {
    public static void main(String[] args) {
        int[][] matriz = generarMatrizAleatoria();
        System.out.println("Matriz generada:");
        imprimirMatriz(matriz);
        boolean esCuadradoMagico = verificarCuadradoMagico(matriz);
        if (esCuadradoMagico) {
            System.out.println("La matriz SI es un cuadrado mágico.");
        } else {
            System.out.println("La matriz NO es un cuadrado mágico.");
        }
    }

    //Método para generar la matriz de manera aleatoria
    public static int[][] generarMatrizAleatoria() {
        List<Integer> numerosDisponibles = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numerosDisponibles.add(i);
        }
        int[][] matriz = new int[3][3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int index = random.nextInt(numerosDisponibles.size());
                matriz[i][j] = numerosDisponibles.remove(index);
            }
        }
        return matriz;
    }

    //Método para imprimir la matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Método para verificar el cuadrado mágico
    public static boolean verificarCuadradoMagico(int[][] matriz) {
        int diagonalPrincipal = matriz[0][0] + matriz[1][1] + matriz[2][2];
        int diagonalSecundaria = matriz[0][2] + matriz[1][1] + matriz[2][0];
        if (diagonalPrincipal != diagonalSecundaria) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int filaSuma = matriz[i][0] + matriz[i][1] + matriz[i][2];
            int columnaSuma = matriz[0][i] + matriz[1][i] + matriz[2][i];
            if (filaSuma != diagonalPrincipal || columnaSuma != diagonalPrincipal) {
                return false;
            }
        }
        return true;
    }
}