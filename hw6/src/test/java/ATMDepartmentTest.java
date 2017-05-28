import atm.ATM;
import atm.Cell;
import atm.ExchangeRate;
import department.ATMDepartment;
import org.junit.Assert;
import org.junit.Test;

public class ATMDepartmentTest
{
    @Test
    public void getMarginTest()
    {
        ATMDepartment department = new ATMDepartment();
        ATM atm = new ATM(ExchangeRate.RUB, new Cell(1000), new Cell(500), new Cell(100));
        atm.increaseBalance(1000, 1);
        atm.increaseBalance(100, 4);
        atm.increaseBalance(500, 6);
        department.addATM(atm);
        ATM atm1 = new ATM(ExchangeRate.RUB, new Cell(1000), new Cell(500), new Cell(100));
        atm1.increaseBalance(1000, 3);
        atm1.increaseBalance(100, 1);
        atm1.increaseBalance(500, 2);
        department.addATM(atm1);
        Assert.assertEquals(8500, department.getMargin());

    }

    @Test
    public void restoreATMsTest()
    {
        ATMDepartment department = new ATMDepartment();
        ATM atm = new ATM(ExchangeRate.RUB, new Cell(1000), new Cell(500), new Cell(100));
        atm.increaseBalance(1000, 1);
        atm.increaseBalance(100, 4);
        atm.increaseBalance(500, 6);
        department.addATM(atm);
        ATM atm1 = new ATM(ExchangeRate.RUB, new Cell(1000), new Cell(500), new Cell(100));
        atm1.increaseBalance(1000, 3);
        atm1.increaseBalance(100, 1);
        atm1.increaseBalance(500, 2);
        department.addATM(atm1);
        department.restoreATMs();
        Assert.assertEquals(0, department.getMargin());

    }
}
