package otherjavaexamples;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yujian on 2018/2/11.
 */
public class ReflectionDemo {
    @Test
    public void fun1() throws Exception {
        String className = "otherjavaexamples.User";
        Class clazz = Class.forName(className);
        User user = new User("zhangSan", "123");

        Field field1 = clazz.getDeclaredField("username");
        Field field2 = clazz.getDeclaredField("password") ;

        //注意，User类的username和password成员变量为private的，
        // 这时再通过Field来反射操作这两个成员变量就必须先通过setAccessible(true)设置后才行。
        field1.setAccessible(true);
        field2.setAccessible(true);

        String username = (String)field1.get(user);
        String password = (String)field2.get(user);

        System.out.println(username + ", " + password);

        field1.set(user, "liSi");
        field2.set(user, "456");

        System.out.println(user);
    }

    @Test
    public  void fun2() throws Exception{
        String className = "otherjavaexamples.User";
        Class clazz = Class.forName(className);
        Constructor c = clazz.getConstructor(String.class,String.class);
        User user = (User)c.newInstance("zhangsan","24");
        System.out.println(user);

        Method method = clazz.getMethod("toString");
        String result = (String)method.invoke(user);
        System.out.println(result);
    }
}

class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
}
