package area.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRunner {
    public static void main(String[] args) {


        SimpleRunner simpleRunner = new SimpleRunner();

        simpleRunner.runTests();
    }

    private void runTests() {


        try {
            // в Cl - описание это класса , все поля конструкторы и методы и т.д. этого класса
            Class<?> cl = Class.forName("area.dao.OrderFormImplTest");
            Constructor<?> constructor = cl.getConstructor(); // дай мне конструктор без параметров
            Object entity = constructor.newInstance();

            // cl.getDeclaredMethods() // получить приватные методы
            Method[] methods = cl.getMethods();// получить все методы

            for (Method method:methods){
                Test ann = method.getAnnotation(Test.class); // есть ли у тебя метод аннтотация

                if (ann!=null)
                method.invoke(entity);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
