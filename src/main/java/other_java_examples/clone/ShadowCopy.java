package other_java_examples.clone;

/**
 * Created by yujian on 2018/2/11.
 */
public class ShadowCopy {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setAge(45);
        professor.setName("Professor Zhang");

        Student student1 = new Student();
        student1.setAge(22);
        student1.setName("LiWei");
        student1.setProfessor(professor);

        System.out.println(student1);

        try{
            Student student2 = (Student) student1.clone();
            student2.setAge(23);
            student2.setName("WangWei");
            Professor professor2 = student2.getProfessor();
            professor2.setAge(34);
            professor2.setName("Professor Yu");
            student2.setProfessor(professor2);

            System.out.println("复制后的：s1 = " + student1);
            System.out.println("复制后的：s2 = " + student2);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
