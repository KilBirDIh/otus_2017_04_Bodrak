package jsontypes;

import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNumber implements javax.json.JsonNumber
{
    private Number number;

    public JsonNumber(Number number)
    {
        this.number = number;
    }

    @Override
    public boolean isIntegral()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int intValue()
    {
        return number.intValue();
    }

    @Override
    public int intValueExact()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public long longValue()
    {
        return number.longValue();
    }

    @Override
    public long longValueExact()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigInteger bigIntegerValue()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigInteger bigIntegerValueExact()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public double doubleValue()
    {
        return number.doubleValue();
    }

    @Override
    public BigDecimal bigDecimalValue()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ValueType getValueType()
    {
        return ValueType.NUMBER;
    }
}
