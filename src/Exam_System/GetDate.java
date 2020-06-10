package Exam_System;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public String get() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return  formatter.format(date);
    }
}
