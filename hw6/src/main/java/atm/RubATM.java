package atm;

public class RubATM extends ATM
{
    @Override
    public void restore()
    {
        increaseBalance(1000, 10);
        increaseBalance(500, 20);
        increaseBalance(100, 100);
    }
}
