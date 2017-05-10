import Annotations.After;
import Annotations.Before;
import Annotations.Test;
import helper.ReflectionHelper;
import testclasses.FirstClassTest;
import testclasses.ReflectionHelperTest;

import java.lang.reflect.Method;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Class<?>[] classes = new Class[]{FirstClassTest.class, ReflectionHelperTest.class};
        for (Class c : classes)
        {
            List<Method> beforeList = ReflectionHelper.getMethodsWithAnnotation(c, Before.class);
            List<Method> afterList = ReflectionHelper.getMethodsWithAnnotation(c, After.class);
            List<Method> testList = ReflectionHelper.getMethodsWithAnnotation(c, Test.class);

            for (Method method : testList)
            {
                Object instance = ReflectionHelper.instantiate(c);
                if (!beforeList.isEmpty())
                {
                    ReflectionHelper.callMethod(instance, beforeList.get(0).getName());
                }
                ReflectionHelper.callMethod(instance, method.getName());
                if(!afterList.isEmpty())
                {
                    ReflectionHelper.callMethod(instance, afterList.get(0).getName());
                }

            }
        }
    }
}
