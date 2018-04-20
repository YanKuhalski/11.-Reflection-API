package it.academy.basic.classes;

import it.academy.basic.interfaces.RandomFields;

import java.util.Random;

public class FillBooleanField implements RandomFields<Boolean> {

    @Override
    public Boolean random() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
