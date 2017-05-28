package atm;

public enum ExchangeRate
{
    RUB(1),
    USD(56);

    private int multiplier;

    public int getMultiplier()
    {
        return multiplier;
    }

    ExchangeRate(int multiplier)
    {
        this.multiplier = multiplier;
    }
}
