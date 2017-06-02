import classes.TestClass;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import java.util.Collection;

/**
 * Реализовал преобразование для инта и массива интов, остальные примитивы добавятся подобным образом
 * По-моему получилось некрасиво, по другому не придумал((
 */


@SuppressWarnings("unchecked")
class JsonCreator
{

    static String toJson() throws IllegalAccessException, ClassNotFoundException
    {
        return navigateObject(new TestClass());
    }


    private static <T> String navigateObject(T object) throws IllegalAccessException, ClassNotFoundException
    {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        JsonObjectBuilder objectBuilder = Json.createBuilderFactory(null).createObjectBuilder();
        for (Field field : fields)
        {
            field.setAccessible(true);
            Class<?>[] interfaces = field.getType().getInterfaces();
            for (Class<?> interface1 : interfaces)
            {
                if ("java.util.Collection".equals(interface1.getCanonicalName()))
                {
                    JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
                    ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
                    Class<?> typeOfCollection = (Class<?>) stringListType.getActualTypeArguments()[0];
                    if( typeOfCollection == String.class || typeOfCollection == Character.class || typeOfCollection == Integer.class)
                    {
                        for (T element : (Collection<T>) field.get(object))
                        {
                            arrayBuilder.add(element.toString().replaceAll("\"", ""));
                        }
                    }
                    else
                    {
                        for (T element : (Collection<T>) field.get(object))
                        {
                            arrayBuilder.add(navigateObject(element));
                        }
                    }

                    JsonArray array = arrayBuilder.build();
                    objectBuilder.add(field.getName(), array);
                    break;
                }

            }
            if(field.getType().getCanonicalName().contains("[]"))
            {
                JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
                if(field.getType() == int[].class)
                {
                    for(Integer element: (int[]) field.get(object))
                    {
                        arrayBuilder.add(element);
                    }
                }
                else
                {
                    for(T element: (T[]) field.get(object))
                    {
                        arrayBuilder.add(element.toString().replaceAll("\"", ""));
                    }
                }
                JsonArray array = arrayBuilder.build();
                objectBuilder.add(field.getName(), array);
                continue;
            }
            if(field.getType() == String.class)
            {
                objectBuilder.add(field.getName(), (String) field.get(object));
                continue;
            }
            if(field.getType() == int.class|| field.getType() == Integer.class)
            {
                objectBuilder.add(field.getName(), (int) field.get(object));
                continue;
            }

            field.setAccessible(false);
        }
        return objectBuilder.build().toString().replaceAll("\\\\", "").replaceAll("\"\\{", "\\{").replaceAll("}\"", "}");
    }

}
