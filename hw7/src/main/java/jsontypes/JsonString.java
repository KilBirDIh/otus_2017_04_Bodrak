package jsontypes;

public class JsonString implements javax.json.JsonString
{
    private String jsonString;

    public JsonString(String string)
    {
        jsonString = string;
    }

    @Override
    public String getString()
    {
        return jsonString;
    }

    @Override
    public CharSequence getChars()
    {
        return jsonString.subSequence(0, jsonString.length()-1);
    }

    @Override
    public ValueType getValueType()
    {
        return ValueType.STRING;
    }
}
