// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TSPConfiguration.java

package org.saiko.ai.genetics.tsp;


public final class _3go3ei7
{

    public _3go3ei7()
    {
        D = false;
        E = 100;
        F = 5;
        G = 0.00075000000000000002D;
        H = 0.5D;
        I = 100;
        J = false;
        K = false;
    }

    public final boolean h()
    {
        return D;
    }

    public final void a(boolean antialiasing)
    {
        D = antialiasing;
    }

    public final int i()
    {
        return E;
    }

    public final void b(int initialPopulationSize)
    {
        E = initialPopulationSize;
    }

    public final int j()
    {
        return I;
    }

    public final void c(int maxBestCostAge)
    {
        I = maxBestCostAge;
    }

    public final double k()
    {
        return H;
    }

    public final void a(double mutationRatio)
    {
        H = mutationRatio;
    }

    public final double l()
    {
        return G;
    }

    public final void b(double populationGrow)
    {
        G = populationGrow;
    }

    public final boolean m()
    {
        return K;
    }

    public final void b(boolean rmsCost)
    {
        K = rmsCost;
    }

    public final int n()
    {
        return F;
    }

    public final void d(int threadPriority)
    {
        F = threadPriority;
    }

    protected boolean D;
    protected int E;
    protected int F;
    protected double G;
    protected double H;
    protected int I;
    protected boolean J;
    protected boolean K;
}
