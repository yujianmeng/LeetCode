package otherjavaexamples.clone;

/**
 * Created by yujian on 2018/2/11.
 */
public class Student implements Cloneable{
    private int age;
    private String name;
    private Professor professor;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString(){
        return "Student [name=" + name + ", age=" + age + ", professor="+ professor + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Student newStudent = (Student)super.clone();
        newStudent.professor = (Professor)professor.clone();
        return newStudent;
    }
}
