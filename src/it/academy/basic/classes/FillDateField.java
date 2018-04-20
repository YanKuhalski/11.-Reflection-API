package it.academy.basic.classes;

import it.academy.basic.interfaces.RandomFields;

import java.util.Date;

public class FillDateField implements RandomFields<Date> {
    @Override
    public Date random() {
        Date date = new Date();
        Long tobay = date.getTime();
        return new Date((long) (tobay - (Math.random() * 100000000 * 10000)));
    }
}
