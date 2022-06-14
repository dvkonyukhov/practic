package dz2.polymorf;

public class Pianino extends MusicInstrument{
    @Override
    public void sound()
    {
        System.out.println("pianino sound");
    }

    public Pianino() {
        System.out.println("Конструктор пианино");
    }
}
