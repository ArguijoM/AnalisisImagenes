/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Manuel
 */
public class Grafica extends JFrame{
    int r[];
    int g[];
    int b[];
    
    public Grafica(int red[],int green[], int blue[]){
        this.r=red;
        this.g = green;
        this.b = blue;
    }
    
    public void graficarHistograma(){
        XYSeries serieRed=new XYSeries("Rojo");
        XYSeries serieBlue=new XYSeries("Azúl");
        XYSeries serieGreen=new XYSeries("Verde");
        XYSeriesCollection dataset = new XYSeriesCollection();
        for(int i=0;i<r.length;i++){
            serieRed.add(i,r[i]);
            serieBlue.add(i,b[i]);
            serieGreen.add(i,g[i]);
        }
        dataset.addSeries(serieRed);
        dataset.addSeries(serieBlue);
        dataset.addSeries(serieGreen);
        JFreeChart chart = ChartFactory.createXYLineChart("Histograma", "Bytes", "Colores", dataset,PlotOrientation.VERTICAL,true,false,false);
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("main");
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(panel);
        frame.validate();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
