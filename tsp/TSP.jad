// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TSP.java

package org.saiko.ai.genetics.tsp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import org.saiko.ai.genetics.tsp._2m824ko._19g5qqs._1alb7hs;
import org.saiko.ai.genetics.tsp._2m824ko._2n2kgqh._1ttuld6;
import org.saiko.ai.genetics.tsp._2m824ko._t2179s._2ua2pht;
import org.saiko.ai.genetics.tsp._2m824ko._tb82gs._1ikrcq7;
import org.saiko.ai.genetics.tsp._2m824ko._vmqrkq._3iohfho;

// Referenced classes of package org.saiko.ai.genetics.tsp:
//            _1nogfu0, _1vbs734, _30ibutj, _3fvg51p, 
//            _3go3ei7, _8eu935

public class TSP
{

    protected final void a(_1nogfu0 citiesToLoad[], boolean initDiscanceCache)
    {
        k = citiesToLoad;
        if(k == null)
        {
            citiesToLoad = new ArrayList();
            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new InputStreamReader(org/saiko/ai/genetics/tsp/TSP.getClassLoader().getResourceAsStream((new StringBuilder("org/saiko/ai/genetics/tsp/etc/")).append(j).append(".csv").toString()), "UTF-8"));
            }
            catch(NullPointerException _ex)
            {
                reader = new BufferedReader(new InputStreamReader((new Object()).getClass().getResourceAsStream(j), "UTF-8"));
            }
            Pattern patternLine = Pattern.compile("\"(.*?)\",(.*?),(.*)");
            int count = 0;
            int id = 0;
            Matcher regex;
            while((regex = reader.readLine()) != null) 
                if(++count != 1 && (regex = patternLine.matcher(regex)).find())
                {
                    String name = regex.group(1).trim();
                    Integer x = new Integer(regex.group(2));
                    regex = new Integer(regex.group(3));
                    regex = new _1nogfu0(id, e, name, x.intValue(), regex.intValue());
                    id++;
                    citiesToLoad.add(regex);
                }
            reader.close();
            k = (_1nogfu0[])citiesToLoad.toArray(new _1nogfu0[0]);
        }
        k[0].c = true;
        citiesToLoad = 0;
        _1nogfu0 a_l1nogfu0[] = k;
        int i1 = 0;
        for(int j1 = a_l1nogfu0.length; i1 < j1; i1++)
        {
            _1nogfu0 city;
            if((city = a_l1nogfu0[i1]).x > citiesToLoad)
                citiesToLoad = city.x;
        }

        a_l1nogfu0 = k;
        i1 = 0;
        for(int k1 = a_l1nogfu0.length; i1 < k1; i1++)
        {
            _1nogfu0 city;
            (city = a_l1nogfu0[i1]).x = Math.abs(citiesToLoad - city.x);
        }

        if(initDiscanceCache)
        {
            _1nogfu0.a(k.length);
            return;
        }
        break MISSING_BLOCK_LABEL_385;
        JVM INSTR dup ;
        citiesToLoad;
        printStackTrace();
        System.exit(-1);
    }

    public TSP()
    {
        this(true);
    }

    public TSP(boolean loadCities)
    {
        e = new _3go3ei7();
        j = i[2];
        k = null;
        l = false;
        m = false;
        n = false;
        p = 0L;
        q = 0L;
        r = h[3];
        v = 0;
        w = 0.0D;
        if(loadCities)
            a(null, true);
    }

    public final void start()
    {
        if(!e.J)
        {
            z = new _30ibutj(this);
            z.init();
            return;
        } else
        {
            run();
            return;
        }
    }

    protected final void run()
    {
        v = 0;
        p = System.currentTimeMillis();
        s = (_1vbs734)r.newInstance();
        s.a(e, k);
        t = s.getClass().getSimpleName();
        u = 0;
        double previewCost = 0.0D;
        double previewDrawCost = 0.0D;
        long previewDrawTime = 0L;
        w = 0.0D;
        Thread statusThread;
        (statusThread = new _cls1()).start();
        while(!m) 
        {
            if(v % 3 == 0 && !e.J && l)
            {
                z.U.setText((new StringBuilder("Pause; ")).append(z.U.getText()).toString());
                while(l) 
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(InterruptedException _ex) { }
            }
            o = s.p();
            w = o.e();
            if(previewCost == w)
                u++;
            else
                u = 0;
            if(u >= e.I)
                m = true;
            previewCost = w;
            long currentTime = System.currentTimeMillis();
            if(previewDrawTime < currentTime - 1000L || l)
            {
                previewDrawTime = currentTime;
                if(previewDrawCost != w && !e.J)
                {
                    z.R.repaint();
                    previewDrawCost = w;
                }
            }
            s.q();
            v++;
        }
        q = System.currentTimeMillis() - p;
        statusThread.interrupt();
        try
        {
            Thread.sleep(500L);
        }
        catch(Throwable _ex) { }
        a(s);
        if(!e.J)
            z.U.setText((new StringBuilder("Finished; ")).append(z.U.getText()).toString());
        m = false;
        n = false;
        l = false;
        if(!e.J)
        {
            z.M.s();
            z.M.ad.setEnabled(true);
            z.M.ae.setEnabled(true);
            z.M.af.setEnabled(true);
            z.repaint();
            return;
        }
        break MISSING_BLOCK_LABEL_509;
        JVM INSTR dup ;
        Throwable throwable;
        throwable;
        printStackTrace();
        System.exit(-1);
    }

    final void a(_1vbs734 engine)
    {
        engine = String.format("%s: cities: %s; time: %s; generation: %s; population: %s; best distance: %s; best age: %s;", new Object[] {
            t, Integer.valueOf(k.length), Long.valueOf(q / 1000L), Integer.valueOf(v), Integer.valueOf(engine.o()), Integer.valueOf((int)w), Integer.valueOf(u)
        });
        if(e.J)
        {
            System.out.println(engine);
            return;
        } else
        {
            z.U.setText(engine);
            return;
        }
    }

    public static String c()
    {
        String projectClasses[] = {
            "$Revision: 1.3 $", "$Revision: 1.2 $", "$Revision: 1.4 $", "$Revision: 1.11 $", "$Revision: 1.3 $", "$Revision: 1.2 $", "$Revision: 1.3 $", "$Revision: 1.2 $", "$Revision: 1.9 $", "$Revision: 1.3 $", 
            "$Revision: 1.4 $", "$Revision: 1.2 $", "$Revision: 1.2 $", "$Revision: 1.2 $", "$Revision: 1.3 $", "$Revision: 1.2 $", "$Revision: 1.2 $", "$Revision: 1.2 $", "$Revision: 1.2 $"
        };
        double major = 0.0D;
        double minor = 0.0D;
        Pattern revision = Pattern.compile("(\\d+)\\.*(\\d+)");
        String as[] = projectClasses;
        int i1 = 0;
        for(int j1 = as.length; i1 < j1; i1++)
        {
            String v = as[i1];
            Matcher matcher;
            (matcher = revision.matcher(v)).find();
            major += Double.parseDouble(matcher.group(1));
            minor += Double.parseDouble(matcher.group(2));
        }

        major /= projectClasses.length;
        minor /= projectClasses.length;
        return (new StringBuilder(String.valueOf((int)major))).append(".").append((int)(minor * 100D)).toString();
    }

    public static void main(String args[])
        throws Exception
    {
        if(args != null && args.length > 0)
        {
            boolean error = false;
            String errorMessage = "";
            int paramPriority = 5;
            String paramMap = "/org/saiko/ai/genetics/tsp/etc/cities_050.csv";
            Class paramEngine = h[3];
            boolean paramRms = false;
            int paramPopulation = 1000;
            int paramMax = 100;
            double paramMutation = 0.5D;
            double paramGrowth = 0.0074999999999999997D;
            String paramXMLFileName = (new StringBuilder("tsp_report_")).append((new SimpleDateFormat("yyyy_MM_dd_HH_mm")).format(Calendar.getInstance().getTime())).append(".xml").toString();
            try
            {
                for(int i = 0; i < args.length; i++)
                {
                    String param;
                    for(param = args[i].toLowerCase(); param.startsWith("-"); param = param.substring(1));
                    if(param.startsWith("priority="))
                    {
                        paramPriority = Integer.parseInt(param = param.substring(param.lastIndexOf('=') + 1));
                        continue;
                    }
                    if(param.equals("console"))
                        continue;
                    if(param.startsWith("map="))
                    {
                        param = param.substring(param.lastIndexOf('=') + 1);
                        String args1[];
                        param = args1 = (new String[] {
                            param, (new StringBuilder("/org/saiko/ai/genetics/tsp/etc/")).append(param).toString(), (new StringBuilder("/org/saiko/ai/genetics/tsp/etc/")).append(param).append(".csv").toString(), (new StringBuilder("/org/saiko/ai/genetics/tsp/etc/cities_")).append(param).append(".csv").toString(), (new StringBuilder("/org/saiko/ai/genetics/tsp/etc/cities_")).append(param).toString(), (new StringBuilder("/org/saiko/ai/genetics/tsp/etc/cities_0")).append(param).append(".csv").toString(), (new StringBuilder("/org/saiko/ai/genetics/tsp/etc/cities_0")).append(param).toString()
                        });
                        int j1 = 0;
                        for(int l1 = param.length; j1 < l1; j1++)
                        {
                            String resName = param[j1];
                            if(org/saiko/ai/genetics/tsp/TSP.getResourceAsStream(resName) == null)
                                continue;
                            paramMap = resName;
                            break;
                        }

                        if(paramMap == null)
                            error = true;
                        continue;
                    }
                    if(param.startsWith("engine="))
                    {
                        int engineIndex = Integer.parseInt(param.substring(param.lastIndexOf('=') + 1));
                        (paramEngine = h[engineIndex]).newInstance();
                        continue;
                    }
                    if(param.startsWith("population="))
                    {
                        paramPopulation = Integer.parseInt(param.substring(param.lastIndexOf('=') + 1));
                        continue;
                    }
                    if(param.startsWith("max="))
                    {
                        paramMax = Integer.parseInt(param.substring(param.lastIndexOf('=') + 1));
                        continue;
                    }
                    if(param.startsWith("growth="))
                    {
                        paramGrowth = Double.parseDouble(param.substring(param.lastIndexOf('=') + 1));
                        continue;
                    }
                    if(param.startsWith("mutation="))
                    {
                        paramMutation = Double.parseDouble(param.substring(param.lastIndexOf('=') + 1));
                        continue;
                    }
                    if(param.startsWith("rms="))
                    {
                        paramRms = Boolean.parseBoolean(param.substring(param.lastIndexOf('=') + 1));
                        continue;
                    }
                    if(param.startsWith("xml="))
                    {
                        paramXMLFileName = param.substring(param.lastIndexOf('=') + 1);
                        continue;
                    }
                    error = true;
                    break;
                }

            }
            catch(Throwable _ex)
            {
                error = true;
            }
            if(error)
            {
                String ussage = (new StringBuilder("Error in command line parameters.\n")).append(errorMessage).append("\nOptions: \n--console     mandatory, sets the output to console, no graphics displayed.\n").append("--map=NAME    where name is name of resource with .csv format.\n                build in maps:\n").append("                  /org/saiko/ai/genetics/tsp/etc/cities_020.csv\n                  /org/saiko/ai/genetics/tsp/etc/cities_050.csv <- DEFAULT\n").append("                  /org/saiko/ai/genetics/tsp/etc/cities_100.csv\n                  /org/saiko/ai/genetics/tsp/etc/cities_150.csv\n").append("                  /org/saiko/ai/genetics/tsp/etc/cities_192.csv\n                you can use only number part (020, 050...) as map name for build in maps.\n").append("--priority=N  where N in <1..10>; DEFAULT 5\n--engine=N    where N is the index of engine to use; DEFAULT engine is GreedyCrossoverHibrid2OptEngine\n").append("                build in engines:\n").toString();
                int i = 0;
                Class aclass[] = h;
                int i1 = 0;
                for(int k1 = aclass.length; i1 < k1; i1++)
                {
                    Class engineClass = aclass[i1];
                    ussage = (new StringBuilder(String.valueOf(ussage))).append("                  ").append(i).append(": ").append(engineClass.getSimpleName()).append("\n").toString();
                    i++;
                }

                ussage = (new StringBuilder(String.valueOf(ussage))).append("--rms=T       where T in <true,false> - computes RMS cost from distance; DEFAULT false\n--population=N where N is the initial population size. DEFAULT 1000.\n--max=N       where N is the max number of the same best result; DEFAULT 100\n--growth=N    where N is population growth. DEFAULT 0.0075\n--mutation=N  where N is mutation ratio. DEFAULT 0.5\n--xml=FILE.xml where FILE is output name for XML report file. \n              DEFAULT tsp_report_yyyy_MM_dd_HH_mm.xml\n\nSee the gui interface help, documentation or http://www.saiko.cz/ai/tsp/ for detailed information.\nExample:       --console --map=192 --priority=1 --engine=3 --rms=false --population=200 --growth=0.01 --max=200 --mutation=0.5 \n               --console\n               --help\n").toString();
                System.err.println(ussage);
                System.exit(-1);
            }
            System.out.println((new StringBuilder("Priority: ")).append(paramPriority).toString());
            System.out.println((new StringBuilder("Map: ")).append(paramMap).toString());
            System.out.println((new StringBuilder("Engine: ")).append(paramEngine).toString());
            System.out.println((new StringBuilder("RMS: ")).append(paramRms).toString());
            System.out.println((new StringBuilder("Population: ")).append(paramPopulation).toString());
            System.out.println((new StringBuilder("Mutation: ")).append(paramMutation).toString());
            System.out.println((new StringBuilder("Growth: ")).append(paramGrowth).toString());
            System.out.println((new StringBuilder("Max best age: ")).append(paramMax).toString());
            System.out.println((new StringBuilder("XML report file: ")).append(paramXMLFileName).toString());
            System.out.println("Initializing ...");
            TSP tsp;
            (tsp = new TSP(false)).e.J = true;
            tsp.e.E = paramPopulation;
            tsp.e.I = paramMax;
            tsp.e.K = paramRms;
            tsp.e.H = paramMutation;
            tsp.e.G = paramGrowth;
            tsp.e.F = paramPriority;
            tsp.r = paramEngine;
            tsp.s = (_1vbs734)paramEngine.newInstance();
            tsp.j = paramMap;
            tsp.a(null, true);
            System.out.println("Running ...");
            tsp.start();
            System.out.println("Writing the report ...");
            (new _3fvg51p(tsp)).b(paramXMLFileName);
            System.out.println("Finished.");
            System.exit(0);
            return;
        } else
        {
            (new TSP()).start();
            return;
        }
    }

    public final _3go3ei7 e;
    protected Thread g;
    protected static final Class h[] = {
        org/saiko/ai/genetics/tsp/_2m824ko/_19g5qqs/_1alb7hs, org/saiko/ai/genetics/tsp/_2m824ko/_t2179s/_2ua2pht, org/saiko/ai/genetics/tsp/_2m824ko/_vmqrkq/_3iohfho, org/saiko/ai/genetics/tsp/_2m824ko/_2n2kgqh/_1ttuld6, org/saiko/ai/genetics/tsp/_2m824ko/_tb82gs/_1ikrcq7
    };
    protected static final String i[] = {
        "cities_020", "cities_050", "cities_100", "cities_150", "cities_192", 0, "square_15x15", "triangle_15x15", "circle_150", "circle_120", 
        "full_circle_305", "spiral_263", "line_100"
    };
    protected String j;
    protected static final Object mutex = new Object();
    protected _1nogfu0 k[];
    protected volatile boolean l;
    protected volatile boolean m;
    protected volatile boolean n;
    protected _8eu935 o;
    protected long p;
    protected long q;
    protected Class r;
    _1vbs734 s;
    String t;
    int u;
    int v;
    private double w;
    _30ibutj z;


    private class _cls1 extends Thread
    {

        public final void run()
        {
            while(!A.m) 
            {
                A.q = System.currentTimeMillis() - A.p;
                A.a(A.s);
                try
                {
                    Thread.sleep(A.e.J ? 15000 : '\u03E8');
                }
                catch(Exception _ex) { }
            }
        }

        private TSP A;

        _cls1()
        {
            A = TSP.this;
            super();
        }
    }

}
