// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TSPMenu.java

package org.saiko.ai.genetics.tsp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

// Referenced classes of package org.saiko.ai.genetics.tsp:
//            TSP, _1nogfu0, _2at77c7, _2dvqkcq, 
//            _30ibutj, _3go3ei7, _3q4dees, _3sh1lk1, 
//            _8eu935, _t12c1r

public final class _3fvg51p
{

    protected _3fvg51p(TSP parent)
    {
        aa = new _t12c1r(this);
        ab = new _3q4dees(this);
        ac = new _3q4dees(this);
        ag = new _3q4dees(this);
        ah = new _t12c1r(this);
        ai = new _3q4dees(this);
        aj = new _t12c1r(this);
        ak = new _t12c1r(this);
        al = new _3q4dees(this);
        an = new _3q4dees(this);
        ao = new _3q4dees(this);
        aq = new _t12c1r(this);
        ar = new _3sh1lk1(this);
        as = new _t12c1r(this);
        at = new _3q4dees(this);
        au = new _t12c1r(this);
        av = new _2at77c7(this);
        aw = new _2at77c7(this);
        ax = new _2at77c7(this);
        ay = new _2at77c7(this);
        az = new _2at77c7(this);
        aA = null;
        aB = null;
        Y = parent;
    }

    public final _3fvg51p r()
    {
        JMenuBar menuBar = new JMenuBar();
        s();
        Font menuFont = new Font("courier", 1, aj.getFont().getSize());
        menuBar.add(aa);
        aa.add(ab);
        aa.add(ac);
        aa.addSeparator();
        aa.add(ad);
        aa.add(ae);
        aa.add(af);
        aa.addSeparator();
        aa.add(ag);
        ad.setEnabled(false);
        ae.setEnabled(false);
        ButtonGroup group;
        ((_3fvg51p) (group = this)).ag.addActionListener(group. new _cls2());
        ((_3fvg51p) (group)).ab.addActionListener(group. new _cls3());
        ((_3fvg51p) (group)).ac.addActionListener(group. new _cls4());
        ((_3fvg51p) (group)).ad.addActionListener(group. new _cls5());
        ((_3fvg51p) (group)).ae.addActionListener(group. new _cls6());
        ((_3fvg51p) (group)).af.addActionListener(group. new _cls7());
        menuBar.add(ah);
        z();
        A();
        ah.addSeparator();
        ah.add(ai);
        menuBar.add(aj);
        t();
        u();
        menuBar.add(ak);
        ak.add(al);
        ak.add(am);
        ak.add(an);
        ak.add(ao);
        ak.addSeparator();
        ak.add(ap);
        ((_3fvg51p) (group = this)).al.addActionListener(group. new _cls8());
        ((_3fvg51p) (group)).am.addActionListener(group. new _cls9());
        ((_3fvg51p) (group)).an.addActionListener(group. new _cls10());
        ((_3fvg51p) (group)).ao.addActionListener(group. new _cls11());
        ((_3fvg51p) (group)).ap.addActionListener(group. new _cls13());
        menuBar.add(au);
        group = new ButtonGroup();
        au.add(av);
        au.add(aw);
        au.add(ax);
        au.add(ay);
        au.add(az);
        group.add(av);
        group.add(aw);
        group.add(ax);
        group.add(ay);
        group.add(az);
        ax.setSelected(true);
        ((_3fvg51p) (group = this)).av.addActionListener(group. new _cls12());
        ((_3fvg51p) (group)).aw.addActionListener(group. new _cls23());
        ((_3fvg51p) (group)).ax.addActionListener(group. new _cls24());
        ((_3fvg51p) (group)).ay.addActionListener(group. new _cls25());
        ((_3fvg51p) (group)).az.addActionListener(group. new _cls26());
        menuBar.add(aq);
        aq.add(ar);
        ar.setSelected(false);
        ((_3fvg51p) (group = this)).ar.addActionListener(group. new _cls16());
        menuBar.add(as);
        as.add(at);
        ((_3fvg51p) (group = this)).at.addActionListener(group. new _cls17());
        Component acomponent[];
        Component acomponent2[] = acomponent = menuBar.getComponents();
        int i = 0;
        for(int j = acomponent2.length; i < j; i++)
        {
            Component c;
            (c = acomponent2[i]).setFont(menuFont);
            if(c instanceof JMenu)
            {
                Component acomponent1[];
                Component acomponent3[] = acomponent1 = ((JMenu)c).getMenuComponents();
                int k = 0;
                for(int l = acomponent3.length; k < l; k++)
                {
                    Component component;
                    (component = acomponent3[k]).setFont(menuFont);
                }

            }
        }

        Y.z.setJMenuBar(menuBar);
        return this;
    }

    protected final void s()
    {
        aa.setText("Program");
        ab.setText("Start");
        ac.setText("Pause");
        ad.setText("Save PDF report as ...");
        ae.setText("Save XML report as ...");
        af.setText("Convert XML report to PDF ...");
        ag.setText("Exit");
        ac.setEnabled(false);
        ab.setEnabled(true);
        ah.setText("Maps");
        ai.setText("Save maps as ..");
        aj.setText("Engine");
        ak.setText("Settings");
        al.setText(a("Population size:", Integer.valueOf(Y.e.i())));
        am.setText(a("Population grow:", Double.valueOf(Y.e.l())));
        an.setText(a("Mutation ratio:", Double.valueOf(Y.e.k())));
        ao.setText(a("Max best age:", Integer.valueOf(Y.e.j())));
        ap.setText("RMS cost");
        aq.setText("Grahics");
        ar.setText("Antialiasing");
        as.setText("Help");
        at.setText("About application");
        au.setText("Priority");
        av.setText("Highest");
        aw.setText("High");
        ax.setText("Normal");
        ay.setText("Lo");
        az.setText("Lowest");
        d(true);
    }

    private void d(boolean enable)
    {
        Component acomponent[];
        Component acomponent1[] = acomponent = ah.getMenuComponents();
        int i = 0;
        for(int j = acomponent1.length; i < j; i++)
        {
            Component component;
            (component = acomponent1[i]).setEnabled(enable);
        }

        acomponent1 = component = aj.getMenuComponents();
        i = 0;
        for(int k = acomponent1.length; i < k; i++)
        {
            Component component1;
            (component1 = acomponent1[i]).setEnabled(enable);
        }

        acomponent1 = component1 = ak.getMenuComponents();
        i = 0;
        for(int l = acomponent1.length; i < l; i++)
        {
            Component component2;
            (component2 = acomponent1[i]).setEnabled(enable);
        }

    }

    private void t()
    {
        ButtonGroup group = new ButtonGroup();
        Class aclass[] = TSP.h;
        int i = 0;
        for(int j = aclass.length; i < j; i++)
        {
            Class e;
            Class engineClass = e = aclass[i];
            JRadioButtonMenuItem menu = new _2at77c7(this);
            String menuText = e.getSimpleName();
            menu.setText(menuText);
            menu.putClientProperty(menuText, engineClass);
            if(Y.r.equals(e))
                menu.setSelected(true);
            group.add(menu);
            aj.add(menu);
        }

    }

    private void u()
    {
        Component acomponent[] = aj.getMenuComponents();
        int i = 0;
        for(int j = acomponent.length; i < j; i++)
        {
            Component component;
            ((JMenuItem)(component = acomponent[i])).addActionListener(new _cls1());
        }

    }

    protected final void v()
    {
        if(Y.l)
        {
            Y.l = false;
            ac.setText("Pause");
            ab.setEnabled(true);
            Y.g.interrupt();
            return;
        } else
        {
            ac.setText("Resume");
            Y.l = true;
            ab.setEnabled(false);
            return;
        }
    }

    protected final void w()
    {
        if(!Y.n)
        {
            d(false);
            Y.z.U.setText("Initializing..");
            Y.n = true;
            ab.setText("Stop");
            ac.setEnabled(true);
            ad.setEnabled(false);
            ae.setEnabled(false);
            af.setEnabled(false);
            Y.g = new Thread(new _cls27());
            Y.g.setPriority(Y.e.n());
            Y.g.start();
            return;
        } else
        {
            ad.setEnabled(false);
            ae.setEnabled(false);
            af.setEnabled(false);
            ab.setEnabled(false);
            ac.setEnabled(false);
            Y.m = true;
            return;
        }
    }

    private static String a(String str, Object value)
    {
        String str2 = value.toString();
        for(; str.length() < 20; str = (new StringBuilder(String.valueOf(str))).append(" ").toString());
        if(value instanceof Double)
        {
            str2 = new DecimalFormat("#################.################");
            double d = ((Double)value).doubleValue();
            str2 = str2.format(d);
        }
        if(str2.indexOf('.') == -1)
            for(; str2.length() < 7; str2 = (new StringBuilder(" ")).append(str2).toString());
        else
            for(; str2.indexOf('.') < 7; str2 = (new StringBuilder(" ")).append(str2).toString());
        return (new StringBuilder(String.valueOf(str))).append(str2).toString();
    }

    protected final Double a(String message, double doubleValue)
    {
        if((message = (String)JOptionPane.showInputDialog(Y.z, message, "TSP Settings", 3, null, null, (new DecimalFormat("################.################")).format(doubleValue))) == null)
            return null;
label0:
        {
            if((message = Double.valueOf(Double.parseDouble(message))).doubleValue() >= 0.0D && message.doubleValue() <= 1.0D)
                return message;
            break label0;
        }
        JVM INSTR pop ;
        JOptionPane.showMessageDialog(Y.z, "Can not use this value.", "Error", 2);
        return null;
    }

    protected final Integer a(String message, int intValue)
    {
        if((message = (String)JOptionPane.showInputDialog(Y.z, message, "TSP Settings", 3, null, null, (new DecimalFormat("################")).format(intValue))) == null)
            return null;
label0:
        {
            if((message = Integer.valueOf(Integer.parseInt(message))).intValue() >= 10)
                return message;
            break label0;
        }
        JVM INSTR pop ;
        JOptionPane.showMessageDialog(Y.z, "Can not use this value.", "Error", 2);
        return null;
    }

    protected final void x()
    {
        JFileChooser fileChooser;
        fileChooser = new JFileChooser();
        if(aA == null)
            aA = (new File(".")).getAbsoluteFile();
        else
            fileChooser.setCurrentDirectory(aA);
        fileChooser.setSelectedFile(new File(aA, "tsp_maps.zip"));
        fileChooser.setFileFilter(new _cls28());
        if(fileChooser.showSaveDialog(Y.z) != 0)
            break MISSING_BLOCK_LABEL_434;
        File f;
        aA = fileChooser.getCurrentDirectory();
        String fileName;
        if(!(fileName = (f = fileChooser.getSelectedFile()).getName()).toLowerCase().endsWith(".zip"))
        {
            String ext = "zip";
            if(!fileName.endsWith("."))
                ext = (new StringBuilder(".")).append(ext).toString();
            fileName = (new StringBuilder(String.valueOf(fileName))).append(ext).toString();
            File parentDir = f.getParentFile();
            f = new File(parentDir, fileName);
        }
        if(f.exists() && JOptionPane.showConfirmDialog(Y.z, "Should be existing file overwritten ?", "Question", 0) == 1)
            return;
        ZipOutputStream zip;
        (zip = new ZipOutputStream(new FileOutputStream(f))).setLevel(9);
        String as1[] = TSP.i;
        int j = 0;
        for(int k = as1.length; j < k; j++)
        {
            String mapName;
            if((mapName = as1[j]) != null)
            {
                InputStream i;
                if((i = (new Object()).getClass().getResourceAsStream((new StringBuilder("/org/saiko/ai/genetics/tsp/etc/")).append(mapName).append(".csv").toString())) != null)
                {
                    ZipEntry zipEntry = new ZipEntry((new StringBuilder(String.valueOf(mapName))).append(".csv").toString());
                    zip.putNextEntry(zipEntry);
                    byte b[] = new byte[1024];
                    int l;
                    while((l = i.read(b)) > 0) 
                        zip.write(b, 0, l);
                    zip.closeEntry();
                }
                i.close();
            }
        }

        zip.close();
        JOptionPane.showMessageDialog(Y.z, (new StringBuilder("OK, maps exported to the file: \n")).append(f).toString(), "Info", 1);
        return;
        JVM INSTR dup ;
        f;
        printStackTrace();
        JOptionPane.showMessageDialog(Y.z, "Can not export maps.", "Error", 2);
    }

    protected final void y()
    {
        JFileChooser fileChooser;
        fileChooser = new JFileChooser();
        if(aB == null)
            aB = (new File(".")).getAbsoluteFile();
        fileChooser.setCurrentDirectory(aB);
        String timestamp = (new SimpleDateFormat("yyyy_MM_dd_HH_mm")).format(Calendar.getInstance().getTime());
        fileChooser.setSelectedFile(new File(aB, (new StringBuilder("tsp_report_")).append(timestamp).append(".pdf").toString()));
        fileChooser.setFileFilter(new _cls29());
        if(fileChooser.showSaveDialog(Y.z) != 0)
            break MISSING_BLOCK_LABEL_626;
        File filePDF;
        aB = fileChooser.getCurrentDirectory();
        String fileName;
        if(!(fileName = (filePDF = fileChooser.getSelectedFile()).getName()).toLowerCase().endsWith(".pdf"))
        {
            String ext = "pdf";
            if(!fileName.endsWith("."))
                ext = (new StringBuilder(".")).append(ext).toString();
            fileName = (new StringBuilder(String.valueOf(fileName))).append(ext).toString();
            File parentDir = filePDF.getParentFile();
            filePDF = new File(parentDir, fileName);
        }
        if(filePDF.exists() && JOptionPane.showConfirmDialog(Y.z, "Should be existing file overwritten ?", "Question", 0) == 1)
            return;
        Component c;
        BufferedImage screenImage;
        Graphics2D graphics = (screenImage = (BufferedImage)(c = Y.z.getContentPane()).createImage(c.getWidth(), c.getHeight())).createGraphics();
        boolean antialiasing = Y.e.D;
        Y.e.D = true;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        Y.z.U.setVisible(false);
        c.paint(graphics);
        Y.z.U.setVisible(true);
        Y.e.D = antialiasing;
        Map params = _2dvqkcq.a(Y);
        _1nogfu0 cities[] = Y.k;
        if(Y.o != null)
            cities = Y.o.k;
        _1nogfu0 cities2[] = new _1nogfu0[cities.length + 1];
        int iStart = 0;
        for(int i = 0; i < cities.length; i++)
        {
            if(!cities[i].c)
                continue;
            iStart = i;
            break;
        }

        for(int i = 0; i < cities.length;)
        {
            cities2[i] = cities[iStart];
            iStart++;
            i++;
            if(iStart >= cities.length)
                iStart = 0;
        }

        cities2[cities.length] = cities2[0];
        (new _2dvqkcq()).a(filePDF, cities2, screenImage, params, _2dvqkcq.getSystemProperties());
        JOptionPane.showMessageDialog(Y.z, (new StringBuilder("OK, report created to the file: \n")).append(filePDF).toString(), "Info", 1);
        try
        {
            Runtime.getRuntime().exec(new String[] {
                "cmd.exe", "/c", filePDF.getAbsolutePath()
            });
            return;
        }
        catch(Throwable _ex) { }
        try
        {
            Runtime.getRuntime().exec(new String[] {
                "cmd.exe", "/c", "start", filePDF.getAbsolutePath()
            });
            return;
        }
        catch(Throwable _ex)
        {
            return;
        }
        JVM INSTR dup ;
        filePDF;
        printStackTrace();
        JOptionPane.showMessageDialog(Y.z, "Can not create pdf report.", "Error", 2);
    }

    private void z()
    {
        ButtonGroup group = new ButtonGroup();
        String as1[] = TSP.i;
        int i = 0;
        for(int j = as1.length; i < j; i++)
        {
            String m;
            if((m = as1[i]) == null)
            {
                ah.addSeparator();
            } else
            {
                JRadioButtonMenuItem menu;
                (menu = new _2at77c7(this)).setText(m);
                if(Y.j.equals(m))
                    menu.setSelected(true);
                group.add(menu);
                ah.add(menu);
            }
        }

    }

    private void A()
    {
        Component acomponent[] = ah.getMenuComponents();
        int i = 0;
        for(int j = acomponent.length; i < j; i++)
        {
            Component m;
            if((m = acomponent[i]) instanceof JMenuItem)
                ((JMenuItem)m).addActionListener(new _cls14());
        }

        ai.addActionListener(new _cls15());
    }

    protected final void b(String XMLFileName)
    {
        if(XMLFileName == null)
        {
            XMLFileName = new JFileChooser();
            if(aB == null)
                aB = (new File(".")).getAbsoluteFile();
            XMLFileName.setCurrentDirectory(aB);
            String timestamp = (new SimpleDateFormat("yyyy_MM_dd_HH_mm")).format(Calendar.getInstance().getTime());
            XMLFileName.setSelectedFile(new File(aB, (new StringBuilder("tsp_report_")).append(timestamp).append(".xml").toString()));
            XMLFileName.setFileFilter(new _cls18());
            if(XMLFileName.showSaveDialog(Y.z) == 0)
            {
                aB = XMLFileName.getCurrentDirectory();
                XMLFileName = XMLFileName.getSelectedFile().getAbsolutePath();
            } else
            {
                return;
            }
        }
        String fileName;
        if(!(fileName = (XMLFileName = new File(XMLFileName)).getName()).toLowerCase().endsWith(".xml"))
        {
            String ext = "xml";
            if(!fileName.endsWith("."))
                ext = (new StringBuilder(".")).append(ext).toString();
            fileName = (new StringBuilder(String.valueOf(fileName))).append(ext).toString();
            File parentDir = XMLFileName.getParentFile();
            XMLFileName = new File(parentDir, fileName);
        }
        if(!Y.e.J && XMLFileName.exists() && JOptionPane.showConfirmDialog(Y.z, "Should be existing file overwritten ?", "Question", 0) == 1)
            return;
        PrintWriter report;
        (report = new PrintWriter(XMLFileName.getAbsolutePath(), "UTF-8")).println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        report.println();
        report.println("<tsp-report>");
        report.println(" <results>");
        Map params;
        String key;
        for(Iterator keys = (params = _2dvqkcq.a(Y)).keySet().iterator(); keys.hasNext(); report.println((new StringBuilder("  <result name=\"")).append(key).append("\" value=\"").append((String)params.get(key)).append("\"/>").toString()))
            key = (String)keys.next();

        report.println(" </results>");
        report.println(" <system-info>");
        String key;
        Map info;
        for(Iterator keys = (info = _2dvqkcq.getSystemProperties()).keySet().iterator(); keys.hasNext(); report.println((new StringBuilder("  <info name=\"")).append(key).append("\" value=\"").append((String)info.get(key)).append("\"/>").toString()))
            key = (String)keys.next();

        report.println(" </system-info>");
        _1nogfu0 cities[] = Y.k;
        if(Y.o != null)
            cities = Y.o.k;
        _1nogfu0 cities2[] = new _1nogfu0[cities.length + 1];
        int iStart = 0;
        for(int i = 0; i < cities.length; i++)
        {
            if(!cities[i].c)
                continue;
            iStart = i;
            break;
        }

        for(int i = 0; i < cities.length;)
        {
            cities2[i] = cities[iStart];
            iStart++;
            i++;
            if(iStart >= cities.length)
                iStart = 0;
        }

        cities2[cities.length] = cities2[0];
        report.println(" <path>");
        _1nogfu0 a_l1nogfu0[] = cities2;
        int j = 0;
        for(int k = a_l1nogfu0.length; j < k; j++)
        {
            _1nogfu0 city = a_l1nogfu0[j];
            report.println((new StringBuilder(" <city name=\"")).append(city.name).append("\" x=\"").append(city.a).append("\" y=\"").append(city.b).append("\"/>").toString());
        }

        report.println(" </path>");
        report.print("</tsp-report>");
        report.close();
        if(!Y.e.J)
        {
            JOptionPane.showMessageDialog(Y.z, (new StringBuilder("OK, report created to the file: \n")).append(XMLFileName).toString(), "Info", 1);
            try
            {
                Runtime.getRuntime().exec(new String[] {
                    "cmd.exe", "/c", XMLFileName.getAbsolutePath()
                });
                return;
            }
            catch(Throwable _ex) { }
            try
            {
                Runtime.getRuntime().exec(new String[] {
                    "cmd.exe", "/c", "start", XMLFileName.getAbsolutePath()
                });
                return;
            }
            catch(Throwable _ex)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_863;
        JVM INSTR dup ;
        XMLFileName;
        printStackTrace();
        JOptionPane.showMessageDialog(Y.z, "Can not create pdf report.", "Error", 2);
    }

    protected final void B()
    {
        JFileChooser fileChooser;
        Map params;
        Map info;
        fileChooser = new JFileChooser();
        if(aB == null)
            aB = (new File(".")).getAbsoluteFile();
        fileChooser.setCurrentDirectory(aB);
        fileChooser.setFileFilter(new _cls19());
        params = new LinkedHashMap();
        info = new LinkedHashMap();
        if(fileChooser.showOpenDialog(Y.z) != 0)
            break MISSING_BLOCK_LABEL_470;
        File fileXML;
        _1nogfu0 path[];
        aB = fileChooser.getCurrentDirectory();
        fileXML = fileChooser.getSelectedFile();
        Element root;
        Document document;
        NodeList resultInfos = (root = (document = (root = DocumentBuilderFactory.newInstance()).newDocumentBuilder().parse(new InputSource(new FileInputStream(fileXML)))).getDocumentElement()).getElementsByTagName("result");
        for(int i = 0; i < resultInfos.getLength(); i++)
        {
            String name;
            NamedNodeMap attributes;
            name = (attributes = (name = resultInfos.item(i)).getAttributes()).getNamedItem("name").getNodeValue();
            String value = attributes.getNamedItem("value").getNodeValue();
            params.put(name, value);
        }

        NodeList systemInfos = root.getElementsByTagName("info");
        for(int i = 0; i < systemInfos.getLength(); i++)
        {
            String name;
            NamedNodeMap attributes;
            name = (attributes = (name = systemInfos.item(i)).getAttributes()).getNamedItem("name").getNodeValue();
            String value = attributes.getNamedItem("value").getNodeValue();
            info.put(name, value);
        }

        NodeList cities;
        path = new _1nogfu0[(cities = root.getElementsByTagName("city")).getLength()];
        for(int i = 0; i < cities.getLength(); i++)
        {
            String name;
            NamedNodeMap attributes;
            name = (attributes = (name = cities.item(i)).getAttributes()).getNamedItem("name").getNodeValue();
            String x = attributes.getNamedItem("x").getNodeValue();
            String y = attributes.getNamedItem("y").getNodeValue();
            path[i] = new _1nogfu0(i, null, name, Integer.parseInt(x), Integer.parseInt(y));
        }

        break MISSING_BLOCK_LABEL_471;
        JVM INSTR dup ;
        String pdfFileName;
        pdfFileName;
        printStackTrace();
        JOptionPane.showMessageDialog(Y.z, "Can not read XML report file.", "Error", 2);
        return;
        return;
        cities = new JFileChooser();
        if(aB == null)
            aB = cities.getCurrentDirectory();
        else
            cities.setCurrentDirectory(aB);
        int iDot;
        if((iDot = (pdfFileName = fileXML.getName()).lastIndexOf('.')) != -1)
            pdfFileName = pdfFileName.substring(0, iDot);
        if(!pdfFileName.endsWith("."))
            pdfFileName = (new StringBuilder(String.valueOf(pdfFileName))).append(".").toString();
        pdfFileName = (new StringBuilder(String.valueOf(pdfFileName))).append("pdf").toString();
        cities.setSelectedFile(new File(fileXML.getParent(), pdfFileName));
        cities.setFileFilter(new _cls20());
        if(cities.showSaveDialog(Y.z) != 0)
            break MISSING_BLOCK_LABEL_1157;
        File filePDF;
        aB = cities.getCurrentDirectory();
        String fileName;
        if(!(fileName = (filePDF = cities.getSelectedFile()).getName()).toLowerCase().endsWith(".pdf"))
        {
            String ext = "pdf";
            if(!fileName.endsWith("."))
                ext = (new StringBuilder(".")).append(ext).toString();
            fileName = (new StringBuilder(String.valueOf(fileName))).append(ext).toString();
            File parentDir = filePDF.getParentFile();
            filePDF = new File(parentDir, fileName);
        }
        if(filePDF.exists() && JOptionPane.showConfirmDialog(Y.z, "Should be existing file overwritten ?", "Question", 0) == 1)
            return;
        TSP tsp2;
        (tsp2 = new TSP(false)).k = new _1nogfu0[path.length - 1];
        tsp2.e.a(true);
        for(int i = 0; i < tsp2.k.length; i++)
        {
            tsp2.k[i] = path[i];
            tsp2.k[i].e = tsp2.e;
        }

        tsp2.a(tsp2.k, false);
        for(int i = 0; i < tsp2.k.length; i++)
            path[i] = tsp2.k[i];

        path[path.length - 1] = path[0];
        tsp2.start();
        tsp2.z.setEnabled(false);
        tsp2.o = new _8eu935(tsp2.k, false);
        tsp2.z.repaint();
        BufferedImage screenImage;
        Component c;
        Graphics2D graphics;
        (graphics = (screenImage = (BufferedImage)(c = tsp2.z.getContentPane()).createImage(c.getWidth(), c.getHeight())).createGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        tsp2.z.U.setVisible(false);
        c.paint(graphics);
        tsp2.z.dispose();
        (new _2dvqkcq()).a(filePDF, path, screenImage, params, info);
        JOptionPane.showMessageDialog(Y.z, (new StringBuilder("OK, report created to the file: \n")).append(filePDF).toString(), "Info", 1);
        try
        {
            Runtime.getRuntime().exec(new String[] {
                "cmd.exe", "/c", filePDF.getAbsolutePath()
            });
            return;
        }
        catch(Throwable _ex) { }
        try
        {
            Runtime.getRuntime().exec(new String[] {
                "cmd.exe", "/c", "start", filePDF.getAbsolutePath()
            });
            return;
        }
        catch(Throwable _ex)
        {
            return;
        }
        JVM INSTR dup ;
        filePDF;
        printStackTrace();
        JOptionPane.showMessageDialog(Y.z, "Can not create pdf report.", "Error", 2);
        return;
    }

    protected final void C()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/org/saiko/ai/genetics/tsp/etc/about.html")));
        try
        {
            StringBuffer message = new StringBuffer();
            String s1;
            while((s1 = reader.readLine()) != null) 
            {
                message.append(s1);
                message.append(" ");
            }
            reader.close();
            s1 = message.toString().replaceAll("__VERSION__", TSP.c());
            message = "About application";
            reader = this;
            JDialog jdialog;
            (jdialog = new JDialog(((_3fvg51p) (reader)).Y.z)).setSize(600, 400);
            jdialog.setTitle(message);
            jdialog.setLayout(new BorderLayout());
            jdialog.setComponentOrientation(((_3fvg51p) (reader)).Y.z.getComponentOrientation());
            jdialog.setLocationRelativeTo(((_3fvg51p) (reader)).Y.z);
            jdialog.setResizable(true);
            (message = new JButton(" Close ")).addActionListener(reader. new _cls21(jdialog));
            reader = new JPanel();
            jdialog.add(reader, "South");
            reader.add(message);
            jdialog.setModal(true);
            reader = new JScrollPane();
            (message = new JEditorPane("text/html", s1)).setCaretPosition(0);
            message.setEditable(false);
            message.setBackground(null);
            message.setOpaque(true);
            message.addHyperlinkListener(new _cls22());
            reader.getViewport().add(message);
            jdialog.add(reader, "Center");
            jdialog.setVisible(true);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    TSP Y;
    private JMenu aa;
    private JMenuItem ab;
    private JMenuItem ac;
    protected final JMenuItem ad = new _3q4dees(this);
    protected final JMenuItem ae = new _3q4dees(this);
    protected final JMenuItem af = new _3q4dees(this);
    private JMenuItem ag;
    private JMenu ah;
    private JMenuItem ai;
    private JMenu aj;
    private JMenu ak;
    private JMenuItem al;
    protected final JMenuItem am = new _3q4dees(this);
    private JMenuItem an;
    private JMenuItem ao;
    protected final JCheckBoxMenuItem ap = new _3sh1lk1(this);
    private JMenu aq;
    private JCheckBoxMenuItem ar;
    private JMenu as;
    private JMenuItem at;
    private JMenu au;
    private JRadioButtonMenuItem av;
    private JRadioButtonMenuItem aw;
    private JRadioButtonMenuItem ax;
    private JRadioButtonMenuItem ay;
    private JRadioButtonMenuItem az;
    private File aA;
    private File aB;

    private class _cls2
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }

        _cls2()
        {
        }
    }


    private class _cls3
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.w();
        }

        private _3fvg51p aC;

        _cls3()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls4
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.v();
        }

        private _3fvg51p aC;

        _cls4()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls5
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.y();
        }

        private _3fvg51p aC;

        _cls5()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls6
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.b(null);
        }

        private _3fvg51p aC;

        _cls6()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls7
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.B();
        }

        private _3fvg51p aC;

        _cls7()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls8
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            if((e = aC.a("Initial population size", aC.Y.e.i())) != null)
            {
                aC.Y.e.b(e.intValue());
                aC.s();
            }
        }

        private _3fvg51p aC;

        _cls8()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls9
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            if((e = aC.a("Population grow (float number <= 1)", aC.Y.e.l())) != null)
            {
                aC.Y.e.b(e.doubleValue());
                aC.s();
            }
        }

        private _3fvg51p aC;

        _cls9()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls10
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            if((e = aC.a("Mutation ratio (float number <= 1)", aC.Y.e.k())) != null)
            {
                aC.Y.e.a(e.doubleValue());
                aC.s();
            }
        }

        private _3fvg51p aC;

        _cls10()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls11
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            if((e = aC.a("Maximum best cost age", aC.Y.e.j())) != null)
            {
                aC.Y.e.c(e.intValue());
                aC.s();
            }
        }

        private _3fvg51p aC;

        _cls11()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls13
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            if(aC.ap.isSelected())
            {
                aC.Y.e.b(true);
                return;
            } else
            {
                aC.Y.e.b(false);
                return;
            }
        }

        private _3fvg51p aC;

        _cls13()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls12
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.Y.e.d(10);
            if(aC.Y.g != null)
                aC.Y.g.setPriority(aC.Y.e.n());
        }

        private _3fvg51p aC;

        _cls12()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls23
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.Y.e.d(7);
            if(aC.Y.g != null)
                aC.Y.g.setPriority(aC.Y.e.n());
        }

        private _3fvg51p aC;

        _cls23()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls24
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.Y.e.d(5);
            if(aC.Y.g != null)
                aC.Y.g.setPriority(aC.Y.e.n());
        }

        private _3fvg51p aC;

        _cls24()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls25
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.Y.e.d(3);
            if(aC.Y.g != null)
                aC.Y.g.setPriority(aC.Y.e.n());
        }

        private _3fvg51p aC;

        _cls25()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls26
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.Y.e.d(1);
            if(aC.Y.g != null)
                aC.Y.g.setPriority(aC.Y.e.n());
        }

        private _3fvg51p aC;

        _cls26()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls16
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            Object obj = e;
            e = aC;
            if(((JCheckBoxMenuItem) (obj = (JCheckBoxMenuItem)((ActionEvent) (obj)).getSource())).isSelected())
                ((_3fvg51p) (e)).Y.e.a(true);
            else
                ((_3fvg51p) (e)).Y.e.a(false);
            ((_3fvg51p) (e)).Y.z.invalidate();
            ((_3fvg51p) (e)).Y.z.repaint();
        }

        private _3fvg51p aC;

        _cls16()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls17
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.C();
        }

        private _3fvg51p aC;

        _cls17()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls1
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            e = (Class)(e = (JMenuItem)e.getSource()).getClientProperty(e.getText());
            aC.Y.r = e;
            if(e.equals(org/saiko/ai/genetics/tsp/_2m824ko/_t2179s/_2ua2pht))
            {
                aC.am.setVisible(false);
                return;
            } else
            {
                aC.am.setVisible(true);
                return;
            }
        }

        private _3fvg51p aC;

        _cls1()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls27
        implements Runnable
    {

        public final void run()
        {
            aC.Y.run();
        }

        private _3fvg51p aC;

        _cls27()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls28 extends FileFilter
    {

        public final boolean accept(File f)
        {
            if(f.isDirectory())
                return true;
            return f.getAbsolutePath().toLowerCase().endsWith(".zip");
        }

        public final String getDescription()
        {
            return "*.zip";
        }

        _cls28()
        {
        }
    }


    private class _cls29 extends FileFilter
    {

        public final boolean accept(File f)
        {
            if(f.isDirectory())
                return true;
            return f.getAbsolutePath().toLowerCase().endsWith(".pdf");
        }

        public final String getDescription()
        {
            return "*.pdf";
        }

        _cls29()
        {
        }
    }


    private class _cls14
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.ad.setEnabled(false);
            aC.ae.setEnabled(false);
            e = (JMenuItem)e.getSource();
            aC.Y.j = e.getText();
            aC.Y.z.c(true);
        }

        private _3fvg51p aC;

        _cls14()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls15
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aC.x();
        }

        private _3fvg51p aC;

        _cls15()
        {
            aC = _3fvg51p.this;
            super();
        }
    }


    private class _cls18 extends FileFilter
    {

        public final boolean accept(File f)
        {
            if(f.isDirectory())
                return true;
            return f.getAbsolutePath().toLowerCase().endsWith(".xml");
        }

        public final String getDescription()
        {
            return "*.xml";
        }

        _cls18()
        {
        }
    }


    private class _cls19 extends FileFilter
    {

        public final boolean accept(File f)
        {
            if(f.isDirectory())
                return true;
            return f.getAbsolutePath().toLowerCase().endsWith(".xml");
        }

        public final String getDescription()
        {
            return "*.xml";
        }

        _cls19()
        {
        }
    }


    private class _cls20 extends FileFilter
    {

        public final boolean accept(File f)
        {
            if(f.isDirectory())
                return true;
            return f.getAbsolutePath().toLowerCase().endsWith(".pdf");
        }

        public final String getDescription()
        {
            return "*.pdf";
        }

        _cls20()
        {
        }
    }


    private class _cls21
        implements ActionListener
    {

        public final void actionPerformed(ActionEvent e)
        {
            aD.dispose();
        }

        private final JDialog aD;

        _cls21(JDialog jdialog)
        {
            aD = jdialog;
            super();
        }
    }


    private class _cls22
        implements HyperlinkListener
    {

        public final void hyperlinkUpdate(HyperlinkEvent e)
        {
            if(e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED)
            {
                e = e.getURL().toExternalForm();
                try
                {
                    Runtime.getRuntime().exec(new String[] {
                        e
                    });
                    return;
                }
                catch(Throwable _ex) { }
                try
                {
                    Runtime.getRuntime().exec(new String[] {
                        "cmd.exe", "/c", "start", e
                    });
                    return;
                }
                catch(Throwable _ex) { }
            }
        }

        _cls22()
        {
        }
    }

}
