package ex01;

public class Main {
    public static void main(String[] args) {
        int x = 5;
        String y= "hello";

        B  b1  =  new B(100);
        C[]  arrC = new C[3];
        arrC[0]  =  new B(99);
        arrC[1]  =  new A();
        arrC[2]  =  new B(5);
        arrC[0].f1();
        arrC[0].f2();
        ((A)arrC[1]).f3();
    }
}
