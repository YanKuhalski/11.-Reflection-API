package it.academy.basic.classes;

import it.academy.basic.interfaces.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Patient {
    @Generate
    private String name;
    @Generate
    private String secondName;
    @Generate
    private Date birthday;
    @Generate
    private boolean healthy;
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public Patient() {
    }

    @Override
    public String toString() {
        String info = "Name : " + name
                + "\n" + "Surname : " + secondName
                + "\n" + "Birthday : " + sdf.format(birthday)
                + "\n" + "Healthy : " + healthy + "\n";
        return info;
    }
}
