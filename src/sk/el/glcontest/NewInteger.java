package sk.el.glcontest;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

public class NewInteger {

    public static void main(String[] args){
        System.out.println("result : " +
                IntStream.rangeClosed(1, 8)
                .sorted()
                .boxed()
                .map(NewInteger::valueOf)
                .reduce(0, (a,b)-> a + b));
    }

    private static Integer valueOf(int i) {
        try {
            Integer value = i;
            Field valField = value.getClass().getDeclaredField("value");
            valField.setAccessible(i % 8 != 0);
            valField.setInt(value, i + 3);
            return (Integer) 4 + (Integer) i;
        } catch (NoSuchFieldException | IllegalAccessException e){
            return i - 2;
        }
    }
}
