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
public class EspacialUno {
    
    // By Oscar
    public static Image convertirANegativo(Image imagenOriginal){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
        for(int x=0; x<bi.getWidth();x++){
            for(int y=0; y< bi.getHeight();y++){
               int p=bi.getRGB(x, y);
               int a=(p>>24)&0xff;
               int r=(p>>16)&0xff;
               int g=(p>>8)&0xff;
               int b=p&0xff; 
               r=255-r;
               g=255-g;
               b=255-b;
               
               p=(a<<24)|(r<<16)|(g<<8)|b;
               bi.setRGB(x,y,p);
            }
                  
        }
     return herramientas.HerramientasImagen.toImage(bi);
    }
    
    // By  Dávila
    public static Image convertirAGrises(Image imagenOriginal){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color ;
                int i,j,aux;
                for(j = 0; j< bi.getHeight(); j++){
                    for(i = 0; i < bi.getWidth(); i++){
                     color = new Color(bi.getRGB(i,j));
                     aux = (color.getRed()+color.getBlue()+color.getGreen())/3;
                     color = new Color(aux,aux,aux);
                     bi.setRGB(i, j, color.getRGB());
                    }
                }
     return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image modificarIluminacion (Image imagenOriginal, int valor){
            
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color ;
                int i,j,aux;
                for(j = 0; j< bi.getHeight(); j++){
                    for(i = 0; i < bi.getWidth(); i++){
                     color = new Color(bi.getRGB(i,j));
                     int r = color.getRed()+valor;
                     int g = color.getGreen()+valor;
                     int b = color.getBlue()+valor;
                     
                     color = new Color(verificar(r),verificar(g),verificar(b));
                     bi.setRGB(i, j, color.getRGB());
                    }
                }
     return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image ExpansionLineal(Image image, int r1, int r2){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(image);
        Color color ;
        int i,j,aux;
        for(j = 0; j< bi.getHeight(); j++){
            for(i = 0; i < bi.getWidth(); i++){
                color = new Color(bi.getRGB(i,j));
                int r = (color.getRed()-r1)*(255/(r2-r1));
                int g = (color.getGreen()-r1)*(255/(r2-r1));
                int b = (color.getBlue()-r1)*(255/(r2-r1));

                color = new Color(verificar(r),verificar(g),verificar(b));
                bi.setRGB(i, j, color.getRGB());
             }
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image ExpansionLogaritmica(Image image, int c){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(image);
        Color color ;
        int i,j,aux;
        for(j = 0; j< bi.getHeight(); j++){
            for(i = 0; i < bi.getWidth(); i++){
                color = new Color(bi.getRGB(i,j));
                int r = (int)((c*Math.log(1+color.getRed()))/(Math.log(1+c)));
                int g = (int)((c*Math.log(1+color.getGreen()))/(Math.log(1+c)));
                int b = (int)((c*Math.log(1+color.getBlue()))/(Math.log(1+c)));

                color = new Color(verificar(r),verificar(g),verificar(b));
                bi.setRGB(i, j, color.getRGB());
             }
        }
        
        return herramientas.HerramientasImagen.toImage(bi);
    }
        
    public static Image ExpansionExponencial(Image image, double c){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(image);
        Color color;
        int i,j,aux;
        for(j = 0; j< bi.getHeight(); j++){
            for(i = 0; i < bi.getWidth(); i++){
                color = new Color(bi.getRGB(i,j));
                int r = (int)(Math.pow(1+c,color.getRed())/c);
                int g = (int)(Math.pow(1+c,color.getGreen())/c);
                int b = (int)(Math.pow(1+c,color.getBlue())/c);

                color = new Color(verificar(r),verificar(g),verificar(b));
                bi.setRGB(i, j, color.getRGB());
             }
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    
    
    public static int verificar(int valor){
        if(valor>255) return 255;
        if(valor<0) return 0;
        return valor;
    }
    
    public static Image Ecualizacion(Image img){
        int NM = img.getWidth(null)*img.getHeight(null);
        Histograma h = new Histograma(img);
        h.calcularHistogramasSinGrafica();
        double[] hprom = h.getR();
        double[] daf = new double[256];
        int[] nt = new int[256];
        daf[0] = (int)hprom[0];
        nt[0] = (int)Math.round((daf[0]/NM)*255);
        // recorremos el histograma para acumular
        for(int x=1; x<hprom.length;x++){
            daf[x] = (int)(hprom[x]+daf[x-1]);
            double aux = daf[x]/NM;
            int tmp = (int) Math.round(aux * 255);
            nt[x] = tmp;
        }

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(img);
        Color color;
        for(int x=0; x<bi.getWidth();x++){
            for(int y=0; y<bi.getHeight();y++){
                color = new Color(bi.getRGB(x, y));
                int t1 = color.getRed();
                int t2 =nt[t1];
                color = new Color(t2,t2,t2);     
                bi.setRGB(x,y,color.getRGB());
            }
        }

        
        return herramientas.HerramientasImagen.toImage(bi);

    }
    
    
    
}
