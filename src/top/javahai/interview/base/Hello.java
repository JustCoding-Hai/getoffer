package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/18 - 10:49
 **/
public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();

    }
}

class A {
    static {
        System.out.println("A1");
    }

    public A() {
        System.out.println("A2");
    }
}

class B extends A {
    static {
        System.out.println("B1");
    }

    public B() {
        System.out.println("B2");
    }
}
