package it.academy.basic.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflector<T> {
    public T make(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<T> clazzConstructor = clazz.getConstructor();
        return clazzConstructor.newInstance();
    }
}
