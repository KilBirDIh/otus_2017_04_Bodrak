package atm;

public class UsdATM extends ATM
{

    @Override
    public void restore()
    {
        increaseBalance(100, 100);
        increaseBalance(50, 200);
        increaseBalance(20, 500);
        increaseBalance(10, 1000);
        increaseBalance(5, 2000);
    }

    @Override
    public int getBalance()
    {
        int currency = 56;
        return super.getBalance() * currency;
    }
}
