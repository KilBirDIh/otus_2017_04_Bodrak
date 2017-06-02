import classes.TestClass;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class JsonCreatorTest
{
    @Test
    public void toJsonTest() throws IllegalAccessException, ClassNotFoundException
    {
        TestClass testClass = new TestClass();
        String finalString = new Gson().toJson(testClass);
        String xJson = JsonCreator.toJson();
        Assert.assertEquals(finalString, xJson);

    }
}
