package classes;

public class CustomClass
{
    private String stringValue;

    private Integer integerValue;

    public CustomClass()
    {
        stringValue = "string";
        integerValue = 3;
    }

    public String getStringValue()
    {
        return stringValue;
    }

    public void setStringValue(String stringValue)
    {
        this.stringValue = stringValue;
    }

    public double getIntegerValue()
    {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue)
    {
        this.integerValue = integerValue;
    }
}
