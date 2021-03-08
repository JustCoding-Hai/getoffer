package top.javahai.interview.javase;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/1 - 11:29
 **/
public class AnnotationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Class<User> userClass = User.class;
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        //通过反射得到类上的注解
        MyAnnotation myAnnotation = userClass.getAnnotation(MyAnnotation.class);
        int id = myAnnotation.id();
        String name = myAnnotation.name();
        String gender = myAnnotation.gender();
        //将注解的值注入到对象中
        user.setId(id);
        user.setName(name);
        user.setGender(gender);
        Object clone = user.clone();
        System.out.println(user);
    }
}
