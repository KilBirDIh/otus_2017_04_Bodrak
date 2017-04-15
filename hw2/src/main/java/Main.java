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
    public static void main(String[] args) throws InterruptedException
    {
        MemoryMeter memoryMeter = new MemoryMeter();
        List<String> firstList = new LinkedList<>();
        List<String> secondList = new ArrayList<>();
        Map<String, Integer> firstMap = new TreeMap<>();
        Map<String, String> secondMap = new ConcurrentSkipListMap<>();
        int size = 10001;
        //Как изменяется значение при добавлении одинаковых данных
        //Судя по изменениям размеров контейнеров новые стринги не создаются
        for (int i = 0; i < size; i++)
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
        System.out.println(memoryMeter.measureDeep(""));
    }

}
