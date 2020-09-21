package Exam_System;

import java.io.FileWriter;

public class Main {
    public static void main(String args[]){
        try{

            FileWriter fw = new FileWriter("C:/Users/MFY/Desktop/I-LOVE-GIT-COMMITS/file.txt");

            String message = (char) ((int) (Math.random()*24));
            System.out.println(message);
            fw.write(message);



            fw.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}