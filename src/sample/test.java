package sample;
import java.util.Scanner;

class employee{
    private String firstname;
    private String lastname;
    private int ssn;
    Scanner scan = new Scanner(System.in);

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getLastname() {
        return lastname;
    }

    public int getSsn() {
        return ssn;
    }

    public String getFirstname() {
        return firstname;
    }
}

class HourlyEmployee extends employee{

    private double hours;
    private double wages;

    public void getInput(){
        System.out.print("Enter FirstName: ");
        super.setFirstname(scan.nextLine());

        System.out.print("Enter LastName: ");
        super.setLastname(scan.nextLine());

        System.out.print("Enter social security number: ");
        super.setSsn(scan.nextInt());

        System.out.print("Enter Hours: ");
        this.setHours(scan.nextDouble());

        System.out.print("Enter Wages: ");
        this.setWages(scan.nextDouble());
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if(hours>=0 || hours <= 168) {
            this.hours = hours;
        }
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        if(wages>=0) {
            this.wages = wages;
        }
    }

    public double totalEarning(){
        if(this.getHours()<=40){
            return (this.getHours() * this.getWages());
        }else{
            double hour = this.getHours() - 40;
            return ((40 * this.getWages()) + hour * (getWages() * 1.5));
        }
    }

    @Override
    public String toString() {
        return "Firstname: "+ super.getFirstname() + " Lastname: " + super.getLastname() + " Hours Worked: "+ this.getHours() + " Wages per hour: " + this.getWages() + " Total wages: " + this.totalEarning();
    }
}
public class test {
    public static void main(String[] args) {

        HourlyEmployee employee = new HourlyEmployee();
        employee.getInput();
        System.out.println(employee);
    }
}