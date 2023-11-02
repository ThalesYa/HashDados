public class Colisoes {
    public int totalColisoes;

    public Colisoes() {
        totalColisoes = 0;
    }

    public void incrementarColisoes() {
        totalColisoes++;
    }

    public int getTotalColisoes() {
        System.out.println("O número total de colisões foi " + totalColisoes);
        return totalColisoes;
    }


}

