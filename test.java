package sample;

import java.util.Scanner;
import java.util.Random;

class test_class{
    Scanner obj = new Scanner(System.in);

    public void starter (){
        int type = 0;
        do {
            System.out.print("Enter type (Book *> 1 / Magzines *> 2 / Exit *> 0) you wants to publish: ");
            type = obj.nextInt();

            if (type== 0){
                return;
            }

            else if(type == 1){
                Books publishType = new Books();
                publishType.Book();
                publishType.taskeorder();
            }

            else if(type == 2){
                Magzines publishType = new Magzines();
                publishType.MAgzine();
                publishType.taskeorder();
            }

            else if(type >= 2){
                System.out.println("!404 no root found(enter the correct input)");
            }
        }while (type >= 2);
    }
}
public class test {
    public static void main(String[] args) {
        test_class ways = new test_class();
        ways.starter();
    }
}



class Publication{
    Scanner obj = new Scanner(System.in);
    Random rand = new Random();
    String publicationDate;
    int noOfPages;
    String title;
    int price;
    int noOfBooks;
    void Copyrighted(String currentYear, String copyrightYear){
        int day_current_year,month_current_year,day_copyright_year=1,month_copyright_year=12;
        int response = Integer.parseInt(currentYear);
        System.out.println("Enter Todays day");
        day_current_year = obj.nextInt();
        month_current_year = obj.nextInt();
        int till_copy =response +1;
        System.out.println("Date : "+day_current_year+" "+month_current_year+" "+currentYear);
        System.out.println("Copy right : "+day_copyright_year+" "+month_copyright_year+" "+till_copy);
    }
    void publishCheck(){
        String check;
        System.out.println("Check for publish : ");
        check = obj.next();
        switch(check){
            case "yes":
                System.out.println("Publish");
                break;
            case "No":
                System.out.println("Not Publish");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}

class Books extends Publication{
    public long ISBN = (Long) (rand.nextLong() % 100000000000000L) + 1400000000000000L;
    public String author;
    public int price;
    public int quantity;

    void Book(){
        System.out.print("Enter year present : ");
        String year = obj.next();
        System.out.print("Enter year Copy right : ");
        String yearcopyr = obj.next();
        Copyrighted(year,yearcopyr);
        System.out.print("Title:  ");
        title=obj.next();
        System.out.print("Price : ");
        price=obj.nextInt();
        System.out.print("Author : ");
        author=obj.next();
        System.out.println("ISBN :"+ISBN);
        System.out.print("No pages : ");
        do{
            noOfPages = obj.nextInt();
            if(noOfPages <= 1){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }while (noOfPages < 1);

        do{
            System.out.print("Total quantity: ");
            quantity = obj.nextInt();
            if(quantity < 1){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }while (quantity < 1);

        System.out.print("Publish date : ");
        publicationDate = obj.next();

        System.out.println("    Your Book Details: ");
        System.out.println("     title: "+title);
        System.out.println("      price: "+price);
        System.out.println("       author: "+author);
        System.out.println("        ISBN: "+ISBN);
        System.out.println("         noOfPages: "+noOfPages);
        System.out.println("          publicationDate: "+publicationDate);

    }
    void taskeorder(){
        System.out.print("Enter No of books :   ");
        noOfBooks = obj.nextInt();
        orderBooks(noOfBooks);
        remainingBooks();
    }

    void orderBooks(int noOfBooks){

        int total = noOfBooks * price;

        if(total > 10000){
            float discount = total * 0.1f;

            float result = total - discount;

            System.out.println("Price after discount : "+result);
        }
        else{
            System.out.println("Total price : "+total);
        }
    }

    void remainingBooks(){
        int remaining_books=quantity - noOfBooks;
        System.out.println("Reamiang books : "+remaining_books);
    }
}

class Magzines extends Publication{
    String Catagory;
    String issue;
    int noOfCopies;

    void Copyrighted(String currentYear, String copyrightYear){
        int day_current_year,month_current_year,day_copyright_year=1,month_copyright_year=12;
        int response = Integer.parseInt(currentYear);
        System.out.println("Enter Todays day");
        day_current_year = obj.nextInt();
        month_current_year = obj.nextInt();
        int till_copy =response +1;
        System.out.println("Date : "+day_current_year+" "+month_current_year+" "+currentYear);
        System.out.println("Copy right : "+day_copyright_year+" "+month_copyright_year+" "+till_copy);
    }
    void publishCheck(){
        String check;
        System.out.println("Check for publish : ");
        check = obj.next();
        switch(check){
            case "yes":
                System.out.println("Publish");
                break;
            case "No":
                System.out.println("Not Publish");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    void MAgzine(){
        System.out.println("Enter year present : ");
        String year  = obj.next();
        System.out.println("Enter year Copy right : ");
        String yearcopyr = obj.next();
        Copyrighted(year,yearcopyr);
        System.out.println("Title:  ");
        title=obj.next();
        System.out.println("Price : ");
        price=obj.nextInt();
        System.out.println("No pages : ");
        noOfPages = obj.nextInt();
        System.out.println("Total quantity: ");
        noOfCopies = obj.nextInt();
        if(noOfCopies > 1){
            System.out.println(noOfCopies);
        }
        else{
            System.out.println("Invalid quantity");
        }
        System.out.println("Publish date : ");
        issue = obj.next();

        System.out.println("Your Magzines : ");
        System.out.println(title);
        System.out.println(price);
        System.out.println(noOfPages);
        System.out.println(publicationDate);
    }
    void taskeorder(){
        System.out.println("Enter No of books :   ");
        noOfCopies = obj.nextInt();
        orderBooks(noOfCopies);
        remainingBooks();
    }

    void orderBooks(int noOfBooks){

        int total = noOfBooks * price;

        if(total > 10000){
            float discount = total * 0.05f;

            float result = total - discount;

            System.out.println("Price after discount : "+result);
        }
        else{
            System.out.println("Total price : "+total);
        }
    }

    void remainingBooks(){
        int remaining_books=noOfCopies - noOfBooks;
        System.out.println("Reamiang books : "+remaining_books);
    }

    void check_last(){
        System.out.println("First check the publition");
        publishCheck();
    }
}

