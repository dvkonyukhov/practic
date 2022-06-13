package dz2.polymorf;

import java.util.ArrayList;
import java.util.List;

public class PolymorfTest {
    public static void main(String[] args) {
        List<MusicInstrument> musicInstrumentList = new ArrayList<>();

        musicInstrumentList.add(new Gitara());
        musicInstrumentList.add(new Pianino());
        musicInstrumentList.add(new MusicInstrument());

        for (MusicInstrument element:musicInstrumentList
             ) {
            element.sound();
        }
    }
}
