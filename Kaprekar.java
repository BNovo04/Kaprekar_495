import java.lang.*;

import java.util.*;


class Tranformacao_495 {
    static int Tranformacao495(int numero) {
        int a1, a2, a3;
        int d1, d2, d3;
        int maior, menor, result;
        int digito1 = numero / 100; // MSB
        int digito2 = (numero - digito1 * 100) / 10;
        int digito3 = (numero % 10); // LSB
        if (digito1 > digito2) {
            if (digito1 > digito3) {
                d1 = digito1;
                if (digito2 > digito3) {
                    d2 = digito2;
                    d3 = digito3;
                } else {
                    d3 = digito2;
                    d2 = digito3;
                }
            } else {
                d1 = digito3;
                d2 = digito1;
                d3 = digito2;
            }
        } else {
            if (digito2 > digito3) {
                d1 = digito2;
                if (digito1 > digito3) {
                    d2 = digito1;
                    d3 = digito3;
                } else {
                    d3 = digito1;
                    d2 = digito3;
                }
            } else {
                d1 = digito3;
                d2 = digito2;
                d3 = digito1;
            }
        }
        if (digito1 < digito2) {
            if (digito1 < digito3) {
                a1 = digito1;
                if (digito2 < digito3) {
                    a2 = digito2;
                    a3 = digito3;
                } else {
                    a3 = digito2;
                    a2 = digito3;
                }
            } else {
                a1 = digito3;
                a2 = digito1;
                a3 = digito2;
            }
        } else {
            if (digito2 < digito3) {
                a1 = digito2;
                if (digito1 < digito3) {
                    a2 = digito1;
                    a3 = digito3;
                } else {
                    a3 = digito1;
                    a2 = digito3;
                }
            } else {
                a1 = digito3;
                a2 = digito2;
                a3 = digito1;
            }
        }

        maior = d1 * 100 + d2 * 10 + d3;
        menor = a1 * 100 + a2 * 10 + a3;
        result = maior - menor;
        return result;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        int[] numeros = new int[inputArray.length];
        int[] numerosAux = new int[inputArray.length];
        int[] contadores = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            try {
                numeros[i] = Integer.parseInt(inputArray[i]);
                numerosAux[i] = Integer.parseInt(inputArray[i]);
            } catch (Exception ignored) {

            }
        }
        for (int j = 0; j < inputArray.length; j++) {

            int proximoNumero = 0;
            int contador = 0;
            while (proximoNumero != 495) {
                proximoNumero = Tranformacao495(numerosAux[j]);
                contador++;

                if (numerosAux[j] == proximoNumero)
                    break;
                numerosAux[j] = proximoNumero;
            }

            contadores[j] = contador;
        }
        int i, j, temp;
        boolean troca;
        for (i = 0; i < inputArray.length; i++) {
            troca = false;
            for (j = 0; j < inputArray.length - i - 1; j++) {
                if (contadores[j] > contadores[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = contadores[j];
                    contadores[j] = contadores[j + 1];
                    contadores[j + 1] = temp;
                    temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    troca = true;
                }
                else if(contadores[j] == contadores[j+1]){
                    if(numeros[j]>numeros[j+1]){
                        temp = contadores[j];
                        contadores[j] = contadores[j + 1];
                        contadores[j + 1] = temp;
                        temp = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = temp;
                        troca = true;
                    }
                }
            }

            if (!troca)
                break;


        }
        System.out.println(Arrays.toString(numeros));
    }
}