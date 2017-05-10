import helper.ReflectionHelper;
import org.junit.Assert;
import org.junit.Test;
import testclasses.FirstClassTest;

public class ReflectionHelperTest
{
    //Честно говоря не знаю на что еще тут стоило бы писать тесты
    @Test
    public void getMethodsWithAnnotation()
    {
        Assert.assertTrue(3 == ReflectionHelper.getMethodsWithAnnotation(FirstClassTest.class, Annotations.Test.class).size());
        Assert.assertTrue(3 == ReflectionHelper.getMethodsWithAnnotation(testclasses.ReflectionHelperTest.class, Annotations.Test.class).size());
    }
}
