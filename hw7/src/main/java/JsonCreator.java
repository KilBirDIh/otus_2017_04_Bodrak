import java.lang.reflect.Field;

public class JsonCreator
{
    public static void toJson()
    {

    }

    private <T> String navigateObject(T object) throws IllegalAccessException
    {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
        {
            field.getName();
            field.get(object);
        }
        return null;
    }
}
