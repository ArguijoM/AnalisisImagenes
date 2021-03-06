/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author working
 */
public class HerramientasImagen {
    
    public static Image abrirImagen (){
    
          try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            
            BufferedImage bi = ImageIO.read(archivo);
            
            return toImage(bi);
        } catch (IOException ex) {
            Logger.getLogger(HerramientasImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }  
    
    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public static BufferedImage toBufferedImage (Image imagen){
         // imagen es un objeto de tipo BufferedImage
        if (imagen instanceof BufferedImage){
          return (BufferedImage)imagen;
        }
        BufferedImage bi = 
                new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }
 
    public static Image copiarImagen(Image i){
        BufferedImage bi = toBufferedImage(i);
        return bi.getScaledInstance(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_BGR);
    }
    
    public static BufferedImage grises(BufferedImage bi){
        //Crea una copia del mismo tama??o que la imagen
        for (int x=0;x < bi.getWidth();x++){
            for (int y=0;y < bi.getHeight();y++){
                //Obtiene el color
                Color c1=new Color(bi.getRGB(x, y));
                //Calcula la media de tonalidades
                int med=(c1.getRed()+c1.getGreen()+c1.getBlue())/3;
                //Almacena el color en la imagen destino
                bi.setRGB(x, y, new Color(med,med,med).getRGB());
            }
        }
        return bi;
    }
    
    public static Image binarizacion(Image imagen, int u){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        for(int j = 0 ; j< bi.getWidth();j++){
            for(int m = 0 ; m < bi.getHeight();m++){
                color = new Color(bi.getRGB(j, m));
                double v = (color.getRed()+color.getGreen()+color.getBlue())/3;
                if(v>=u){
                    bi.setRGB(j, m,new Color(0,0,0).getRGB());
                }else{
                    bi.setRGB(j, m,new Color(255,255,255).getRGB());
                }
            }
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image generarRuidoBN(Image img, int b, int n){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(img);
        int rx1=0,rx2=0,ry1=0,ry2=0,aux1=0,aux2=0;
        int area = bi.getWidth()*bi.getHeight();
        do{
            rx1 = (int)(Math.random()*bi.getWidth());
            ry1 = (int)(Math.random()*bi.getHeight());
            bi.setRGB(rx1, ry1,Color.WHITE.getRGB());
            aux1++;
        }while(aux1<(int)((b*area)/100));
        do{
            rx2 = (int)(Math.random()*bi.getWidth());
            ry2 = (int)(Math.random()*bi.getHeight());
            bi.setRGB(rx2, ry2,Color.BLACK.getRGB());
            aux2++;
        }while(aux2<(int)((n*area)/100)); 
        
        return herramientas.HerramientasImagen.toImage(bi);
    }
}
