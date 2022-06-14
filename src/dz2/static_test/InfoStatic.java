package dz2.static_test;

import java.util.Date;

public class InfoStatic {
    public static Date date = new Date();
    public static String name;
    public String nameNonStatic;

    static {
        System.out.println("������������� ���������� �����");
        // ������ ���������� � ������������ ���� �� ���������� �����
        //System.out.println("�������� ����������� ���������� = " + nameNonStatic);
        name = "��������� ����";
    }
    public InfoStatic() {
        // ����� ���������� � ���������� ���� �� ������������
        System.out.println("�������� ����������� ���������� = " + nameNonStatic);
        System.out.println("������������� ������������");
    }

    public static Long getfreeMemory(){
        // ������ ���������� � ������������ ���� �� ���������� �����
        //System.out.println("�������� ����������� ���������� = " + nameNonStatic);
        System.out.println("������������� ���������� ������");
        return Runtime.getRuntime().freeMemory();
    }
}
