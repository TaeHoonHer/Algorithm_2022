
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
	 return this.name.compareTo(student.name);
	 //return this.id - student.id;
   }
   
   
   
   public String getName() { return name;}
   public int getid()  { return id;}
   public int getgrade() { return grade;}
}

public class Quiz_3 {

   public static void main(String[] args) {
	   
	   Student[] arr = {
			   new Student("taehoon", 20205274, 22) ,
			   new Student("minji",20208765,32) ,
			   new Student("jaemin",19230923,12),
			   new Student("Josh",16208080,97),
			   new Student("youmin",16208080,97),
			   new Student("semin",17209090,73),
			   new Student("suchan",18909012,43),
			   new Student("del",20207878,13),
			   new Student("Abdul",19299090,90),
			   new Student("Kim",17298989,100)
	   };
	   
	   Arrays.sort(arr);
       for(Student student : arr) {
          System.out.println(student.getName() + " " +
                         student.getid() + " " +
                         student.getgrade());
       }
      
       Arrays.sort(arr,Collections.reverseOrder());
       
       System.out.println();
       
       for(Student student : arr) {
          System.out.println(student.getName() + " " +
                         student.getid() + " " +
                         student.getgrade());
       }
       
         

   }

}