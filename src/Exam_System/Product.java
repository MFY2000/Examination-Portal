package Exam_System;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {

    private final SimpleIntegerProperty SNO;
    private final SimpleStringProperty Quiz;
    private final SimpleStringProperty Total;
    private final SimpleStringProperty Correct;
    private final SimpleStringProperty Percentage;
    private final SimpleStringProperty time;


    public Product(Integer sno, String percentage, String quiz, String total, String correct, String time){
        SNO = new SimpleIntegerProperty(sno);
        Percentage = new SimpleStringProperty(percentage);
        Quiz =  new SimpleStringProperty(quiz);
        Total = new SimpleStringProperty(total);
        Correct = new SimpleStringProperty(correct);
        this.time = new SimpleStringProperty(time);
    }


    public int getSNO() {
        return SNO.get();
    }

    public SimpleIntegerProperty SNOProperty() {
        return SNO;
    }

    public String getPercentage() {
        return Percentage.get();
    }

    public SimpleStringProperty PercentageProperty() {
        return Percentage;
    }

    public String getTotal() {
        return Total.get();
    }

    public SimpleStringProperty totalProperty() {
        return Total;
    }

    public String getCorrect() {
        return Correct.get();
    }

    public SimpleStringProperty correctProperty() {
        return Correct;
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public String getQuiz() {
        return Quiz.get();
    }

    public SimpleStringProperty quizProperty() {
        return Quiz;
    }
}