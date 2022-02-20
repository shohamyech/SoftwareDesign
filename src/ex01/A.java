package ex01;

public class A implements C {
    public A() {
        System.out.println("A created");
    }

    @Override
    public void f1() {
        System.out.println("f1");
    }

    @Override
    public void f2() {
        System.out.println("f2");
    }

    public void f3() {
        System.out.println("f3");
    }
}
