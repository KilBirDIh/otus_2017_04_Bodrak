import atm.ATM;
import atm.RubATM;
import org.junit.Assert;
import org.junit.Test;

public class ATMTest
{
    @Test
    public void increaseBalanceTest()
    {
        ATM atm = new RubATM();
        atm.increaseBalance(1000, 1);
        atm.increaseBalance(100, 4);
        atm.increaseBalance(500, 6);
        Assert.assertTrue(atm.getBalance() > 0);
    }

    @Test
    public void getBalanceTest()
    {
        ATM atm = new RubATM();
        atm.increaseBalance(1000, 1);
        atm.increaseBalance(100, 4);
        atm.increaseBalance(500, 6);
        Assert.assertEquals(4400, atm.getBalance());
    }

    @Test(expected = RuntimeException.class)
    public void getMoneyTest()
    {
        ATM atm = new RubATM();
        atm.increaseBalance(1000, 1);
        atm.increaseBalance(100, 4);
        atm.increaseBalance(500, 6);
        Assert.assertTrue(atm.getMoney(1900));
        System.out.println(atm.getBalance());
        Assert.assertTrue(atm.getMoney(500));
        System.out.println(atm.getBalance());
        Assert.assertTrue(atm.getMoney(2000));
        System.out.println(atm.getBalance());
        //exception here
        Assert.assertTrue(atm.getMoney(100));
        System.out.println(atm.getBalance());

    }
}
