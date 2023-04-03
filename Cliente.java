public class Cliente implements Runnable {

    private Posta posta;

    public Cliente(Posta posta) {
        this.posta = posta;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep((long) (Math.random() * 4000 + 1000)); // tempo casuale tra 1 e 5 secondi
                Lettera lettera = new Lettera();
                posta.inserisciLettera(lettera);
                System.out.println("Cliente ha inserito la lettera " + lettera.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
