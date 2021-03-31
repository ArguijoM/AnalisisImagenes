/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import espacial.Histograma;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Manuel
 */
public class umbral {
    private double[] medio;
    private int umbral,iter;
    private Image img;
    private Image imgSeg;

    public umbral(Image img) {
        this.iter=0;
        this.umbral=(int)(Math.random()*(254-1+1)+1);
        System.out.println("Umbral inicial: "+umbral);
        Image imagenGris =espacial.EspacialUno.convertirAGrises(img);
        this.img=imagenGris;
        //Image nueva = herramientas.HerramientasImagen.toImage(imagenBi);
        Histograma h = new Histograma(imagenGris);
        h.calcularHistogramas();
        
        //Image imagenBN = segmentarImagen(imagenGris, umbral);
        //Histograma h2 = new Histograma(imagenBN);
        //h2.calcularHistogramasSinGrafica();
        
        double[] r = h.getR();
        double[] g = h.getG();
        double[] b = h.getB();
        this.medio = new double[r.length];
        for(int i=0;i<r.length;i++){
            medio[i]=r[i];   
        }
        calcularUmbral(umbral);
    }
    
    public void calcularUmbral(int u){
        this.iter++;
        System.out.println("Iteraciones: "+iter+" Valor del umbral: "+u);
        double tonoMedio1=0;
        double tonoMedio2=0;
        
        if(u==255){
            System.out.println("Valor final del umbral es: "+u);
        }else{
            for(int i=0;i<u;i++){    
                tonoMedio1+=medio[i];
                //System.out.println("Posicion: "+i+" Tono: "+medio[i]);
            }
            for(int i=u;i<=255;i++){
                //System.out.println("Posicion: "+i+" Tono: "+medio[i]);
                tonoMedio2+=medio[i];
            }
            tonoMedio1=(int)tonoMedio1/u;
            tonoMedio2=(int)tonoMedio2/(255-u);

            double nuevoUmbralCantidad = (int)Math.abs((tonoMedio1+tonoMedio2)/2);
            //System.out.println("Cantidad de pixeles del nuevo humbral: "+nuevoUmbralCantidad);
            recalcularUmbral(nuevoUmbralCantidad);  
        }
    }
    
    public void recalcularUmbral(double nuevoUmbralCantidad){
        int n=1;
        int aux;
        
        do{
           n++;
        }while((aux=buscar(nuevoUmbralCantidad, n))==1);
        
        //System.out.println("Margen de error: "+(n-1));
        if(aux != umbral){
            this.umbral=aux;
            calcularUmbral(aux);
        }else{
            System.out.println("Ya no hay cambios");
            System.out.println("Valor final del umbral es: "+aux);
            this.imgSeg =segmentarImagen(img, aux);
        }
    }
    
    public int buscar(double nuevoUmbralCantidad, int n){
        int aux=1;
        for(int i=0;i<umbral;i++){
            if((int)nuevoUmbralCantidad <= (medio[i]+n) && (int)nuevoUmbralCantidad>=(medio[i]-n)){
                aux=i;
                //System.out.println("el valor mas cercano a: "+nuevoUmbralCantidad+" Es: "+medio[i]+" EN: "+i);
                break;
            }else{
                for(int j=umbral;j<=255;j++){
                    if((int)nuevoUmbralCantidad <= (medio[j]+n) && (int)nuevoUmbralCantidad>=(medio[j]-n)){
                        aux=j;
                        //System.out.println("el valor mas cercano a: "+nuevoUmbralCantidad+" Es: "+medio[i]+ " En: "+i);
                        break;
                    }
                }
            }
        }
        
         return aux;
    }
    
    public Image segmentarImagen(Image imagen, int u){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        for(int j = 0 ; j< bi.getWidth();j++){
            for(int m = 0 ; m < bi.getHeight();m++){
                color = new Color(bi.getRGB(j, m));
                double v = (color.getRed()+color.getGreen()+color.getBlue())/3;
                if(v>=u){
                    bi.setRGB(j, m,Color.BLACK.getRGB());
                }else{
                    bi.setRGB(j, m,Color.WHITE.getRGB());
                }
            }
        }
        return HerramientasImagen.toImage(bi);
    }   
}
