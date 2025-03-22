package inheritance;


class Student {
 String name;
 int age;
 
 
 public Student() {
     System.out.println("Student Default Constructor Called");
 }

 
 public Student(String name, int age) {
     this.name = name;
     this.age = age;
     System.out.println("Student Parameterized Constructor Called: Name = " + name + ", Age = " + age);
 }
}


class ZSGSStudent extends Student {
 String course;
 
 
 public ZSGSStudent() {
     super();  
     System.out.println("ZSGSStudent Default Constructor Called");
 }

 
 public ZSGSStudent(String name, int age, String course) {
     super(name, age);  
     this.course = course;
     System.out.println("ZSGSStudent Parameterized Constructor Called: Course = " + course);
 }
}


public class StudentDemo {
 public static void main(String[] args) {
     System.out.println("\nCreating ZSGSStudent with Default Constructor:");
     ZSGSStudent stud1 = new ZSGSStudent();
     
     System.out.println("\nCreating ZSGSStudent with Parameterized Constructor:");
     ZSGSStudent stud2 = new ZSGSStudent("Madhu", 22, "Java Programming");
     
     System.out.println("\nCreating Child Object Using Parent Reference:");
     Student stud3 = new ZSGSStudent("Navin", 22, "Full Stack Development");
 }
}
