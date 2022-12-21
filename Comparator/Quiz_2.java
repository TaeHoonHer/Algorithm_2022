
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>{
	//Student 클래스 생성
   private String name;
   private int id;
   private int grade;
   
   
   //생성자
   public Student(String name, int id, int grade) {
      this.name = name;
      this.id = id;
      this.grade = grade;
      //반환
   }
   
   
   public String toString() {
      return "{name: " + name + ", id: "+ id +", grade: " + grade + "}";
   }
   
   
   
   public int compareTo(Student student) {
      //return this.grade - student.grade;
	   //return this.name.compareTo(student.name);
	  return this.id - student.id;
   }
   
   
   public String getName() { return name;}
   public int getid()  { return id;}
   public int getgrade() { return grade;}
}

public class Quiz_2 {

   public static void main(String[] args) {
   //Create list of strings
      ArrayList<Student> List = new ArrayList<Student>();
       List.add(new Student("taehoon",20208008,42));
       List.add(new Student("minji",20208765,32));
       List.add(new Student("omin", 20201234, 41));
       List.add(new Student("jaemin",19230923,12));
       List.add(new Student("Josh",16208080,97));
       List.add(new Student("youmin",17209090,73));
       List.add(new Student("semin",18909012,43));
       List.add(new Student("suchan",20207878,13));
       List.add(new Student("del",19299090,90));
       List.add(new Student("Kim",17298989,100));
//       
//       for(Student student : List) {
//          System.out.println(student.getName() + " " +
//                         student.getid() + " " +
//                         student.getgrade());
//       }
      
       Collections.sort(List);
       System.out.println();
       for(Student student : List) {
          System.out.println(student.getName() + " " +
                         student.getid() + " " +
                         student.getgrade());
       }
       
       System.out.println();
       
       Collections.reverse(List);
       System.out.println();
       for(Student student : List) {
          System.out.println(student.getName() + " " +
                         student.getid() + " " +
                         student.getgrade());
       }
       
         

   }

}