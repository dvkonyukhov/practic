package dz2.modifier;

public class ModifierTest {
    public static void main(String[] args) {
        System.out.println("�������� ��������� � �������� ������");
        Modifier modifier = new Modifier("1", "2", "3", "4");
        System.out.println("��������� ����: " + modifier.name);
        System.out.println("� �������� ������(�� ���������) ����: " + modifier.nameDefaul);
        // ���������� ��������� ����
        //System.out.println(modifier.namePrivate);
        System.out.println("���������� ����: " + modifier.nameProtected);
    }
}
