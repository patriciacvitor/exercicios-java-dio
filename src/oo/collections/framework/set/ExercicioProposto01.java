package oo.collections.framework.set;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

import java.util.*;

public class ExercicioProposto01 {

    public static void main(String[] args) {

        System.out.println("Crie uma conjunto contendo as cores do arco-íris:");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        System.out.printf("%n%na) Exiba todas as cores o arco-íris uma abaixo da outra:%n");
        for (String cor : coresArcoIris) {
            System.out.println(cor);
        }

        System.out.printf("%n%nb) A quantidade de cores que o arco-íris tem: %d%n", coresArcoIris.size());

        System.out.printf("%n%nc) Exiba as cores em ordem alfabética:%n");
        Set<String> coresArcoIris2 = new TreeSet<>();
        coresArcoIris2.addAll(coresArcoIris);
        System.out.println(coresArcoIris2);

        System.out.printf("%n%nd) Exiba as cores na ordem inversa da que foi informada:%n");
        Set<String> coresArcoIris3 = new LinkedHashSet<>(
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        System.out.println(coresArcoIris3);
        List<String> coresArcoIris4 = new ArrayList<>(coresArcoIris3);
        Collections.reverse(coresArcoIris4);
        System.out.println(coresArcoIris4);

        System.out.printf("%n%ne) Exiba todas as cores que começam com a letra ”v”:%n");
        for (String cor : coresArcoIris) {
            if (cor.startsWith("v")) {
                System.out.println(cor);
            }
        }

        System.out.printf("%n%nf) Remova todas as cores que não começam com a letra “v”:%n");
        Iterator<String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("v")) {
                iterator.remove();
            }
        }
        System.out.println(coresArcoIris);

        System.out.printf("%n%ng) Limpe o conjunto.%n");
        coresArcoIris.clear();

        System.out.printf("%n%nh) Confira se o conjunto está vazio:%n");
        String vazio;
        if (coresArcoIris.isEmpty()) { vazio = "Sim"; }
        else { vazio = "Não"; }
        System.out.println("O conjunto está vazio? " + vazio);


/*
*/
    }
}
