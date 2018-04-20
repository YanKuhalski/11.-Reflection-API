package it.academy.basic.classes;

import it.academy.basic.interfaces.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    @Generate
    private String name;
    @Generate
    private int shelfLife;
    @Generate
    private boolean isValidToUse;
    @Generate
    private Date dayOfProduction;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void setName(String name) {
        this.name = name;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public void setValidToUse(Boolean validToUse) {
        isValidToUse = validToUse;
    }

    public void setDayOfProduction(Date dayOfProduction) {
        this.dayOfProduction = dayOfProduction;
    }

    public Product() {
    }

    public String toString() {
        return "Название : " + name
                + "\nДень производства : " + sdf.format(dayOfProduction)
                + "\nСрок хранения : " + shelfLife
                + " дней.\nПригоден для использования : " + isValidToUse;
    }
}
