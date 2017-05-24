package atm;

public class Cell implements Comparable<Cell>
{
    private int count;
    private int nominal;

    Cell()
    {
        count = 0;
        nominal = 0;
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

    void setNominal(int nominal)
    {
        this.nominal = nominal;
    }

    @Override
    public int compareTo(Cell o)
    {
        if(nominal > o.getNominal()) return -1;
        else if(nominal < o.getNominal()) return 1;
        else return 0;
    }
}
