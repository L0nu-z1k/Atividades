package Arvores.Atividade;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class appFeira {
    private static Scanner input = new Scanner(System.in);

    public static Livro criaLivro(String autor) {
        System.out.println("----- Criar livro -----");
        System.out.print("Título: ");
        String titulo = input.nextLine();
        System.out.print("Ano: ");
        int ano = input.nextInt();
        input.nextLine(); // limpa o buffer
        return new Livro(titulo, autor, ano);
    }

    public static void main(String[] args) {
        TreeMap<String, TreeSet<Livro>> biblioteca = new TreeMap<>();
        TreeSet<Livro> todosLivros = new TreeSet<>();
        String op;

        do {
            System.out.print("Autor: ");
            String autor = input.nextLine();
            Livro livro = criaLivro(autor);

            biblioteca.putIfAbsent(autor, new TreeSet<>());
            biblioteca.get(autor).add(livro);
            todosLivros.add(livro);

            System.out.print("Deseja inserir mais registro? (sim/não): ");
            op = input.nextLine().trim().toLowerCase();
        } while (op.equals("sim"));

        System.out.println("\nTodos os livros:");
        for (Livro livro : todosLivros) {
            System.out.println(livro);
        }

        System.out.println("\nAutores e seus livros:");
        for (String autor : biblioteca.keySet()) {
            System.out.println(autor + ":");
            for (Livro livro : biblioteca.get(autor)) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }
}