package atm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Объект класса АТМ должен уметь
 * принимать банкноты разных номиналов (на каждый номинал должна быть своя ячейка)
 * выдавать запрошенную сумму минимальным количеством банкнот или ошибку если сумму нельзя выдать
 * выдавать сумму остатка денежных средств
 */
public abstract class ATM implements Restorable
{
    private List<Cell> cells;

    ATM()
    {
        cells = new ArrayList<>();
    }

    public void increaseBalance(int nominal, int count)
    {

        for (Cell cell : cells)
        {
            if (cell.getNominal() == nominal)
            {
                cell.setCount(count);
                return;
            }
        }
        Cell cell = new Cell();
        cell.setCount(count);
        cell.setNominal(nominal);
        cells.add(cell);
    }

    public int getBalance()
    {
        int balance = 0;
        for (Cell cell : cells)
        {
            balance += cell.getNominal() * cell.getCount();
        }
        return balance;
    }

    public boolean getMoney(int amount)
    {
        int money ;
        Collections.sort(cells);
        for (Cell cell : cells)
        {
            int numberOfBills = amount / cell.getNominal();
            if (numberOfBills > 0)
            {
                if (numberOfBills < cell.getCount())
                {
                    money = numberOfBills * cell.getNominal();
                    cell.setCount(cell.getCount() - numberOfBills);
                    amount = amount - money;
                } else
                {
                    money = cell.getCount() * cell.getNominal();
                    cell.setCount(0);
                    amount = amount - money;
                }

            }
        }
        if (amount != 0) throw new RuntimeException("Not enough bills for getting money");
        return true;
    }
}
