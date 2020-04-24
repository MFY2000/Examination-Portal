package sample;


class person{
    final int rollnumber;
    public final static int staticMain = 44;

    person() {
        this.rollnumber = 101;
    }
    public void display(final int para){
//        para += 20; cannot do this
        System.out.println(rollnumber+" "+para);
    }
    final public void add(){
        System.out.println("methods which is final");
    }
}

final class teacher extends person{
    teacher(){
        super();
    }
//    public void add(){
//        // cannot override this methods
//    }

    public void display(int para){
        super.display(12);
    }

}

public class test{
    public static void main(String[] args) {
        person Fahad = new person();
        Fahad.display(13);
        Fahad.add();
        System.out.println(person.staticMain);

        teacher t1 = new teacher();


    }
}