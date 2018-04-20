package it.academy.basic.classes;

import it.academy.basic.interfaces.RandomFields;

public class FillIntField implements RandomFields<Integer> {
    @Override
    public Integer random() {
        return (int) (Math.random() * 1000);
    }
}
