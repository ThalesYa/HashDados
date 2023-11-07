import org.junit.Test;

public class TesteDeDesempenho {
    @Test

    public void testeDesempenhoInserirHashDivisao(){
        int[] tamanhos = {14000, 70000, 350000, 700000, 3500000};
        int[] tamanhosDados = {20000, 100000, 500000, 1000000, 5000000};

        for (int tamanho : tamanhos) {
            for (int tamanhoDados : tamanhosDados) {
                System.out.println("=============================");
                System.out.println("TABELA HASH (Divisao)");
                System.out.println("Tamanho da Tabela: " + tamanho);
                System.out.println("Tamanho dos Dados: " + tamanhoDados + " elementos");

                long tempoTotalExecucao = 0;
                long totalColisoes = 0;

                for (int i = 0; i < 5; i++) {
                    HashNegocio tabelaHash = new HashNegocio(tamanho);
                    tabelaHash.PreencherLista();

                    long startTime = System.nanoTime();

                    for (int j = 0; j < tamanhoDados; j++) {
                        int dado = (int) (Math.random() * 900000000) + 100000000; // Gera números de 9 dígitos
                        Registro registro = new Registro(dado);
                        tabelaHash.InserirHashDivisao(registro); // Use a função de inserção com divisão
                        totalColisoes += tabelaHash.getColisoes();
                    }

                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    tempoTotalExecucao += executionTime;

                    System.out.println("Execução " + (i + 1) + ": " + executionTime + " ns" + "///" + "Quantidade de colisões: " + totalColisoes);
                }

                long tempoMedioExecucao = tempoTotalExecucao / 5;
                System.out.println("Média das Execuções: " + tempoMedioExecucao + " ns");
                System.out.println("=============================");
            }
        }
    }
    @Test
    public void testeDesempenhoInserirHashMultiplicacao(){
        int[] tamanhos = {14000, 70000, 350000, 700000, 3500000};
        int[] tamanhosDados = {20000, 100000, 500000, 1000000, 5000000};

        for (int tamanho : tamanhos) {
            for (int tamanhoDados : tamanhosDados) {
                System.out.println("=============================");
                System.out.println("TABELA HASH (Multiplicacao)");
                System.out.println("Tamanho da Tabela: " + tamanho);
                System.out.println("Tamanho dos Dados: " + tamanhoDados + " elementos");

                long tempoTotalExecucao = 0;
                long totalColisoes = 0;

                for (int i = 0; i < 5; i++) {
                    HashNegocio tabelaHash = new HashNegocio(tamanho);
                    tabelaHash.PreencherLista();

                    long startTime = System.nanoTime();

                    for (int j = 0; j < tamanhoDados; j++) {
                        int dado = (int) (Math.random() * 900000000) + 100000000; // Gera números de 9 dígitos
                        Registro registro = new Registro(dado);
                        tabelaHash.InserirHashMultiplicacao(registro); // Use a função de inserção com divisão
                        totalColisoes += tabelaHash.getColisoes();
                    }

                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    tempoTotalExecucao += executionTime;

                    System.out.println("Execução " + (i + 1) + ": " + executionTime + " ns" + "///" + "Quantidade de colisões: " + totalColisoes);
                }

                long tempoMedioExecucao = tempoTotalExecucao / 5;
                System.out.println("Média das Execuções: " + tempoMedioExecucao + " ns");
                System.out.println("=============================");
            }
        }
    }
    @Test
    public void testeDesempenhoInserirHashDobramento(){
        int[] tamanhos = {14000, 70000, 350000, 700000, 3500000};
        int[] tamanhosDados = {20000, 100000, 500000, 1000000, 5000000};

        for (int tamanho : tamanhos) {
            for (int tamanhoDados : tamanhosDados) {
                System.out.println("=============================");
                System.out.println("TABELA HASH (Dobramento)");
                System.out.println("Tamanho da Tabela: " + tamanho);
                System.out.println("Tamanho dos Dados: " + tamanhoDados + " elementos");

                long tempoTotalExecucao = 0;
                long totalColisoes = 0;

                for (int i = 0; i < 5; i++) {
                    HashNegocio tabelaHash = new HashNegocio(tamanho);
                    tabelaHash.PreencherLista();

                    long startTime = System.nanoTime();

                    for (int j = 0; j < tamanhoDados; j++) {
                        int dado = (int) (Math.random() * 900000000) + 100000000; // Gera números de 9 dígitos
                        Registro registro = new Registro(dado);
                        tabelaHash.InserirHashDobramento(registro); // Use a função de inserção com divisão
                        totalColisoes += tabelaHash.getColisoes();
                    }

                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    tempoTotalExecucao += executionTime;

                    System.out.println("Execução " + (i + 1) + ": " + executionTime + " ns" + "///" + "Quantidade de colisões: " + totalColisoes);
                }

                long tempoMedioExecucao = tempoTotalExecucao / 5;
                System.out.println("Média das Execuções: " + tempoMedioExecucao + " ns");
                System.out.println("=============================");
            }
        }
    }
}
