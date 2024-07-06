import java.util.Random;

public abstract class SerVivo {

    Random rand = new Random();

    protected String Nome;
    protected int Vida = rand.nextInt(10,50);
    protected String Tipo;
    protected Arma arma;

    public SerVivo(String nome) {
        Nome = nome;
    }
}

