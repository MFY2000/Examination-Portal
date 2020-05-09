package sample;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Instructor MAJU =  new Instructor();
        Student S1 = new Student("Muhammad Fahad","FA19-BSSE-0014","BSSE");
        Teacher T1 = new Teacher();
        MAJU.assignedStudent(S1,T1);

        T1.GiveLecture();
        S1.GiveQuiz(T1);
    }
}

class Teacher{
    public ArrayList<Student> studentList = new ArrayList<Student>(1);



    Teacher() {

    }
    public void takeStudent(Student student){
        studentList.add(student);
        System.out.println(student.toString());
    }

    public void GiveLecture(){
        Student s = studentList.get(0);
        System.out.println("Lecture is given to student dialy");
        s.LectureGiven++;
    }

    public int QuizTaken(String AnswerSheet){
        //After checking the mask Assign
        System.out.println("Quiz is taken weekly by the Student :)");
    return 45;
    }


}

class Student{
    public String name;
    public String rollno;
    public String coruse;
    public int LectureGiven = 0;
    public int Mask = 0;


    Student(String name,String rollno,String coruse){
        this.name = name;
        this.rollno = rollno;
        this.coruse = coruse;
    }

    public void GiveQuiz(Teacher teacher){
        Mask = teacher.QuizTaken("Some data must have to be given");
    }


    public String toString(){
        return ("Student Name: "+name+"\nRoll number:"+rollno+"\nCoruse: "+coruse);
    }
}

class Instructor{

    public void assignedStudent(Student student,Teacher teacher){
        System.out.println("Student 1 ..... is Assigned to Teacher 1 .......");
        teacher.takeStudent(student);
    }
}
