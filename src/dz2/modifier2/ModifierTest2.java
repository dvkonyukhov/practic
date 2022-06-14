package dz2.modifier2;

import dz2.modifier.Modifier;

public class ModifierTest2 {
    public static void main(String[] args) {
        System.out.println("�������� ��������� ��� ������");
        Modifier modifier = new Modifier("1", "2", "3", "4");
        System.out.println("��������� ����: " + modifier.name);
        // ���������� ���� � ���������� �� ��������� � �������� ������
        //System.out.println(modifier.nameDefaul);
        // ���������� ��������� ����
        //System.out.println(modifier.namePrivate);
        // ���������� ���� protected
        //System.out.println(modifier.nameProtected);
        new ModifierTest3("1", "2", "3", "4").testModifiers();
    }
}

class ModifierTest3 extends Modifier {
    public ModifierTest3(String name, String nameDefaul, String namePrivate, String nameProtected) {
        super(name, nameDefaul, namePrivate, nameProtected);
    }

    void testModifiers() {
        System.out.println("�������� ��������� ��� ������ � ���������� ������");
        ModifierTest3 modifier = new ModifierTest3("1", "2", "3", "4");
        // ���������� ���� � ���������� �� ��������� � �������� ������
        //System.out.println(modifier.nameDefaul);
        // ���������� ��������� ����
        //System.out.println(modifier.namePrivate);
        // �������� ���� protected
        System.out.println("���������� ����: " + modifier.nameProtected);
    }
}