import java.util.Random;

public class Main {
    public static void main(String[] args) {


        HashNegocio tabelaHash = new HashNegocio();

        int tamanhoEscolhido = 1000000; // Escolha o tamanho desejado: 10k, 50k, 1000k, etc.

//        int[] tamanhos = {10000, 50000, 1000000, 5000000};
        Random random = new Random();

        if (tamanhoEscolhido > 0) {
            for (int i = 0; i < tamanhoEscolhido; i++) {
                int dado = random.nextInt(900000000) + 100000000; // Gera números de 9 dígitos
                tabelaHash.InserirHash(dado);
            }
            System.out.println("Tabela com " + tamanhoEscolhido + " elementos:");
            tabelaHash.MostrarTabelaHash();
        }

        // Buscar na tabela
        int dadoParaBuscar = 395345345;
        int resultadoBusca = tabelaHash.BuscarTabelaHash(dadoParaBuscar);
        if (resultadoBusca != -1) {
            System.out.println("Número " + dadoParaBuscar + " encontrado no índice: " + resultadoBusca);
        } else {
            System.out.println("Número " + dadoParaBuscar + " não encontrado");
        }

    }
}