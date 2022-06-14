package dz2.modifier2;

import dz2.modifier.Modifier;

public class ModifierTest2 {
    public static void main(String[] args) {
        System.out.println("Проверка видимости вне пакета");
        Modifier modifier = new Modifier("1", "2", "3", "4");
        System.out.println("Публичное поле: " + modifier.name);
        // недоступно поле с видимостью по умолчанию в пределах пакета
        //System.out.println(modifier.nameDefaul);
        // недоступно приватное поле
        //System.out.println(modifier.namePrivate);
        // недоступно поле protected
        //System.out.println(modifier.nameProtected);
        new ModifierTest3("1", "2", "3", "4").testModifiers();
    }
}

class ModifierTest3 extends Modifier {
    public ModifierTest3(String name, String nameDefaul, String namePrivate, String nameProtected) {
        super(name, nameDefaul, namePrivate, nameProtected);
    }

    void testModifiers() {
        System.out.println("Проверка видимости вне пакета у наследника класса");
        ModifierTest3 modifier = new ModifierTest3("1", "2", "3", "4");
        // недоступно поле с видимостью по умолчанию в пределах пакета
        //System.out.println(modifier.nameDefaul);
        // недоступно приватное поле
        //System.out.println(modifier.namePrivate);
        // доступно поле protected
        System.out.println("Защищенное поле: " + modifier.nameProtected);
    }
}