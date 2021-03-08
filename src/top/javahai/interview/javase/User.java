package top.javahai.interview.javase;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/1 - 11:27
 **/
@MyAnnotation(id = 1, name = "张三")
public class User implements Cloneable {
    private int id;
    private String name;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
