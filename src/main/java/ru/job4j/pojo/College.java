package ru.job4j.pojo;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Габрусенок Владислав Дмитриевич");
        student.setGroup("РА-18-5");
        student.setEntered(new Date());
        System.out.println(student.getEntered() + ", " + student.getName() + ", " + student.getGroup());
    }
}
