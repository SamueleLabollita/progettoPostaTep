import java.util.concurrent.Semaphore;

public class Posta {

    private Semaphore semaforoLettere = new Semaphore(0, true);
    private Semaphore semaforoPosta = new Semaphore(1, true);
    private Lettera lettera;

    public void inserisciLettera(Lettera lettera) throws InterruptedException {
        semaforoPosta.acquire();
        this.lettera = lettera;
        semaforoLettere.release();
        semaforoPosta.release();
    }

    public Lettera prelevaLettera() throws InterruptedException {
        semaforoLettere.acquire();
        semaforoPosta.acquire();
        Lettera lettera = this.lettera;
        semaforoPosta.release();
        return lettera;
    }

    public void spedisciLettera(Lettera lettera) {
        this.lettera = null;
    }
}
