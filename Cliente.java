import javax.swing.*;
import java.awt.*;

public class Cliente implements Runnable {

    private Posta posta;
    private Finestra finestra;
    
    public Cliente(Posta posta, Finestra finestra) {
        this.posta = posta;
        this.finestra = finestra;
    }
    
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep((long) (Math.random() * 4000 + 1000)); // tempo casuale tra 1 e 5 secondi
                Lettera lettera = new Lettera();
                posta.inserisciLettera(lettera);
                finestra.aggiungiCerchio(new CerchioCliente(75, 75, Color.RED)); // primo sportello
                System.out.println("Cliente ha inserito la lettera " + lettera.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
