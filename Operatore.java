import javax.swing.*;
import java.awt.*;

public class Operatore implements Runnable {

    private Posta posta;
    private Finestra finestra;
    
    public Operatore(Posta posta, Finestra finestra) {
        this.posta = posta;
        this.finestra = finestra;
    }
    
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Lettera lettera = posta.prelevaLettera();
                if (lettera != null) {
                    finestra.aggiungiCerchio(new CerchioCliente(375, 75, Color.BLUE)); // secondo sportello
                    System.out.println("Operatore ha preso la lettera " + lettera.getId());
                    Thread.sleep((long) (Math.random() * 8000 + 2000)); // tempo casuale tra 2 e 10 secondi
                    posta.spedisciLettera(lettera);
                    finestra.rimuoviCerchio(new CerchioCliente(75, 75, Color.RED)); // primo sportello
                    finestra.rimuoviCerchio(new CerchioCliente(375, 75, Color.BLUE)); // secondo sportello
                    System.out.println("Operatore ha spedito la lettera " + lettera.getId());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
