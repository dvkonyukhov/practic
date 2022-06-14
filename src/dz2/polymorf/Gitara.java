package dz2.polymorf;

public class Gitara extends MusicInstrument{
    @Override
    public void sound()
    {
        System.out.println("gitara sound");
    }

    public Gitara() {
        System.out.println("Конструктор гитара");
    }
}
