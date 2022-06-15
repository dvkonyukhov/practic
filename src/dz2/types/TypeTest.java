package dz2.types;

import javax.swing.text.StyledEditorKit;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class TypeTest {
    public static void main(String[] args) {

        byte b = 123;
        short sh = 444;
        int i = 123_123_123;
        Integer i2 = 123_123_123;
        long l = 999_999_999L;
        float f = 123.123f;
        double d = 555;
        char ch = 'p';
        String str = "123";
        boolean bool = true;
        AtomicBoolean bool1 = new AtomicBoolean(false);

        sh = b;
        b = (byte) Long.MAX_VALUE;
        i = (int) l;
        d = f % 2;
        ch = 't';
        i = new Random().nextInt(100);
        // нельзя
        //bool = (boolean) bool1;
        i = i2;
        str = str + ch;
        str = String.valueOf(888);
        i = Integer.parseInt("456");

    }
}
