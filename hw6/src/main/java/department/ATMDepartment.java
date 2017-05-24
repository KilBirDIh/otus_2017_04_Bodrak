package department;

import atm.ATM;

import java.util.ArrayList;
import java.util.List;

/**
 * contains several ATM
 * can get current balance on every ATM
 * can restore to default state every ATM
 */
public class ATMDepartment
{
    private List<ATM> atmList;

    public ATMDepartment()
    {
        atmList = new ArrayList<>();
    }

    public int getMargin()
    {
        int margin = 0;
        for (ATM atm : atmList)
        {
            margin += atm.getBalance();
        }
        return margin;
    }

    public void addATM(ATM atm)
    {
        atmList.add(atm);
    }

    public void removeATM(ATM atm)
    {
        atmList.remove(atm);
    }

    public void restoreATMs()
    {
        atmList.forEach(ATM::restore);
    }
}
