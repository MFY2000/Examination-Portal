package Exam_System;
//


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Candidate{
    private String Name;
    private int NoOFVote;

    public Candidate(String name) {
        setName(name);
    }

    public int getNoOFVote() {
        return NoOFVote;
    }

    public void setNoOFVote() {
        ++NoOFVote;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String toString(){
        return ("Candidate is: "+getName()+" Number of Vote: "+getNoOFVote());
    }

}

class VotingMachine{
    public ArrayList<Candidate> listOf;

    public VotingMachine(){
        listOf = new ArrayList<Candidate>();
    }
    public void addCandidate(String Candidatename) throws Exception {
        for (Candidate candidate : listOf) {
            if (candidate.getName().equals(Candidatename)) {
                throw new Exception("Candidate name aleady Exist in the list :)");
            }
        }
        listOf.add(new Candidate(Candidatename));
    }
    public void castVote(String name) throws Exception{

        for (Candidate candidate : listOf) {
            if (candidate.getName().equals(name)) {
                candidate.setNoOFVote();
                return;
            }
        }
        throw new Exception("Candidate name not exist in the list :)");
    }
    public void Winner(){
        int HiggestVote = 0;
        int indexOfWinner = 0;
        for (int i = 0; i < listOf.size(); i++) {
            if(listOf.get(i).getNoOFVote() > HiggestVote){
                HiggestVote = listOf.get(i).getNoOFVote();
                indexOfWinner = i;
            }
        }
        System.out.println("THe Winner Is:");
        System.out.println(listOf.get(indexOfWinner).toString());
    }
    public String toString(){
        String Candidate = "";
        for (Candidate candidate : listOf) {
            Candidate += candidate.toString()+"\n\n";
        }
        return Candidate;
    }
    public int candidateList(){
        return listOf.size();
    }


}

class test{
    public static void main(String[] args){
        VotingMachine machine = new VotingMachine();
        Random randomno = new Random();
        Scanner scan = new Scanner(System.in);

        try {
            //hardcode addCandidate
            machine.addCandidate("Muhammad Fahad");
            machine.addCandidate("Jaffar Abbas");
            machine.addCandidate("M.Talha");
            machine.addCandidate("Talha");
            int temp = scan.nextInt();
            System.out.println("Press \n1 -> addCandidate\n2 -> castVote\n3Veiw Result\n0 -> Exit");
            
            // program to hard code
            machine.castVote("Muhammad Fahad");
            machine.castVote("Jaffar Abbas");
            machine.castVote("M.Talha");
            machine.castVote("Talha");


            // program to random
            for (int i = 0; i < 1000; i++) {
                machine.castVote(machine.listOf.get(randomno.nextInt(machine.candidateList())).getName());
            }



            System.out.println("Candidate List is given Below:");
            System.out.println(machine.toString());
            machine.Winner();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
public class Main{
    public static void main(String[] args) throws Exception{
        test.main(args);
    }
}