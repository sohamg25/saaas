// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TSPGui.java

package org.saiko.ai.genetics.tsp;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

// Referenced classes of package org.saiko.ai.genetics.tsp:
//            TSP, _1nogfu0, _3fvg51p

public final class _30ibutj extends JFrame
{

    public _30ibutj(TSP parent)
    {
        Y = parent;
    }

    public final void init()
    {
        M = new _3fvg51p(Y);
        setIconImage((new ImageIcon(getClass().getResource("/org/saiko/etc/logo16.gif"))).getImage());
        setTitle("Traveling salesman problem");
        setSize(L);
        setResizable(false);
        setDefaultCloseOperation(3);
        M.r();
        setVisible(true);
        _30ibutj _l30ibutj;
        (_l30ibutj = this).getContentPane().setBackground(Color.WHITE);
        _l30ibutj.getContentPane().setLayout(null);
        _l30ibutj.U = new JTextField("Initializing ...");
        _l30ibutj.getContentPane().add(_l30ibutj.U);
        _l30ibutj.V = _l30ibutj.getContentPane().getBounds();
        _l30ibutj.X = (int)(1.5D * (double)_l30ibutj.U.getFontMetrics(_l30ibutj.U.getFont()).getHeight());
        _l30ibutj.U.setBounds(0, _l30ibutj.V.height - _l30ibutj.X, _l30ibutj.V.width, _l30ibutj.X);
        _l30ibutj.c(false);
        U.setText("Ready");
        setVisible(true);
        invalidate();
        repaint();
    }

    protected final int e(int virtualX)
    {
        return virtualX = (int)((double)S + T * (double)(virtualX - N));
    }

    protected final int f(int virtualY)
    {
        return virtualY = (int)((double)(S / 2) + T * (double)(virtualY - P));
    }

    protected final void c(boolean reloadCities)
    {
        synchronized(TSP.mutex)
        {
            Y.o = null;
            U.setText("Loading ...");
            if(reloadCities)
            {
                Y.k = null;
                Y.a(null, true);
            }
            if(R != null)
                getContentPane().remove(R);
            R = null;
            (reloadCities = this).R = reloadCities. new _cls1();
            ((_30ibutj) (reloadCities)).R.setOpaque(false);
            ((_30ibutj) (reloadCities)).R.setLayout(null);
            getContentPane().add(R);
            R.setBounds(0, 0, V.width, V.height - X);
            W = R.getBounds();
            _30ibutj _l30ibutj;
            (_l30ibutj = reloadCities = this).N = -1;
            _l30ibutj.O = -1;
            _l30ibutj.P = -1;
            _l30ibutj.Q = -1;
            _1nogfu0 a_l1nogfu0[] = _l30ibutj.Y.k;
            int j = 0;
            for(int k = a_l1nogfu0.length; j < k; j++)
            {
                _1nogfu0 _l1nogfu0 = a_l1nogfu0[j];
                if(_l30ibutj.N == -1 || _l1nogfu0.x < _l30ibutj.N)
                    _l30ibutj.N = _l1nogfu0.x;
                if(_l30ibutj.O == -1 || _l1nogfu0.x > _l30ibutj.O)
                    _l30ibutj.O = _l1nogfu0.x;
                if(_l30ibutj.P == -1 || _l1nogfu0.y < _l30ibutj.P)
                    _l30ibutj.P = _l1nogfu0.y;
                if(_l30ibutj.Q == -1 || _l1nogfu0.y > _l30ibutj.Q)
                    _l30ibutj.Q = _l1nogfu0.y;
            }

            _l30ibutj.S = (int)(2D * (double)_l30ibutj.getGraphics().getFontMetrics().getHeight());
            _l30ibutj.T = Math.min(((double)_l30ibutj.W.width - 2D * (double)_l30ibutj.S) / (double)(_l30ibutj.O - _l30ibutj.N), ((double)_l30ibutj.W.height - 2D * (double)_l30ibutj.S) / (double)(_l30ibutj.Q - _l30ibutj.P));
            for(int i = 0; i < ((_30ibutj) (reloadCities)).Y.k.length; i++)
            {
                _cls2 _lcls2 = reloadCities. new _cls2();
                Color color = Color.decode("0x00aa00");
                if(((_30ibutj) (reloadCities)).Y.k[i].c)
                {
                    color = Color.decode("0xff0000");
                    _lcls2.setText("FIRST");
                }
                _lcls2.setBackground(color);
                _lcls2.setBounds(reloadCities.e(((_30ibutj) (reloadCities)).Y.k[i].getX()) - 2, reloadCities.f(((_30ibutj) (reloadCities)).Y.k[i].getY()) - 2, 5, 5);
                ((_30ibutj) (reloadCities)).R.add(_lcls2);
                if(((_30ibutj) (reloadCities)).Y.k[i].getName() != null && ((_30ibutj) (reloadCities)).Y.k[i].getName().trim().length() > 0)
                {
                    _cls3 _lcls3;
                    (_lcls3 = reloadCities. new _cls3(((_30ibutj) (reloadCities)).Y.k[i].getName())).setEditable(false);
                    Object obj1 = new Font("Sans", 1, 9);
                    _lcls3.setFont(((Font) (obj1)));
                    _lcls3.setBorder(null);
                    _lcls3.setBackground(null);
                    _lcls3.setOpaque(false);
                    _lcls3.setForeground(Color.LIGHT_GRAY);
                    obj1 = ((Font) (obj1)).getStringBounds(((_30ibutj) (reloadCities)).Y.k[i].getName(), new FontRenderContext(reloadCities.getGraphicsConfiguration().getDefaultTransform(), false, true));
                    _lcls3.setBounds(reloadCities.e(((_30ibutj) (reloadCities)).Y.k[i].getX()) - (int)((Rectangle2D) (obj1)).getWidth() / 2, reloadCities.f(((_30ibutj) (reloadCities)).Y.k[i].getY()), (int)(((Rectangle2D) (obj1)).getWidth() * 1.1000000000000001D), (int)(((Rectangle2D) (obj1)).getHeight() * 1.05D));
                    ((_30ibutj) (reloadCities)).R.add(_lcls3);
                }
            }

        }
        invalidate();
        repaint();
        U.setText("Ready");
    }

    private static Dimension L = new Dimension(785, 580);
    protected _3fvg51p M;
    private int N;
    private int O;
    private int P;
    private int Q;
    protected JPanel R;
    private int S;
    private double T;
    protected JTextField U;
    private Rectangle V;
    private Rectangle W;
    private int X;
    protected TSP Y;


    private class _cls1 extends JPanel
    {

        public final void paint(Graphics g)
        {
            if(Z.Y.e.D)
            {
                Graphics2D g2;
                (g2 = (Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            }
            super.paint(g);
            if(Z.Y.o != null)
            {
                g.setColor(Color.DARK_GRAY);
                _1nogfu0 bestCities[] = Z.Y.o.k;
                for(int i = 0; i < bestCities.length - 1; i++)
                {
                    _1nogfu0 city1 = bestCities[i];
                    _1nogfu0 city2 = bestCities[i + 1];
                    g.drawLine(Z.e(city1.getX()), Z.f(city1.getY()), Z.e(city2.getX()), Z.f(city2.getY()));
                }

                _1nogfu0 city1 = bestCities[bestCities.length - 1];
                _1nogfu0 city2 = bestCities[0];
                g.drawLine(Z.e(city1.getX()), Z.f(city1.getY()), Z.e(city2.getX()), Z.f(city2.getY()));
            }
        }

        private _30ibutj Z;

        _cls1()
        {
            Z = _30ibutj.this;
            super();
        }
    }


    private class _cls2 extends JLabel
    {

        public final void paint(Graphics g)
        {
            g.setColor(getBackground());
            if(Z.Y.e.D)
            {
                Graphics2D g2;
                (g2 = (Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            }
            if(getText() == null || getText().length() == 0)
            {
                g.fillOval(0, 0, 4, 4);
                return;
            } else
            {
                g.fillRect(0, 0, 5, 5);
                return;
            }
        }

        private _30ibutj Z;

        _cls2()
        {
            Z = _30ibutj.this;
            super();
        }
    }


    private class _cls3 extends JTextField
    {

        public final void paintComponent(Graphics g)
        {
            if(Z.Y.e.D)
            {
                Graphics2D g2;
                (g2 = (Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            }
            super.paintComponent(g);
        }

        private _30ibutj Z;

        _cls3(String $anonymous0)
        {
            Z = _30ibutj.this;
            super($anonymous0);
        }
    }

}
