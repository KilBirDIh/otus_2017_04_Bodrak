package classes;

import java.util.LinkedList;
import java.util.List;

public class TestClass
{
    private String name;
    private List<Character> list;
    private int[] array;

    public TestClass()
    {
        this.name = "Test class";
        this.list = new LinkedList<>();
        this.array = new int[]{1, 2, 3, 4, 5};
        list.add('H');
        list.add('e');
        list.add('l');
        list.add('l');
        list.add('o');
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Character> getList()
    {
        return list;
    }

    public void setList(List<Character> list)
    {
        this.list = list;
    }

    public int[] getArray()
    {
        return array;
    }

    public void setArray(int[] array)
    {
        this.array = array;
    }
}
