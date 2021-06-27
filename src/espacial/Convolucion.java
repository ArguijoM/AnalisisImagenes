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
 * @author Manuel
 */
public class Convolucion {
    
    private Image imagenOriginal;
    private BufferedImage imagenNueva;
    private int desfase,divisor;

    public Convolucion(Image imagenOriginal) {
      this.imagenOriginal = imagenOriginal;
      // crear una nueva imagen 
      this.imagenNueva = new BufferedImage(imagenOriginal.getWidth(null), imagenOriginal.getHeight(null),
                           BufferedImage.TYPE_INT_RGB);
    }
    
    public Image convolucion3x3(int [][] kernel,int desfase,int divisor){
       BufferedImage origin = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
       this.divisor = divisor;
       this.desfase = desfase;
        // recorrer la imagen para extraer
       // la ventana de valores
       for (int x=1;x<origin.getWidth()-1;x++)
           for (int y=1;y<origin.getHeight()-1;y++){
             // extraer los valores de la imagen
             int ventana[][] = obtenerValores(x,y,kernel[0].length,origin);
             if (ventana!=null){
                 // obtener el nuevo color del pixel 
                Color nuevo = convolucionar(ventana,kernel);
                this.imagenNueva.setRGB(x, y, nuevo.getRGB());
             
             }else{
                // si es nulo dejamos igual el tono
                this.imagenNueva.setRGB(x, y,origin.getRGB(x, y));
             }
             
           }
     return herramientas.HerramientasImagen.toImage(this.imagenNueva);
    }
    
    public Image convolucion5x5(int [][] kernel,int desfase,int divisor){
    BufferedImage origin = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
    this.divisor = divisor;
    this.desfase = desfase;
     // recorrer la imagen para extraer
    // la ventana de valores
    for (int x=1;x<origin.getWidth()-2;x++)
        for (int y=1;y<origin.getHeight()-2;y++){
          // extraer los valores de la imagen
          int ventana[][] = obtenerValores(x,y,kernel[0].length,origin);
          if (ventana!=null){
              // obtener el nuevo color del pixel 
             Color nuevo = convolucionar(ventana,kernel);
             this.imagenNueva.setRGB(x, y, nuevo.getRGB());

          }else{
             // si es nulo dejamos igual el tono
             this.imagenNueva.setRGB(x, y,origin.getRGB(x, y));
          }

        }
     return herramientas.HerramientasImagen.toImage(this.imagenNueva);
    }

    private int[][] obtenerValores(int x, int y, int tam,BufferedImage auxOriginal) {
       int mascara [][] = new int[tam][tam];
       if (auxOriginal.getWidth()<x+3 || auxOriginal.getHeight()<y+3){
        return null;
        
        }else {
        // obtenemos los valores
         int xx=0,yy=0;   
         for (int j=x;j<x+3;j++){
            for (int m=y; m < y+3;m++){

               mascara[xx][yy] = auxOriginal.getRGB(j, m);
                yy++;
            }
            yy=0;
            xx++;
            }   
        }

       return mascara;
    }

    private Color convolucionar(int[][] ventana, int[][] kernel) {
        int tonosRed = 0;
        int tonosGreen = 0;
        int tonosBlue = 0;
        Color colorPixel;
        for (int x=0;x<ventana[0].length;x++){
            for (int y=0;y<ventana[0].length;y++){
                colorPixel = new Color(ventana[x][y]);
                tonosRed+=(kernel[x][y]*colorPixel.getRed());
                tonosGreen+=(kernel[x][y]*colorPixel.getGreen());
                tonosBlue+=(kernel[x][y]*colorPixel.getBlue());
            }
        }
        tonosRed/=this.divisor;
        tonosGreen/=this.divisor; 
        tonosBlue/=this.divisor;
        tonosRed+=this.desfase;
        tonosGreen+=this.desfase; 
        tonosBlue+=this.desfase;

        tonosRed = EspacialUno.verificar(tonosRed);
        tonosGreen = EspacialUno.verificar(tonosGreen);
        tonosBlue = EspacialUno.verificar(tonosBlue);

        colorPixel = new Color(tonosRed, tonosGreen, tonosBlue);
        
        return colorPixel;
    }
    
    
    
}