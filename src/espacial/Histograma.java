/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class Histograma {
    
    private Image imagenOriginal;
    private double[]r;
    private double[]g;
    private double[]b;

    public Histograma(Image imagen) {
        this.imagenOriginal = imagen;
        this.r = new double[256];
        this.g = new double[256];
        this.b = new double[256];
    }
    public void calcularHistogramas(){
        // recorrer la imagen
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y< bi.getHeight();y++){
                // extraer el color
                color = new Color(bi.getRGB(x, y));
                int r = color.getRed(); // (0-255)
                int g = color.getGreen(); // (0-255)
                int b = color.getBlue(); // (0-255)
                this.r[r]++;
                this.g[g]++;
                this.b[b]++;
            } 
        Grafica g1 = new Grafica(r,g,b);
        g1.graficarHistograma();
    }
        public void calcularHistogramasSinGrafica(){
        // recorrer la imagen
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y< bi.getHeight();y++){
                // extraer el color
                color = new Color(bi.getRGB(x, y));
                int r = color.getRed(); // (0-255)
                int g = color.getGreen(); // (0-255)
                int b = color.getBlue(); // (0-255)
                this.r[r]++;
                this.g[g]++;
                this.b[b]++;
            } 
    }

    /**
     * @return the r
     */
    public double[] getR() {
        return r;
    }

    /**
     * @return the g
     */
    public double[] getG() {
        return g;
    }

    /**
     * @return the b
     */
    public double[] getB() {
        return b;
    }
    
    
    public static void main(String[] args){
        Histograma h = new  Histograma(herramientas.HerramientasImagen.abrirImagen());
        h.calcularHistogramas();
    }
    
}
