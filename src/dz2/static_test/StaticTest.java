package dz2.static_test;

import dz2.static_test.InfoStatic;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println("��������� ���� (��������� ����� �����): " + InfoStatic.date);
        System.out.println("��������� ���� (��������� ����� ������): " + new InfoStatic().date);
        System.out.println("��������� ����� (��������� ����� �����): " + InfoStatic.getfreeMemory());
    }
}
