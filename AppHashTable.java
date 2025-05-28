import java.util.Hashtable;
import java.util.Scanner;

public class AppHashTable {
    private static Scanner input = new Scanner(System.in);
    private static Hashtable<String, String> alunos = new Hashtable<>();

    public static int menu() {
        System.out.println("1- Cadastrar");
        System.out.println("2- Listar Todos");
        System.out.println("3- Buscar Pela Matricula");
        System.out.println("0- Sair");
        System.out.print("Escolha: ");
        int op = input.nextInt();
        input.nextLine(); // limpar buffer
        return op;
    }

    public static void cadastrar() {
        System.out.println("---Cadastro---");
        System.out.print("Matricula: ");
        String matricula = input.nextLine();
        if (alunos.containsKey(matricula)) {
            System.out.println("Matricula já cadastrada.");
            return; // para a execução do método
        }
        System.out.print("Nome: ");
        String nome = input.nextLine();
        alunos.put(matricula, nome);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void listarTodos() {
        System.out.println("---Lista de Alunos---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (String matricula : alunos.keySet()) {
                System.out.println("Matricula: " + matricula + " - Nome: " + alunos.get(matricula));
            }
        }
    }

    public static void buscarPorMatricula() {
        System.out.println("---Buscar Aluno---");
        System.out.print("Matricula: ");
        String matricula = input.nextLine();
        if (alunos.containsKey(matricula)) {
            System.out.println("Nome: " + alunos.get(matricula));
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listarTodos();
                    break;
                case 3:
                    buscarPorMatricula();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}