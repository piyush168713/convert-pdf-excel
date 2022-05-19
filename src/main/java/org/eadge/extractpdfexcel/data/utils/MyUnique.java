package org.eadge.extractpdfexcel.data.utils;

public class MyUnique<T>
{
    private T t;

    public MyUnique()
    {
        this.t = null;
    }

    public MyUnique(T t)
    {
        this.t = t;
    }

    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }
}
