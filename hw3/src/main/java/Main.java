import list.MyArrayList;

import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> listSrc = new MyArrayList<>();
        List<Integer> listDst = new MyArrayList<>();
        for(int i = 0; i < 11; i++)
        {
            listDst.add(i);
            listSrc.add(11 - i);
            System.out.print(listDst.get(i) + " ");
        }
        System.out.println();
        Collections.copy(listDst, listSrc);
        System.out.println(listDst.toString());
        Collections.sort(listDst);
        System.out.println(listDst.toString());
        System.out.println(listDst.addAll(listSrc));
    }
}
