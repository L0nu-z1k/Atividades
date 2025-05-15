

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static int funcaoHash(String palavra, int tam) {
        char primeiraLetra = palavra.toUpperCase().charAt(0);

        if (primeiraLetra < 'A' || primeiraLetra > 'Z') {
            return -1; // retorna índice inválido caso a letra não seja A-Z
        }

        return primeiraLetra - 'A'; // A -> 0, B -> 1, ..., Z -> 25
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        if (palavra == null || palavra.isEmpty()) {
            return false;
        }

        palavra = palavra.toUpperCase();
        int categoria = funcaoHash(palavra, tam);

        if (categoria < 0 || categoria >= tam) {
            return false;
        }

        return tabelaHash[categoria].contains(palavra);
    }

    public static void exibirTabelaHash(ArrayList<String>[] tabelaHash) {
        System.out.println("--- Distribuição na Tabela Hash ---");
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.printf("%c: %s\n", (char) ('A' + i), tabelaHash[i]);
        }
    }

    public static void main(String[] args) {
        int totalCategorias = 26;
        ArrayList<String>[] tabelaHash = new ArrayList[totalCategorias];

        for (int i = 0; i < totalCategorias; i++) {
            tabelaHash[i] = new ArrayList<>();
        }

        List<String> listaPalavras = GeradorPalavras.lerPalavras();
        if (listaPalavras == null) {
            System.out.println("Não foi possível carregar as palavras.");
            return;
        }

        System.out.println("Distribuindo palavras na tabela hash...");
        for (String palavra : listaPalavras) {
            palavra = palavra.trim().toUpperCase();
            int categoria = funcaoHash(palavra, totalCategorias);
            if (categoria != -1) {
                tabelaHash[categoria].add(palavra);
            } else {
                System.out.println("Palavra ignorada (caractere inválido): " + palavra);
            }
        }

        System.out.println("Tabela hash preenchida com sucesso.");

        exibirTabelaHash(tabelaHash);

        // Exemplo
        String palavraBusca = "Maçã"; // Pode ser mudado para testes**
        if (buscarPalavra(palavraBusca, tabelaHash, totalCategorias)) {
            System.out.println("A palavra " + palavraBusca + " foi encontrada.");
        } else {
            System.out.println("A palavra " + palavraBusca + " não foi encontrada.");
        }
    }
}