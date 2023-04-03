import javax.swing.*;
import java.awt.*;

public class Finestra {

    private JFrame frame;
    private JTextArea textArea;

    public Finestra() {
        frame = new JFrame("Simulatore Posta");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void log(String messaggio) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(messaggio + "\n");
            textArea.setCaretPosition(textArea.getDocument().getLength());
        });
    }

}
       
