public class Lettera {

    private static int contatore = 0;
    private int id;

    public Lettera() {
        contatore++;
        this.id = contatore;
    }

    public int getId() {
        return id;
    }
}

