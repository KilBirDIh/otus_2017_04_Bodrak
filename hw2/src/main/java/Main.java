import factory.EmptyClass;
import factory.MeasureFactory;
import org.github.jamm.MemoryMeter;

import java.lang.management.ManagementFactory;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main
{
    /*
    *  Написать стенд для определения размера объекта.
    *  Определить размер пустой строки и пустых контейнеров.
    *  Определить рост размера контейнера от количества элементов в нем.
    *  Собираем проект, запускаем скрипт*/
    public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException
    {
        //Выводит размер объекта + размер ссылки
        //16
        MeasureFactory.measure(new Object());
        System.gc();
        //24
        MeasureFactory.measure(new String(new char[0]));
        System.gc();
        //16
        MeasureFactory.measure(new EmptyClass());
        System.gc();
        //24
        MeasureFactory.measure("");
        System.gc();
        //48
        MeasureFactory.measure(new TreeMap());
        //Как изменяется значение при добавлении одинаковых данных
        //Судя по изменениям размеров контейнеров новые стринги не создаются
        /*for (int i = 0; i < size; i++)
        {
            if(i % 1000 == 0)
                System.out.println(i + " " + (memoryMeter.measureDeep(firstList) - memoryMeter.measure("ad") * i));
            firstList.add(new String("ad"));
        }
        System.out.println(memoryMeter.measureDeep(firstList));
        for (int i = 0; i < size; i++)
        {
            if(i % 1000 == 0)
                System.out.println(i + " " + (memoryMeter.measureDeep(secondList) - memoryMeter.measure("bc") * i));
            secondList.add(new String("bc"));
        }
        for (int i = 0; i < size; i++)
        {
            if(i % 1000 == 0)
                System.out.println(i + " " + (memoryMeter.measureDeep(firstMap)));

            firstMap.put(UUID.randomUUID().toString(), i);
        }
        for (int i = 0; i < size; i++)
        {
            if(i % 1000 == 0)
                System.out.println(i + " " + (memoryMeter.measureDeep(secondMap)));

            secondMap.put(UUID.randomUUID().toString(), String.valueOf(i));
        }
        System.out.println(memoryMeter.measureDeep(secondList));
        System.out.println(memoryMeter.measureDeep(firstMap));
        System.out.println(memoryMeter.measureDeep(secondMap));
        System.out.println(memoryMeter.measureDeep(""))*/;
    }


}
