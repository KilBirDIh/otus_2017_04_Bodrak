package testclasses;

import java.time.LocalDate;

public class FirstClass
{
    private int id;
    private String name;
    private LocalDate date;

    FirstClass()
    {
        id = 1;
        name = "Maxim";
        date = LocalDate.now();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirstClass that = (FirstClass) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    int getId()
    {
        return id;
    }

    String getName()
    {
        return name;
    }

    LocalDate getDate()
    {
        return date;
    }
}
