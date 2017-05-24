import atm.ATM;
import atm.RubATM;
import atm.UsdATM;
import department.ATMDepartment;
import org.junit.Assert;
import org.junit.Test;

public class ATMDepartmentTest
{
    @Test
    public void getMarginTest()
    {
        ATMDepartment department = new ATMDepartment();
        ATM atm1 = new RubATM();
        atm1.increaseBalance(1000, 10);
        atm1.increaseBalance(500, 10);
        atm1.increaseBalance(100, 10);
        ATM atm2 = new UsdATM();
        atm2.increaseBalance(100, 10);
        atm2.increaseBalance(50, 10);
        atm2.increaseBalance(20, 10);
        atm2.increaseBalance(5, 10);
        department.addATM(atm1);
        department.addATM(atm2);
        Assert.assertEquals(16000 + 1750 * 56, department.getMargin());
    }

    @Test
    public void restoreATMsTest()
    {
        ATMDepartment department = new ATMDepartment();
        ATM atm1 = new RubATM();
        atm1.increaseBalance(1000, 10);
        atm1.increaseBalance(500, 10);
        atm1.increaseBalance(100, 10);
        ATM atm2 = new UsdATM();
        atm2.increaseBalance(100, 10);
        atm2.increaseBalance(50, 10);
        atm2.increaseBalance(20, 10);
        atm2.increaseBalance(5, 10);
        department.addATM(atm1);
        department.addATM(atm2);
        department.restoreATMs();
        Assert.assertEquals(30000, atm1.getBalance());
        Assert.assertEquals(50000 * 56, atm2.getBalance());
    }
}
