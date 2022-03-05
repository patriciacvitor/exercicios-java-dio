package oo.collections.framework.map;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
*/

import java.util.*;

public class ExercicioProposto02 {

    public static void main(String[] args) {

        List<Integer> numerosObtidos = new ArrayList<>();
        Random geradorDeNumeros = new Random();
        int qtdDeLancamentos = 100;
        for (int i = 0; i < qtdDeLancamentos; i++) {
            int numero = geradorDeNumeros.nextInt(6) + 1;
            numerosObtidos.add(numero);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : numerosObtidos) {
            if (lancamentos.containsKey(resultado)) {
                lancamentos.put(resultado, lancamentos.get(resultado) + 1);
            }
            else { // Se a chave ainda não existe, incluo com o valor de 1 lançamento
                lancamentos.put(resultado, 1);
            }
        }

        System.out.println("\n\n\n\n\nJogando");
        for (int i = 0; i < 8; i++) {
            try {
                Thread.sleep(500);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("\n\n");

        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("Valor: %3d saiu em %3d lançamentos.\n", entry.getKey(), entry.getValue());
        }
    }
}