package it.academy.basic.classes;

import it.academy.basic.exeptions.ObjExeption;
import it.academy.basic.interfaces.RandomFields;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FillObj<T> {
    private RandomFields randomBoolean = new FillBooleanField();
    private RandomFields randomDate = new FillDateField();
    private RandomFields randomInt = new FillIntField();
    private RandomFields randomString = new FillStringField();
    private T obj;
    private Class<T> clazz;

    public FillObj(T obj, Class<T> clazz) {
        this.obj = obj;
        this.clazz = clazz;
    }

    public void fillObj() throws ObjExeption {
            try {
                Field[]fields=clazz.getDeclaredFields();
                for(Field field:fields){
                fillField(field);}
            } catch (InvocationTargetException | IllegalAccessException e) {
             throw new ObjExeption( e.toString());
            }
    }

    private void fillField(Field field) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                for (Class fieldType : method.getParameterTypes()) {
                    tryToSetString(fieldType, field, method);
                    tryToSetInt(fieldType, field, method);
                    tryToSetBool(fieldType, field, method);
                    tryToSetDate(fieldType, field, method);
                }
            }
        }
    }

    private void tryToSetString(Class fieldType, Field field, Method method) throws InvocationTargetException, IllegalAccessException {
        if (fieldType.getSimpleName().equals("String") && (String.valueOf(field.getType())).equals("class java.lang.String") &&
                stringContains(method.getName(), field.getName()))
            method.invoke(obj, randomString.random());
    }

    private boolean stringContains(String method, String field) {
        return method.toLowerCase().endsWith(field.toLowerCase()) ? true : false;
    }

    private void tryToSetBool(Class fieldType, Field field, Method method) throws InvocationTargetException, IllegalAccessException {
        if (fieldType.getSimpleName().equals("boolean") && (String.valueOf(field.getType())).equals("boolean")) {
            method.invoke(obj, randomBoolean.random());
        }
    }

    private void tryToSetInt(Class fieldType, Field field, Method method) throws InvocationTargetException, IllegalAccessException {
        if (fieldType.getSimpleName().equals("int") && (String.valueOf(field.getType())).equals("int")) {
            method.invoke(obj, randomInt.random());
        }
    }

    private void tryToSetDate(Class fieldType, Field field, Method method) throws InvocationTargetException, IllegalAccessException {
        if (fieldType.getSimpleName().equals("Date") && (String.valueOf(field.getType())).equals("class java.util.Date")) {
            method.invoke(obj, randomDate.random());
        }
    }
}
