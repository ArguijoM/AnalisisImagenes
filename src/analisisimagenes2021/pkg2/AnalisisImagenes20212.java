/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes2021.pkg2;

import FFT.Gestor;
import FFT.Gestor2;
import FFT.HerramientasColor;
import FFT.NumeroComplejo;
import Filtros.*;
import espacial.EspacialUno;
import gui.FFTJFrame;
import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import org.w3c.dom.css.RGBColor;
import herramientas.*;

/**
 *
 * @author working
 */
public class AnalisisImagenes20212 {

    public static Color n = new Color(0, 0, 0);
    public static Color g = new Color(200, 200, 200);
    public static Color b = new Color(255, 255, 255);
    public static int tam = 750;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        //OBTENER LA IMAGEN ORIGINAL EN TONOS DE GRISES
        Image imagen = herramientas.HerramientasImagen.abrirImagen();
        Image nuevaI = herramientas.HerramientasImagen.grises(HerramientasImagen.toBufferedImage(imagen));
//        Image bin = HerramientasImagen.binarizacion(imagen, 126);
//        BufferedImage bio = HerramientasImagen.toBufferedImage(bin);
//        FFTJFrame frame2 = new FFTJFrame(bin);
//        frame2.setVisible(true);
//
//        BufferedImage fondo = generarPlano();
//        BufferedImage bNuevo = generarPlano();
//
//        for (int i = 0; i < bio.getHeight(); i++) {
//            for (int j = 0; j < bio.getWidth(); j++) {
//                fondo.setRGB(i, j, bio.getRGB(i, j));
//            }
//        }
//        FFTJFrame frame = new FFTJFrame(HerramientasImagen.toImage(fondo));
//        frame.setTitle("Fondo");
//        frame.setVisible(true);
//
//        for (int i = 0; i < bio.getHeight(); i++) {
//            for (int j = 0; j < bio.getWidth(); j++) {
//                bNuevo.setRGB(i, j, bio.getRGB(i, j));
//            }
//        }
//
//        int c = -100;
//        for (int i = 0; i < bio.getHeight(); i++) {
//            for (int j = 0; j < bio.getWidth(); j++) {
//                Color c1 = new Color(fondo.getRGB(i, j));
//                int prom = (c1.getRed() + c1.getBlue() + c1.getGreen()) / 3;
//                if (prom == 255) {
//                    bNuevo.setRGB(i + c, j + c, b.getRGB());
//                    bNuevo.setRGB(i, j, n.getRGB());
//                }
//            }
//        }
//        FFTJFrame frame3 = new FFTJFrame(HerramientasImagen.toImage(bNuevo));
//        frame3.setTitle("Fondo Nuevo");
//        frame3.setVisible(true);
        TransformacionesGeometricas t = new TransformacionesGeometricas();
        t.escala(nuevaI, 2, 2);


    }

    public static BufferedImage generarPlano() {
        BufferedImage fondo = new BufferedImage(tam, tam, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < fondo.getHeight(); i++) {
            for (int j = 0; j < fondo.getWidth(); j++) {
                fondo.setRGB(i, j, g.getRGB());
            }
        }
        return fondo;
    }

}
