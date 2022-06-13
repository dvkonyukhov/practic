package dz2.modifier;

public class ModifierTest {
    public static void main(String[] args) {
        System.out.println("Проверка видимости в пределах пакета");
        Modifier modifier = new Modifier("1", "2", "3", "4");
        System.out.println("Публичное поле: " + modifier.name);
        System.out.println("В пределах пакета(по умолчанию) поле: " + modifier.nameDefaul);
        // недоступно приватное поле
        //System.out.println(modifier.namePrivate);
        System.out.println("Защищенное поле: " + modifier.nameProtected);
    }
}
