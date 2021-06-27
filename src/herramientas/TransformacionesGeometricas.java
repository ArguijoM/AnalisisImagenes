/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import gui.FFTJFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Manuel
 */
public class TransformacionesGeometricas {

    public void translacion(Image imagenOriginal, int traslationX, int traslationY) {
        BufferedImage bi = HerramientasImagen.toBufferedImage(imagenOriginal);
        BufferedImage fondo = generarFondo();

        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {
                fondo.setRGB(i, j, bi.getRGB(i, j));
            }
        }
        mostrarImagen(fondo, "Imagen original");
        BufferedImage fondo2 = generarFondo();

        for (int y = 0; y < bi.getHeight(); y++) {
            for (int x = 0; x < bi.getWidth(); x++) {
                int newX = 0;
                int newY = 0;
                if (traslationX < 0) {
                    newX = Math.abs(traslationX) + (x + traslationX);
                } else {
                    newX = x + traslationX;
                }
                if (traslationY < 0) {
                    newY = Math.abs(traslationY) + (y + traslationY);
                } else {
                    newY = y + traslationY;
                }
                //traslatedImage.setGrayToneAt(newX, newY, sourceImage.getGrayToneAt(x, y));
                fondo2.setRGB(newX, newY, bi.getRGB(x, y));
                //fondo.setRGB(x, y, x);
            }
        }
        mostrarImagen(fondo2, "Imagen Nueva");
    }

    public void rotacion(Image imagenOriginal, double angleDegrees) {
        BufferedImage bi = HerramientasImagen.toBufferedImage(imagenOriginal);
        BufferedImage fondo = generarFondo();

        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {
                fondo.setRGB(i, j, bi.getRGB(i, j));
            }
        }
        mostrarImagen(fondo, "Imagen original");

        int max = 0;
        if (bi.getHeight() > bi.getWidth()) {
            max = bi.getHeight();
        } else if (bi.getHeight() < bi.getWidth()) {
            max = bi.getWidth();
        } else if (bi.getHeight() == bi.getWidth()) {
            max = bi.getHeight();
        }
        BufferedImage bi2 = new BufferedImage(max * 5, max * 5,BufferedImage.TYPE_INT_RGB);
        int newOriginX = (int) bi.getWidth() * 3;
        int newOriginY = (int) bi.getHeight() * 3;
        double radians = Math.toRadians(-1 * angleDegrees);

        for (int y = 0; y < bi.getHeight(); y++) {
            for (int x = 0; x < bi.getWidth(); x++) {
                int newPositionX = (int) ((x * Math.cos(radians) - y * Math.sin(radians)) + newOriginX);
                int newPositionY = (int) ((x * Math.sin(radians) + y * Math.cos(radians)) + newOriginY);
                bi2.setRGB(newPositionX, newPositionY, bi.getRGB(x, y));
                //rotatedImage.setGrayToneAt(newPositionX, newPositionY, bi.getGrayToneAt(x, y));
            }
        }
        BufferedImage fondo2 = generarFondo();
        for (int i = 0; i < bi2.getHeight(); i++) {
            for (int j = 0; j < bi2.getWidth(); j++) {
                Color c1 = new Color(bi2.getRGB(i, j));
                int prom = (c1.getRed() + c1.getBlue() + c1.getGreen()) / 3;
                if (prom != 0) {
                    fondo2.setRGB(i, j, bi2.getRGB(i, j));
                }
                
            }
        }
        mostrarImagen(fondo2, "Imagen Nueva");

    }

    public void escala(Image imagenOriginal, double zoomX, double zoomY) {
        BufferedImage bi = HerramientasImagen.toBufferedImage(imagenOriginal);
        BufferedImage fondo = generarFondo();

        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {
                fondo.setRGB(i, j, bi.getRGB(i, j));
            }
        }
        mostrarImagen(fondo, "Imagen original");

        int newCols = (int) (bi.getWidth() * zoomX);
        int newRows = (int) (bi.getHeight() * zoomY);

        BufferedImage bi2 = new BufferedImage(newCols, newRows, BufferedImage.TYPE_INT_RGB);
        if ((zoomX >= 1) && (zoomY >= 1)) {
            for (int y = 0; y < bi.getHeight(); y++) {
                for (int x = 0; x < bi.getWidth(); x++) {
                    for (int y1 = 0; y1 < (int) zoomY; y1++) {
                        for (int x1 = 0; x1 < (int) zoomX; x1++) {
                            bi2.setRGB((int) (x * zoomX) + x1, (int) (y * zoomY) + y1, bi.getRGB(x, y));
                        }
                    }
                }
            }
        } else if ((zoomX < 1) && (zoomY < 1)) {
            int intervalX = (int) Math.rint((double) bi.getWidth() / (double) (bi.getWidth() - bi2.getWidth()));
            int intervalY = (int) Math.rint((double) bi.getHeight() / (double) (bi.getHeight() - bi2.getHeight()));
            int cX = 0;
            int cY = 0;

            for (int y = 0; y < bi2.getHeight(); y++) {
                for (int x = 0; x < bi2.getWidth(); x++) {
                    bi2.setRGB(x, y, bi.getRGB(x * intervalX, y * intervalY));
                }
            }
        }

        BufferedImage fondo2 = generarFondo();
        for (int i = 0; i < bi2.getHeight(); i++) {
            for (int j = 0; j < bi2.getWidth(); j++) {
                fondo2.setRGB(i, j, bi2.getRGB(i, j));
            }
        }
        mostrarImagen(fondo2, "Imagen Nueva");

    }

    public void mostrarImagen(BufferedImage img, String titulo) {
        FFTJFrame frame = new FFTJFrame(HerramientasImagen.toImage(img));
        frame.setTitle(titulo);
        frame.setVisible(true);
    }

    public static BufferedImage generarFondo() {
        BufferedImage bi = new BufferedImage(1500, 1500, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {
                bi.setRGB(i, j, new Color(200, 200, 200).getRGB());
            }
        }
        return bi;
    }
}
