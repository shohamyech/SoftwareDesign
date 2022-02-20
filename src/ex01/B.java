package ex01;

public class B implements C {
    int num;

    public B(int num) {
        this.num = num;
        System.out.println("B created, num " + num);
    }

    @Override
    public void f1() {
        System.out.println("f1");
    }

    @Override
    public void f2() {
        System.out.println("f2");
    }
}
