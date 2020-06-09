package Exam_System;

import java.util.ArrayList;
import java.util.Random;

// Java program generate a random AlphaNumeric String
// using Math.random() method
class randomArray {
    private int limit;
    private ArrayList<Integer> list;
    private int lenght;
    Random rd = new Random(); // creating Random object

    randomArray(String lim, String lenght) {
        this.limit = Integer.parseInt(lim);
        this.lenght = Integer.parseInt(lenght);
        list = new ArrayList<Integer>(this.lenght);
    }


    public void createList() {
        for (int i = 0; i < lenght; i++)
            list.add(rd.nextInt()); // storing random integers in an array\
    }

    public ArrayList<Integer> getRandomArray(){
        createList();
        return list;
    }
}

public class Randommy extends randomArray{

    Randommy(String lim, String lenght) {
        super(lim, lenght);
    }

    // function to generate a random string of length n
    public String getAlphaNumericString(int n){

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}