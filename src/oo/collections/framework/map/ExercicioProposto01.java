package oo.collections.framework.map;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

import java.util.*;

public class ExercicioProposto01 {

    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações:");
        Map<String, Integer> populacaoEstadosNE = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populacaoEstadosNE);

        System.out.printf("%n%nSubstitua a população do estado RN por : 3.534.165");
        populacaoEstadosNE.put("RN", 3534165);
        System.out.println(populacaoEstadosNE);

        System.out.printf("%n%nConfira se o estado da Paraíba (PB) está no dicionário, caso não, adicione " +
                "PB - 4.039.277:%n");
        System.out.println(populacaoEstadosNE);
        System.out.println("Contém o Estado da Paraíba? " + populacaoEstadosNE.containsKey("PB"));
        populacaoEstadosNE.put("PB", 4039277);
        System.out.println(populacaoEstadosNE);

        System.out.printf("%n%nExiba a população do estado PE: %d", populacaoEstadosNE.get("PE"));

        System.out.printf("%n%nExiba todos os estados e suas populaçãos na ordem em que foram informados:");
        Map<String, Integer> populacaoEstadosNE2 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println(populacaoEstadosNE2);

        System.out.println("%n%nExiba todos os estados e suas populações na ordem alfabética:");
        Map<String, Integer> populacaoEstadosNE3 = new TreeMap<>(populacaoEstadosNE);
        System.out.println(populacaoEstadosNE3);

        Collection<Integer> populacao = populacaoEstadosNE.values();
        String estadoMenorPopulacao = "";
        String estadoMaiorPopulacao = "";
        for (Map.Entry<String, Integer> entry : populacaoEstadosNE.entrySet()) {
            if (entry.getValue().equals(Collections.min(populacao))) {
                estadoMenorPopulacao = entry.getKey();
            }
            if (entry.getValue().equals(Collections.max(populacao))) {
                estadoMaiorPopulacao = entry.getKey();
            }
        }
        System.out.printf("%n%nExiba o estado com a menor população e seu respectivo valor:\n %s -> %d",
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("%n%nExiba o estado com a maior população e seu respectivo valor:\n %s -> %d",
                estadoMaiorPopulacao, Collections.max(populacao));

        int soma = 0;
        Iterator<Integer> iterator = populacaoEstadosNE.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.printf("%n%nExiba a soma da população desses estados: %d", soma);

        System.out.printf("%n%nExiba a média da população deste dicionário de estados: %d", soma/populacaoEstadosNE.size());

        System.out.printf("%n%nRemova os estados com a população menor que 4.000.000:\n");
        Iterator<Integer> iterator1 = populacaoEstadosNE.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() < 4000000) {
                iterator1.remove();
            }
        }
        System.out.println(populacaoEstadosNE);

        System.out.printf("\n\nApague o dicionario de estados com suas respectivas populações estimadas:\n");
        populacaoEstadosNE.clear();
        System.out.println(populacaoEstadosNE);

        System.out.printf("\n\nConfira se a lista está vazia:");
        System.out.printf("\n\nMap \"populacaoEstadosNE está vazio?\" %b\n", populacaoEstadosNE.isEmpty());
        System.out.printf("\nMap \"populacaoEstadosNE2 está vazio?\" %b\n", populacaoEstadosNE2.isEmpty());
        System.out.printf("\nMap \"populacaoEstadosNE3 está vazio?\" %b\n", populacaoEstadosNE3.isEmpty());
    }
}
