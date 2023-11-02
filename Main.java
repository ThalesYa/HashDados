import java.util.Random;

public class Main {
    public static void main(String[] args) {


        HashNegocio tabelaHash = new HashNegocio();

        int tamanhoEscolhido = 5000; // Escolha o tamanho desejado: 10k, 50k, 1000k, etc.
        Random random = new Random();

        if (tamanhoEscolhido > 0) {
            long startTime = System.nanoTime(); // Tempo inicial

            for (int i = 0; i < tamanhoEscolhido; i++) {
                int dado = random.nextInt(900000000) + 100000000; // Gera números de 9 dígitos
                tabelaHash.InserirHash(dado);
            }

            long endTime = System.nanoTime(); // Tempo final em nanossegundos
            long tempoDecorridoNanos = endTime - startTime;
            double tempoDecorridoMillis = tempoDecorridoNanos / 1e6; // Converter para milissegundos

            System.out.println("Tabela com tamanho: "+ tabelaHash.getTamanho());
            System.out.println("Tabela com: " + tamanhoEscolhido + " elementos inseridos em " + tempoDecorridoMillis + " milissegundos.");
        }

//        // Buscar na tabela
//        int dadoParaBuscar = 395345345;
//        int resultadoBusca = tabelaHash.BuscarTabelaHash(dadoParaBuscar);
//        if (resultadoBusca != -1) {
//            System.out.println("Número " + dadoParaBuscar + " encontrado no índice: " + resultadoBusca);
//        } else {
//            System.out.println("Número " + dadoParaBuscar + " não encontrado");
//        }

    }
}