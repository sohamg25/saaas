// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TSPChromosome.java

package org.saiko.ai.genetics.tsp;


// Referenced classes of package org.saiko.ai.genetics.tsp:
//            _1nogfu0

public final class _8eu935
{

    public _8eu935(_1nogfu0 cities[], boolean computeCosts)
    {
        k = (_1nogfu0[])cities.clone();
        if(computeCosts)
            d();
    }

    public _8eu935(_1nogfu0 cities[])
    {
        this(cities, true);
    }

    public final void d()
    {
        B = 0.0D;
        C = 0.0D;
        double currentDistance;
        double currentCost;
        for(int i = 0; i < k.length - 1; i++)
        {
            currentDistance = k[i].a(k[i + 1]);
            currentCost = k[i].b(k[i + 1]);
            B += currentDistance;
            C += currentCost;
        }

        currentDistance = k[k.length - 1].a(k[0]);
        currentCost = k[k.length - 1].b(k[0]);
        B += currentDistance;
        C += currentCost;
    }

    public final double e()
    {
        return B;
    }

    public final double f()
    {
        return C;
    }

    public final _1nogfu0[] g()
    {
        return k;
    }

    protected _1nogfu0 k[];
    protected double B;
    private double C;
}
