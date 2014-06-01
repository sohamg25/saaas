// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Report.java

package org.saiko.ai.genetics.tsp;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import sun.misc.BASE64Encoder;

// Referenced classes of package org.saiko.ai.genetics.tsp:
//            TSP, _1nogfu0, _1vbs734, _3go3ei7, 
//            _8eu935

final class _2dvqkcq extends PdfPageEventHelper
{

    _2dvqkcq()
    {
    }

    protected final void a(File file, _1nogfu0 cities[], BufferedImage image, Map params, Map systemProperties)
        throws Exception
    {
        Document document;
        (file = PdfWriter.getInstance(document = new Document(PageSize.A4, 40F, 40F, 170F, 60F), new FileOutputStream(file))).setPageEvent(this);
        document.open();
        document.add(new Chunk("\n"));
        (file = new PdfPTable(1)).getDefaultCell().setBorderWidth(0.0F);
        Paragraph header = new Paragraph("Result information\n\n", new Font(1, 14F, 3));
        PdfPCell cell;
        (cell = new PdfPCell(header)).setColspan(1);
        cell.setBorderWidth(0.0F);
        file.addCell(cell);
        PdfPTable subTable;
        (subTable = new PdfPTable(1)).getDefaultCell().setBorderWidth(0.0F);
        Paragraph p = new Paragraph();
        Font f = new Font(0, 12F);
        String key;
        String name;
        for(Iterator iterator = params.keySet().iterator(); iterator.hasNext(); p.add(new Chunk((new StringBuilder(" ")).append(name).append((String)params.get(key)).append("\n").toString(), f)))
        {
            key = (String)iterator.next();
            for(name = (new StringBuilder(String.valueOf(key))).append(":").toString(); name.length() < 23; name = (new StringBuilder(String.valueOf(name))).append(" ").toString());
        }

        subTable.addCell(p);
        file.addCell(subTable);
        file.setWidthPercentage(100F);
        document.add(file);
        PdfPTable systemInfo;
        (systemInfo = new PdfPTable(1)).getDefaultCell().setBorderWidth(0.0F);
        Paragraph header = new Paragraph("\n\nSystem information\n\n", new Font(1, 14F, 3));
        PdfPCell cell;
        (cell = new PdfPCell(header)).setColspan(1);
        cell.setBorderWidth(0.0F);
        systemInfo.addCell(cell);
        PdfPTable subTable;
        (subTable = new PdfPTable(1)).getDefaultCell().setBorderWidth(0.0F);
        Paragraph p = new Paragraph();
        Font f = new Font(0, 12F);
        String key;
        for(Iterator iterator = systemProperties.keySet().iterator(); iterator.hasNext(); p.add(new Chunk((new StringBuilder(" ")).append(file).append((String)systemProperties.get(key)).append("\n").toString(), f)))
        {
            key = (String)iterator.next();
            for(file = (new StringBuilder(String.valueOf(key))).append(":").toString(); file.length() < 23; file = (new StringBuilder(String.valueOf(file))).append(" ").toString());
        }

        subTable.addCell(p);
        systemInfo.addCell(subTable);
        systemInfo.setWidthPercentage(100F);
        document.add(systemInfo);
        document.setMargins(40F, 40F, 30F, 30F);
        document.setPageSize(PageSize.A4.rotate());
        document.newPage();
        if(image != null)
        {
            Image img;
            (img = Image.getInstance(image, null)).setAlignment(1);
            document.add(img);
        }
        document.setMargins(40F, 40F, 170F, 60F);
        document.setPageSize(PageSize.A4);
        document.newPage();
        document.add(new Paragraph("Salesman path\n\n", new Font(1, 14F, 3)));
        Font tableHeaderFont = new Font(BaseFont.createFont("Helvetica", "Cp1250", true), 12F, 1);
        PdfPTable datatable = new PdfPTable(6);
        int headerwidths[] = {
            5, 31, 16, 16, 16, 16
        };
        datatable.setWidths(headerwidths);
        datatable.setWidthPercentage(100F);
        datatable.getDefaultCell().setPadding(2.0F);
        datatable.getDefaultCell().setBorderWidth(1.0F);
        datatable.getDefaultCell().setHorizontalAlignment(1);
        PdfPCell c1;
        (c1 = new PdfPCell(new Phrase("City", tableHeaderFont))).setColspan(2);
        c1.setHorizontalAlignment(1);
        c1.setVerticalAlignment(1);
        datatable.addCell(c1);
        datatable.addCell(new Phrase("X\n(S-JTSK)", tableHeaderFont));
        datatable.addCell(new Phrase("Y\n(S-JTSK)", tableHeaderFont));
        datatable.addCell(new Phrase("Distance\n[m]", tableHeaderFont));
        datatable.addCell(new Phrase("Total\n[m]", tableHeaderFont));
        datatable.setHeaderRows(1);
        Font numberFont = new Font(0, 11F);
        double totalDistance = 0.0D;
        for(file = 0; file < cities.length; file++)
        {
            if(file % 2 == 1)
                datatable.getDefaultCell().setGrayFill(0.97F);
            datatable.getDefaultCell().setHorizontalAlignment(2);
            datatable.addCell(new Phrase(f.format(file + 1), numberFont));
            datatable.getDefaultCell().setHorizontalAlignment(0);
            datatable.addCell(new Phrase(cities[file].getName(), tableHeaderFont));
            datatable.getDefaultCell().setHorizontalAlignment(2);
            datatable.addCell(new Phrase(f.format(cities[file].a()), numberFont));
            datatable.addCell(new Phrase(f.format(cities[file].b()), numberFont));
            image = "0";
            params = "0";
            if(file > 0)
            {
                double distance = cities[file].a(cities[file - 1], false);
                image = f.format((int)distance);
                totalDistance += distance;
                params = f.format((int)totalDistance);
            }
            datatable.addCell(new Phrase(image, numberFont));
            datatable.addCell(new Phrase(params, numberFont));
            datatable.getDefaultCell().setGrayFill(0.0F);
        }

        document.add(datatable);
        document.close();
    }

    protected static Map getSystemProperties()
    {
        Map p;
        (p = new LinkedHashMap()).put("availableProcessors", String.valueOf(Runtime.getRuntime().availableProcessors()));
        p.put("freeMemory", f.format(Runtime.getRuntime().freeMemory()));
        p.put("totalMemory", f.format(Runtime.getRuntime().totalMemory()));
        p.put("maxMemory", f.format(Runtime.getRuntime().maxMemory()));
        String as[];
        String as1[] = as = (new String[] {
            "java.vm.name", "java.vm.vendor", "java.vm.version", "os.name", "os.version", "os.arch", "sun.arch.data.model"
        });
        int i = 0;
        for(int j = as1.length; i < j; i++)
        {
            String prop = as1[i];
            p.put(prop, System.getProperty(prop));
        }

        prop = prop = (new String[] {
            "PROCESSOR_IDENTIFIER", "NUMBER_OF_PROCESSORS", "OS"
        });
        int k = 0;
        for(int l = prop.length; k < l; k++)
        {
            String env = prop[k];
            p.put(env, System.getenv(env));
        }

        return p;
    }

    protected static Map a(TSP tsp)
    {
        Map p;
        (p = new LinkedHashMap()).put("Report created", (new SimpleDateFormat("yyyy/MM/dd HH:mm")).format(Calendar.getInstance().getTime()));
        p.put("Program version", TSP.c());
        p.put("TSPEngine", tsp.t);
        p.put("Map file", tsp.j);
        p.put("Map file hash", a(tsp.j));
        p.put("Number of cities", f.format(tsp.k.length));
        p.put("Init. population size", f.format(tsp.e.E));
        p.put("Population growth", f.format(tsp.e.G));
        if(tsp.s != null)
            p.put("Final population size", f.format(tsp.s.o()));
        p.put("Mutation ratio", f.format(tsp.e.H));
        p.put("RMS cost", tsp.e.K ? "true" : "false");
        p.put("Generation", f.format(tsp.v));
        p.put("Time", (new StringBuilder(String.valueOf(f.format((int)(tsp.q / 1000L))))).append(" s.").toString());
        p.put("Best cost age", f.format(tsp.u));
        if(tsp.o != null)
            p.put("Best distance", f.format((int)tsp.o.B));
        return p;
    }

    private static String a(String mapFile)
    {
        if((mapFile = (new Object()).getClass().getResourceAsStream((new StringBuilder("/org/saiko/ai/genetics/tsp/etc/")).append(mapFile).append(".csv").toString())) == null)
            return null;
        ByteArrayOutputStream buffer;
        byte b[] = new byte[1024];
        buffer = new ByteArrayOutputStream();
        int j;
        while((j = mapFile.read(b)) > 0) 
            buffer.write(b, 0, j);
        mapFile.close();
        mapFile = MessageDigest.getInstance("SHA");
        return (new BASE64Encoder()).encode(mapFile.digest(buffer.toByteArray()));
        JVM INSTR pop ;
        return null;
    }

    private static DecimalFormat f = new DecimalFormat("###,###,###,###,###.############");

}
