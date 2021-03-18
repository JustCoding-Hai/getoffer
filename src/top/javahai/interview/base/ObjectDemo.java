package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/17 - 11:39
 **/
public class ObjectDemo {
    public static void main(String[] args) {
        Person person = new Person("ANAN");
        change(person);
        System.out.println(person.name);

        printNum(123);

        int a = 0;
        switch (a) {
            case 0:
                a++;
            case 1:
                a += 2;
            case 2:
                a += 6;
            default:
                a += 5;
        }
        System.out.println(a);
    }

    private static void change(Person person) {
        person.name = "HIHI";
        Person p = new Person("WEIWEI");
        person = p;
    }

    private static void printNum(int num) {
        int temp;
        for (int i = 0; i < 3; i++) {
            temp = num % 10;
            num = num / 10;
            System.out.println(temp);
        }
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}
