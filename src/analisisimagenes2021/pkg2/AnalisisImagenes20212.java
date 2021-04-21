/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes2021.pkg2;

import espacial.Histograma;
import herramientas.umbral;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author working
 */
public class AnalisisImagenes20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Image imgOscura=espacial.EspacialUno.modificarIluminacion(herramientas.HerramientasImagen.abrirImagen(), -60);
        for(int c=0;c<=255;c++){
            int r = (int)(Math.pow(1+10,c)/(1+10));
            System.out.println("R: "+r);
        }
        
    }
    
}
