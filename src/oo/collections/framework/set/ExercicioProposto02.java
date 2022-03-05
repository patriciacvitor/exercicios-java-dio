package oo.collections.framework.set;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/

import java.util.*;

public class ExercicioProposto02 {

    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>();
        linguagensFavoritas.add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
        linguagensFavoritas.add(new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code"));
        linguagensFavoritas.add(new LinguagemFavorita("Python", 1991, "Visual Studio Code"));

        System.out.println("--------\tOrdem de Inserção\t--------");
        Set<LinguagemFavorita> linguagensFavoritas1 = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Java", 1991, "IntelliJ"),
                        new LinguagemFavorita("JavaScript", 1995, "Visual Studio Code"),
                        new LinguagemFavorita("Python", 1991, "Visual Studio Code")
                        )
        );
        for (LinguagemFavorita linguagem : linguagensFavoritas1) {
            System.out.println(linguagem);
        }

        System.out.println("--------\tOrdem Natural: Nome\t--------");
        Set<LinguagemFavorita> linguagensFavoritas2 = new TreeSet<>(linguagensFavoritas);
        for (LinguagemFavorita linguagem : linguagensFavoritas2) {
            System.out.println(linguagem);
        }

        System.out.println("--------\tOrdem IDE\t--------");
        Set<LinguagemFavorita> linguagensFavoritas3 = new TreeSet<LinguagemFavorita>(new ComparatorIde());
        linguagensFavoritas3.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagem : linguagensFavoritas3) {
            System.out.println(linguagem);
        }

        System.out.println("--------\tOrdem Ano de Criacao e Nome\t--------");
        Set<LinguagemFavorita> linguagensFavoritas4 = new TreeSet<>(new ComparatorAnoDeCriacaoNome());
        linguagensFavoritas4.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagem : linguagensFavoritas4) {
            System.out.println(linguagem);
        }

        System.out.println("--------\tOrdem Nome - Ano de Criacao - IDE\t--------");
        Set<LinguagemFavorita> linguagemFavoritas5 = new TreeSet<>(new ComparatorNomeAnoDeCriacaoNome());
        linguagemFavoritas5.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagem : linguagemFavoritas5) {
            System.out.println(linguagem);
        }


    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    public String nome;
    public Integer anoDeCriacao;
    public String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + getNome() + '\'' +
                ", anoDeCriacao=" + getAnoDeCriacao() +
                ", ide='" + getIde() + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.getNome().compareToIgnoreCase(linguagemFavorita.getNome());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita linguagem1, LinguagemFavorita linguagem2) {
        int ide = linguagem1.getIde().compareToIgnoreCase(linguagem2.getIde());
        if (ide != 0) {
            return ide;
        }
        return linguagem1.getNome().compareToIgnoreCase(linguagem2.getNome());
    }
}

class ComparatorAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita linguagem1, LinguagemFavorita linguagem2) {
        int ano = linguagem1.getAnoDeCriacao().compareTo(linguagem2.getAnoDeCriacao());
        if (ano != 0) {
            return ano;
        }
        return linguagem1.getNome().compareToIgnoreCase(linguagem2.getNome());
    }
}

class ComparatorNomeAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita linguagem1, LinguagemFavorita linguagem2) {
        int nome = linguagem1.getNome().compareToIgnoreCase(linguagem2.getNome());
        if (nome != 0) {
            return nome;
        }
        int ano = linguagem1.getAnoDeCriacao().compareTo(linguagem2.getAnoDeCriacao());
        if (ano != 0) {
            return ano;
        }
        return linguagem1.getIde().compareToIgnoreCase(linguagem2.getIde());
    }
}