public class Main {

    public static void main(String[] args) throws InterruptedException {

        Posta posta = new Posta();
        Finestra finestra = new Finestra();

        Thread operatore1 = new Thread(new Operatore(posta));
        Thread operatore2 = new Thread(new Operatore(posta));

        Thread cliente1 = new Thread(new Cliente(posta));
        Thread cliente2 = new Thread(new Cliente(posta));

        operatore1.start();
        operatore2.start();

        cliente1.start();
        cliente2.start();

        finestra.log("Simulatore Posta avviato");

    }
}
