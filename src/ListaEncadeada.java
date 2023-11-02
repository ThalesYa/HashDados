public class ListaEncadeada {
        public Node primeiro;

        public ListaEncadeada() {
            primeiro = null;
        }
        public void InserirListaEncad(int data) {
            Node newNode = new Node(data);
            if (primeiro == null) {
                primeiro = newNode;
            } else {

                Node atual = primeiro;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = newNode;
            }
        }
}