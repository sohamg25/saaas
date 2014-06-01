// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   City.java

package org.saiko.ai.genetics.tsp;


// Referenced classes of package org.saiko.ai.genetics.tsp:
//            _3go3ei7

public final class _1nogfu0
{

    public _1nogfu0(int id, _3go3ei7 configuration, String name, int x, int y)
    {
        c = false;
        this.id = id;
        this.x = x;
        this.y = y;
        a = x;
        b = y;
        this.name = name;
        e = configuration;
    }

    public static synchronized void a(int length)
    {
        d = new double[length][length];
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < length; j++)
                d[i][j] = -1D;

        }

    }

    public final double a(_1nogfu0 otherCity, int id1)
    {
        _1nogfu0 _l1nogfu0;
        if(id1 == 0)
            return a((_l1nogfu0 = otherCity).x, (_l1nogfu0 = otherCity).y);
        id1 = id;
        int id2 = otherCity.id;
        if(id1 == id2)
            return 0.0D;
        double distance;
        if(id1 > id2)
            id1 = distance = id1;
        if((distance = d[id1][id2]) == -1D)
        {
            _1nogfu0 _l1nogfu0_1;
            distance = a((_l1nogfu0_1 = otherCity).x, (_l1nogfu0_1 = otherCity).y);
            d[id1][id2] = distance;
        }
        return distance;
    }

    public final double a(_1nogfu0 otherCity)
    {
        return a(otherCity, true);
    }

    public final double b(_1nogfu0 otherCity)
    {
        _1nogfu0 _l1nogfu0 = otherCity;
        otherCity = this;
        double distance = a(_l1nogfu0, true);
        if(e.m())
            return distance * distance;
        else
            return distance;
    }

    private double a(int pX, int pY)
    {
        double dx = x - pX;
        double dy = y - pY;
        double d1;
        return d1 = Math.sqrt(dx * dx + dy * dy);
    }

    public final String getName()
    {
        return name;
    }

    public final int getX()
    {
        return x;
    }

    public final int getY()
    {
        return y;
    }

    public final int a()
    {
        return a;
    }

    public final int b()
    {
        return b;
    }

    public final String toString()
    {
        return (new StringBuilder(String.valueOf(name))).append(": [").append(x).append(";").append(y).append("]").toString();
    }

    public final boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(!(obj instanceof _1nogfu0))
            return false;
        return ((_1nogfu0)obj).id == id;
    }

    public final int getId()
    {
        return id;
    }

    protected int x;
    protected int y;
    protected final int a;
    protected final int b;
    protected String name;
    private int id;
    protected boolean c;
    private static double d[][] = null;
    protected _3go3ei7 e;

}
