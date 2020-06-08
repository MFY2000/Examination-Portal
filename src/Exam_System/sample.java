package Exam_System;

class test{
    private int Varabile;

    test(){
        Varabile = 44;
    }

    protected static void methods(){
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
