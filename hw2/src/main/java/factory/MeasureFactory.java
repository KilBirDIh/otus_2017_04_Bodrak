package factory;

import java.lang.reflect.Array;

public class MeasureFactory
{
    private static final int size = 10_000_000;

    public static <T> void measure(T object) throws InterruptedException, IllegalAccessException, InstantiationException
    {
        Runtime runtime = Runtime.getRuntime();
        T[] array;
        System.gc();// чистим память от ненужных классов
        Thread.sleep(100);
        Class<?> classOfObject = object.getClass();
        long before = runtime.totalMemory() - runtime.freeMemory();//делаем замер занятой памяти
        array = (T[]) Array.newInstance(classOfObject, size);//создаем массив
        for (int i = 0; i < size; i++)
        {
            array[i] = (T) classOfObject.newInstance();
        }
        Thread.sleep(100);
        long after = runtime.totalMemory() - runtime.freeMemory();//смотрим сколько занял массив
        // без округления выходит 19 байт, с округлением 20: 16 на объект 4 на ссылку
        System.out.println(Math.round((double) (after - before) / size));//находим сколько занимает 1 элемент массива

    }
}
