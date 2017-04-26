package benchmark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Benchmark {

    public void run() throws InterruptedException
    {
        List<String> array = new ArrayList<>();

        int n = 1;
        System.out.println("Starting the loop");
        while (n < Integer.MAX_VALUE) {
            array.add(new String(new char[0]));
            n++;
            if (n % 1000 == 0) {
                Iterator<String> iterator = array.listIterator(n/2);
                while (iterator.hasNext())
                {
                    iterator.next();
                    iterator.remove();
                }
                Thread.sleep(25);
            }
        }
    }
}