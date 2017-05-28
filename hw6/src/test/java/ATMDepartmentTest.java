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
        ATM atm1 = new ATM(ExchangeRate.USD, new Cell(100), new Cell(50), new Cell(10), new Cell(20));
        atm1.increaseBalance(100, 3);
        atm1.increaseBalance(10, 1);
        atm1.increaseBalance(50, 2);
        atm1.increaseBalance(20, 5);
        department.addATM(atm1);
        Assert.assertEquals(4400 + 510 * ExchangeRate.USD.getMultiplier(), department.getMargin());

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
        ATM atm1 = new ATM(ExchangeRate.USD, new Cell(100), new Cell(50), new Cell(10), new Cell(20));
        atm1.increaseBalance(100, 3);
        atm1.increaseBalance(10, 1);
        atm1.increaseBalance(50, 2);
        atm1.increaseBalance(20, 5);
        department.addATM(atm1);
        department.restoreATMs();
        Assert.assertEquals(0, department.getMargin());

    }
}
