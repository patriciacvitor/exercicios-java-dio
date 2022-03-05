package oo.collections.framework.map.exercicio03;

/* Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

import java.util.*;

public class ExercicioProposto03 {

    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");
        Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(new ComparatorNumeroDoTelefone());
        agendaSet.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agendaSet) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> agendaSet2 = new TreeSet<>(new ComparatorNomeDoContato());
        agendaSet2.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agendaSet2) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}


class ComparatorNumeroDoTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> contato1, Map.Entry<Integer, Contato> contato2) {
        return Integer.compare(contato1.getValue().getNumero(), contato2.getValue().getNumero());
    }
}

class ComparatorNomeDoContato implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> contato1, Map.Entry<Integer, Contato> contato2) {
        return contato1.getValue().getNome().compareToIgnoreCase(contato2.getValue().getNome());
    }
}