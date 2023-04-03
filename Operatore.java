
public class Operatore implements Runnable {

    private Posta posta;

    public Operatore(Posta posta) {
        this.posta = posta;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Lettera lettera = posta.prelevaLettera();
                if (lettera != null) {
                    System.out.println("Operatore ha preso la lettera " + lettera.getId());
                    Thread.sleep((long) (Math.random() * 8000 + 2000)); // tempo casuale tra 2 e 10 secondi
                    posta.spedisciLettera(lettera);
                    System.out.println("Operatore ha spedito la lettera " + lettera.getId());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

