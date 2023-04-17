public class Main {

public static void main(String[] args) throws InterruptedException {

    Posta posta = new Posta();
    Finestra finestra = new Finestra();

    Thread operatore1 = new Thread(new Operatore(posta, finestra));
    Thread operatore2 = new Thread(new Operatore(posta, finestra));

    Thread cliente1 = new Thread(new Cliente(posta, finestra));
    Thread cliente2 = new Thread(new Cliente(posta, finestra));

    operatore1.start();
    operatore2.start();

    cliente1.start();
    cliente2.start();

    finestra.log("Simulatore Posta avviato");

}
}
