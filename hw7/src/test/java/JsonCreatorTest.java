import classes.TestClass;
import com.google.gson.Gson;
import org.junit.Test;

public class JsonCreatorTest
{
    @Test
    public void toJsonTest()
    {
        TestClass testClass = new TestClass();
        String finalString = new Gson().toJson(testClass);
        System.out.println(finalString);
    }
}
