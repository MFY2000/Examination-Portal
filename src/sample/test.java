package sample;

import java.util.ArrayList;
import java.util.Scanner;
/*
4. You are required to design a class named computer. Each computer has a companyName,
model, color, processorType and price. A type of computer is DesktopComputer, that
has companyName, model, color, processorType, price and
monitorDimensions. Another type of computer is LaptopComputer that has companyName,
model, color, processorType, price, camera, size and weight.
a. Identify abstract and concrete classes and design the above hierarchy using appropriate
Object-Oriented Programming principles. Also use an abstract method to displayData().
b. Create a driver file in which
· Create an ArrayList named computerList of size n with computer as declared type.
· The program should then take ‘type of Computer’ as input from the user n times and in
each iteration, instantiate index of list with entered type.
· Call the overridden method for each index of the list
*/

abstract class computer{
    String companyName, model, color, processorType;
    int price;
    Scanner scan = new Scanner(System.in);


    public abstract void TakeInput();
    public abstract String toString();
}

class DesktopComputer extends computer{
    public String monitorDimensions;

    public void TakeInput(){
        System.out.print("Enter the company name of the DesktopComputer: ");
        companyName = scan.nextLine();

        System.out.print("Enter the model of the DesktopComputer: ");
        model = scan.nextLine();

        System.out.print("Enter the color of the DesktopComputer: ");
        color = scan.nextLine();

        System.out.print("Enter the processorType of the DesktopComputer: ");
        processorType = scan.nextLine();

        System.out.print("Enter the price of the DesktopComputer: ");
        price = scan.nextInt();

        System.out.print("Enter the monitorDimensions of the DesktopComputer: ");
        monitorDimensions = scan.nextLine();

        System.out.println("Now all the details are saved");
    }

    public String toString(){
        return(companyName+ model+ color+ processorType+price+monitorDimensions);
    }

}

class LaptopComputer extends computer{
    double  camera, size, weight;

    public void TakeInput(){
        System.out.print("Enter the company name of the LaptopComputer: ");
        companyName = scan.nextLine();

        System.out.print("Enter the model of the LaptopComputer: ");
        model = scan.nextLine();

        System.out.print("Enter the color of the LaptopComputer: ");
        color = scan.nextLine();

        System.out.print("Enter the processorType of the LaptopComputer: ");
        processorType = scan.nextLine();

        System.out.print("Enter the price of the LaptopComputer: ");
        price = scan.nextInt();

        System.out.print("Enter the camera of the LaptopComputer: ");
        camera = scan.nextDouble();

        System.out.print("Enter the Size of the LaptopComputer: ");
        size = scan.nextDouble();

        System.out.print("Enter the weight of the LaptopComputer: ");
        weight = scan.nextDouble();

        System.out.println("Now all the details are saved");
    }

    public String toString(){
        return(companyName+ model+ color+ processorType+price+ camera+ size+ weight);
    }
}
public class test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the lenght/n times of the computer Array: ");
        int num = scan.nextInt();

        ArrayList<computer> typeOfComputer = new ArrayList<computer>(num);
        computer ref;
        int type;
        for (int i = 0; i < num; i++) {
            System.out.print("Enter the type Of computer (1 => DesktopComputer,2 => LaptopComputer): ");
            type = scan.nextInt();

            switch (type) {
                case 1:
                    typeOfComputer.add(new DesktopComputer());
                    ref = typeOfComputer.get(0);
                    ref.TakeInput();
                    break;

                case 2:
                    typeOfComputer.add(new LaptopComputer());
                    ref = typeOfComputer.get(0);
                    ref.TakeInput();
                    break;
                default:
                    System.out.println("You Enter a wrong thing again enter the type :)");
                    i--;
                    break;
            }
        }


        for (computer member : typeOfComputer) {
            System.out.println(member.toString());
        }
    }
}