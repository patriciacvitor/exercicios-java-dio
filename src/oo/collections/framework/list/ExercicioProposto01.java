package oo.collections.framework.list;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();

        // Adicionando as temperaturas à lista
        for (int i = 0; i < 6; i++) {
            System.out.println("Digite a temperatura: ");
            temperaturas.add(entrada.nextDouble());
        }

        // Exibindo as temperaturas
        temperaturas.forEach(temp -> System.out.print(temp + " "));

        // Calculando e exibindo a média das temperaturas
        Iterator<Double> iterator = temperaturas.iterator();
        Double media = 0d;
        while (iterator.hasNext()) {
            Double temperatura = iterator.next();
            media += temperatura;
        }
        media /= temperaturas.size();
        System.out.printf("A média das temperaturas é: %.2f%n%n", media);

        // Exibir temperaturas acima da média
        System.out.println("Temperaturas acima da média:");
        Iterator<Double> iterator1 = temperaturas.iterator();
        int count = 0;
        while (iterator1.hasNext()) {
            Double temperatura = iterator1.next();
            if (temperatura > media) {
                switch (count) {
                    case 0:
                        System.out.printf("1 - Janeiro: %.2fºC%n", temperatura);
                        break;
                    case 1:
                        System.out.printf("2 - Fevereiro: %.2fºC%n", temperatura);
                        break;
                    case 2:
                        System.out.printf("3 - Março: %.2fºC%n", temperatura);
                        break;
                    case 3:
                        System.out.printf("4 - Abril: %.2fºC%n", temperatura);
                        break;
                    case 4:
                        System.out.printf("5 - Maio: %.2fºC%n", temperatura);
                        break;
                    case 5:
                        System.out.printf("6 - Junho: %.2fºC%n", temperatura);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média.");
                        break;
                }
            }
            count++;
        }
        System.out.printf("%n%n");

        /*
        for (Double temperatura : temperaturas) {

        }
        */

    }
}
