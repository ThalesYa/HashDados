public class HashNegocio {
    private int tamanho;
    private ListaEncadeada[] tabela;

    public HashNegocio(){
        this.tamanho = 100000;
        tabela = new ListaEncadeada[tamanho];
        PreencherLista();
    }

    public void PreencherLista(){
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    public int FuncaoHashMultiplicacao(int dado) {
        double A = 0.6180339887;
        double multiplicacaoka = dado * A; // dado * 0,6180339887
        double fracao = multiplicacaoka - (int) multiplicacaoka; //Arrendondar resultado fracionado
        int i = (int) (tamanho * fracao); // Tamanho da tabela vezes o número
        return i; // Retorna o krl
    }

    public int FuncaoHashRestoDeDivisao(int dado){
        int i = dado % tamanho;
        return i;
    }

    public int FuncaoHashDobramento(int dado){
            int dobramento = 0; // Variável auxiliar para o dobramento
            int ultimodado = dado; //Variável auxiliar para remover os digitos e somando no dobramento

            while (ultimodado > 0) { // Loop para identificar se nossa variável auxiliar está vazia
                int digito = ultimodado % 10; // Pega o último dígito da nossa variável
                dobramento += digito; //Adiciona e soma na nossa Variável auxiliar de dobramento
                ultimodado /= 10; // Remove o último dígito
            }

            int i = FuncaoHashRestoDeDivisao(dobramento); //Chama a função que pega o mod do número pelo tamanho da tabela
            return i; // Rertorna o indice para adicionar na tabela
    }

    public void InserirHash(int dado){
        int i = FuncaoHashMultiplicacao(dado);
        tabela[i].InserirListaEncad(dado);
    }

    public int BuscarTabelaHash(int dado) {
        int i = FuncaoHashDobramento(dado); // Encontra o índice usando a função de hash
        ListaEncadeada lista = tabela[i]; // Obtém a lista encadeada no índice

        Node atual = lista.primeiro; // Obtenha a cabeça da lista encadeada

        // Percorre a lista encadeada para procurar o dado
        while (atual != null) {
            if (atual.valor == dado) {
                System.out.println("Número encontrado no índice: " + i);
                return i;
            }
            atual = atual.proximo;
        }

        System.out.println("Número não encontrado");
        return -1; // Retorna -1 se o dado não for encontrado
    }

    public void MostrarTabelaHash() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Linha[" + i + "]: ");
            ListaEncadeada lista = tabela[i]; // Obtém a lista encadeada no índice
            Node atual = lista.primeiro; // Obtenha a cabeça da lista encadeada

            while (atual != null) {
                System.out.print(atual.valor + " -> ");
                atual = atual.proximo;
            }

            System.out.println("NULL");
        }
    }

}
