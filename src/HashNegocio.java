public class HashNegocio {
    private int tamanho;
    private ListaEncadeada[] tabela;
    private int colisoes;


    public HashNegocio(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ListaEncadeada[tamanho];
        PreencherLista();
        this.colisoes = 0;
    }

    public void PreencherLista() {
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    public int FuncaoHashMultiplicacao(int dado) {
        // [m([k.A]mod1)] --> k= chave ou dado, m = tam tabela, A= pertence entre 0 e 1
        double A = 0.6180339887;
        double multiplicacaoka = dado * A; // dado * 0,6180339887
        double fracao = multiplicacaoka - (int) multiplicacaoka; //Arrendondar resultado fracionado
        int i = (int) (tamanho * fracao); // Tamanho da tabela vezes o número
        return i;
    }

    public int FuncaoHashRestoDeDivisao(int dado) {
        int i = dado % tamanho;
        return i;
    }

    public int FuncaoHashDobramento(int dado) {
        int primeiroTrio = dado / 1000000; // Pega os primeiros 3 dígitos
        int segundoTrio = (dado / 1000) % 1000; // Pega os próximos 3 dígitos
        int terceiroTrio = dado % 1000; // Pega os últimos 3 dígitos

        int resultado = primeiroTrio + segundoTrio + terceiroTrio;

        return resultado;

    }


    // METODOS DE INSERCAO ------------------------------------------------------------------------------------------------------

    //Metódos para inserir utilizando resto da divisao como funcao hash
    public void InserirHashDivisao(Registro r) {
        int dado = r.getCodigo();
        int i = FuncaoHashRestoDeDivisao(dado);
        if (tabela[i].getPrimeiro() != null) {
            colisoes++;
        }
        tabela[i].InserirListaEncad(r);
    }


    //Metódos para inserir utilizando multiplicacao como funcao hash
    public void InserirHashMultiplicacao(Registro r) {
        int dado = r.getCodigo();
        int i = FuncaoHashMultiplicacao(dado);
        if (tabela[i].getPrimeiro() != null) {
            colisoes++;
        }
        tabela[i].InserirListaEncad(r);
    }

    //Metódos para inserir utilizando dobramento como funcao hash
    public void InserirHashDobramento(Registro r) {
        int dado = r.getCodigo();
        int i = FuncaoHashDobramento(dado);
        if (tabela[i].getPrimeiro() != null) {
            colisoes++;
        }
        tabela[i].InserirListaEncad(r);
    }


    //------------------------------------------------------------------------------------------------------------------------


    //Metódo de busca
    public int BuscarTabelaHash(int dado) {
        int i = FuncaoHashDobramento(dado); // Encontra o índice usando a função de hash
        ListaEncadeada lista = tabela[i]; // Obtém a lista encadeada no índice

        Node atual = lista.primeiro; // Obtenha a cabeça da lista encadeada

        // Percorre a lista encadeada para procurar o dado
        while (atual != null) {
            if (atual.valor.getCodigo() == dado) {
                //System.out.println("Número encontrado no índice: " + i);
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


    //Getters e setters
    public int getColisoes() {
        return colisoes;
    }

    public int getTamanho() {
        return tamanho;
    }
}
