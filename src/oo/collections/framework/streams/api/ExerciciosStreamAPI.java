package oo.collections.framework.streams.api;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {

    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4",  "1", "2", "3", "9", "9", "6",  "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        /*
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // OU

        numerosAleatorios.stream().forEach(s -> System.out.println(s));

        // OU

        numerosAleatorios.forEach(s -> System.out.println(s));
        */

        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);
        // Set não aceita números repetidos, portanto, "1" aparecerá apenas uma vez.

        /*
        // Se quiséssemos apenas colocar os valores em um Set, poderíamos fazer:
        Set<String> numeros5Primeiros = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());
        System.out.println(numeros5Primeiros);
        */

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        /*
        numerosAleatorios.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });

        // OU

        numerosAleatorios.stream().map(s -> Integer.parseInt(s));

        // OU

        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // OU
        */

        // Se quiséssemos apenas colocar os valores em uma List, poderíamos fazer:
        List<Integer> collectListInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(collectListInteger);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");

        /*
        List<Integer> paresMaioresQue2 = numerosAleatorios
                .stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % 2 == 0 && integer > 2) {
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());

        // OU

        */

        List<Integer> paresMaioresQue2 = numerosAleatorios
                .stream()
                .map(Integer::parseInt)
                .filter(integer -> (integer % 2 == 0 && integer > 2))
                .collect(Collectors.toList());

        System.out.println("Mostre a média dos números: ");

        /*
        numerosAleatorios.stream().mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String s) {
                return Integer.parseInt(s);
            }
        })

        // OU

        numerosAleatorios.stream().mapToInt(s -> Integer.parseInt(s));

        // OU

        numerosAleatorios
                .stream()
                .mapToInt(Integer::parseInt)
                .average().ifPresent(new DoubleConsumer() {
            @Override
            public void accept(double value) {
                System.out.println(value);
            }
        });

        // OU

        numerosAleatorios
                .stream()
                .mapToInt(Integer::parseInt)
                .average().ifPresent(value -> System.out.println(value));

        // OU
        */

        numerosAleatorios
                .stream()
                .mapToInt(Integer::parseInt)
                .average().ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");

        /*
        collectListInteger.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % 2 != 0) return true;
                return false;
            }
        });

        // OU
        */

        // removeIf() é um método de List, portanto altera a lista. Uma stream() não a alteraria.
        collectListInteger.removeIf(integer -> (integer % 2 != 0));
        System.out.println(collectListInteger);

        // Para você

        /*
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatoriosInteger.stream()
                .skip(3)
                .forEach(System.out::println);

        long countNumerosUnicos = numerosAleatoriosInteger.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.print("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.print("Mostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);;

        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
                .filter(i -> (i % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Pegue apenas os números ímpares e some: " + somaDosNumerosPares);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);
        */

    }
}


/*

[x] stream - Fluxo de dados que não altera a coleção
https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
https://medium.com/@racc.costa/streams-no-java-8-e-no-java-9-36177c5c3313
https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
[x] operações intermediárias - Permite operações encadeadas
[x] operações finais - Fecha o fluxo
https://www.geeksforgeeks.org/stream-in-java/
---
[x] forEach(new Consumer())
[x] skip()
[x] collect(Collectors.joining())
[x] distinct()
[x] count()
[x] limit()
[x] collect(Collectors.toSet())
[x] map(new Function())
[x] collect(Collectors.toList())
[x] filter (new Function())
[x] sorted()
[x] mapToInt
[x] sum()
[x] average()
[x] ifPresent()
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html
https://www.baeldung.com/java-optional
[x] min
[x] max
*[x] removeIf(new Predicate())
[x] collect(Collectors.groupingBy(new Function())

*/