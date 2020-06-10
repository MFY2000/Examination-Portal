package Exam_System;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// Java program generate a random AlphaNumeric String
// using Math.random() method
class randomArray {
    private ArrayList<Integer> list;
    private int lenght;
    private int limit;
    Random rd = new Random(); // creating Random object

    randomArray(String lenght ,String lim) {
        this.limit = Integer.parseInt(lim);
        this.lenght = Integer.parseInt(lenght);
        list = new ArrayList<Integer>(this.limit);
    }




    public void createList() {
        int temp;
        for (int i = 0; i < limit; i++) {
            temp = ThreadLocalRandom.current().nextInt(1, lenght);
            if (list.contains(temp)){
                i--;
            }else {
                list.add(temp);
            }
            // storing random integers in an array\
        }
    }

    public ArrayList<Integer> getRandomArray(){
        createList();
        return list;
    }
}

public class Randommy extends randomArray{

    Randommy(String lenght, String lim) {
        super(lenght, lim);
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