package it.academy.basic.classes;

import it.academy.basic.interfaces.RandomFields;

public class FillStringField implements RandomFields<String> {
    @Override
    public String random() {
        String symbols = "йцукенгшщзхъфывапролджэячсмитьбюё";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 30) + 1;
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString.toString();
    }
}
