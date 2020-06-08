package Exam_System;

class test{
    private int Varabile;

    test(){
        Varabile = 44;
    }

    private static void methods(int i){
        System.out.println("Hello");
    }
    public static void methods(){
        System.out.println("Hello");
    }

}

public class sample {
    public static void main(String[] args) {
        test check = new test();
        check.methods();

        test.methods();
    }
}
