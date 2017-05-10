package testclasses;

import Annotations.Test;
import helper.ReflectionHelper;

public class ReflectionHelperTest
{
    @SuppressWarnings("ConstantConditions")
    @Test
    public void instantiate() {
        System.out.println(ReflectionHelper.assertEquals(1, ReflectionHelper.instantiate(FirstClass.class).getId()));
        System.out.println(ReflectionHelper.assertEquals("Maxim", ReflectionHelper.instantiate(FirstClass.class).getName()));
    }

    @Test
    public void getFieldValue() {
        System.out.println(ReflectionHelper.assertEquals("Maxim", ReflectionHelper.getFieldValue(new FirstClass(), "name")));
        System.out.println("Expected false");
        System.out.println(ReflectionHelper.assertEquals(0, ReflectionHelper.getFieldValue(new FirstClass(), "id")));
    }

    @Test
    public void getMethodsWithAnnotation()
    {
        System.out.println(ReflectionHelper.assertNotNull(ReflectionHelper.getMethodsWithAnnotation(FirstClass.class, Test.class)));
    }

}
