package testclasses;

import Annotations.After;
import Annotations.Before;
import Annotations.Test;
import helper.Assert;

import java.time.LocalDate;

public class FirstClassTest
{
    @Before
    public void init()
    {
        System.out.println("Before test method");
    }

    @Test
    public void getIdTest()
    {
        System.out.println(Assert.assertEquals(1, new FirstClass().getId()));
    }

    @Test
    public void getNameTest()
    {
        System.out.println(Assert.assertEquals("Maxim", new FirstClass().getName()));
    }

    @Test
    public void getDateTest()
    {
        System.out.println(Assert.assertEquals(LocalDate.now(), new FirstClass().getDate()));
    }

    @After
    public void close()
    {
        System.out.println("After test method");
    }
}
