import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Finestra {

private JFrame frame;
private JPanel panel;

private List<CerchioCliente> cerchiClienti;

public Finestra() {
    frame = new JFrame("Simulatore Posta");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(50, 50, 250, 100);
            g.fillRect(350, 50, 250, 100);
            for (CerchioCliente cerchio : cerchiClienti) {
                g.setColor(cerchio.getColore());
                g.fillOval(cerchio.getX(), cerchio.getY(), 30, 30);
            }
        }
    };

    panel.setPreferredSize(new Dimension(700, 250));

    cerchiClienti = new ArrayList<>();

    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
}

public void log(String messaggio) {
    // non implementato per questa versione della finestra
}

public synchronized void aggiungiCerchio(CerchioCliente cerchio) {
    cerchiClienti.add(cerchio);
    panel.repaint();
}

public synchronized void rimuoviCerchio(CerchioCliente cerchio) {
    cerchiClienti.remove(cerchio);
    panel.repaint();
}
}


class CerchioCliente {

    private int x;
    private int y;
    private Color colore;
    
    public CerchioCliente(int x, int y, Color colore) {
        this.x = x;
        this.y = y;
        this.colore = colore;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColore() {
        return colore;
    }
}

 
