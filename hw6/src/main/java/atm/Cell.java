package atm;

public class Cell implements Comparable<Cell>
{
    private int count;
    private final int nominal;

    public Cell(int nominal)
    {
        count = 0;
        this.nominal = nominal;
    }

    int getCount()
    {
        return count;
    }

    void setCount(int count)
    {
        this.count = count;
    }

    int getNominal()
    {
        return nominal;
    }


    @Override
    public int compareTo(Cell o)
    {
        if(nominal > o.getNominal()) return -1;
        else if(nominal < o.getNominal()) return 1;
        else return 0;
    }
}
