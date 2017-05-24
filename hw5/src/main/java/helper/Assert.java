package helper;

public class Assert
{
    public static boolean assertEquals(Object expected, Object actual)
    {
        return expected.equals(actual);
    }

    public static boolean fail()
    {
        throw new AssertException();
    }

    public static boolean assertNotNull(Object actual)
    {
        return actual != null;
    }
}
