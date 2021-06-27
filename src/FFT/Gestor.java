/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFT;

import espacial.Convolucion;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 *
 * @author Manuel
 */
public class Gestor {
    NumeroComplejo[][] transformada;

    public Gestor() {

    }

    public NumeroComplejo[][] obtenerDatosPorCanal(BufferedImage imagenOriginal, HerramientasColor.CanalColor color) {
        NumeroComplejo[][] aux = new NumeroComplejo[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
        // obtenemos los datos por canal
        for (int y = 0; y < imagenOriginal.getHeight(); y++) {
            for (int x = 0; x < imagenOriginal.getWidth(); x++) {
                aux[x][y] = new NumeroComplejo(HerramientasColor.obtenerValorPorCanal(imagenOriginal.getRGB(x, y), color), 0);
            }
        }
        return aux;
    }

    public BufferedImage obtenerImagenFrecuencias(NumeroComplejo[][] datosIO, int w, int h, boolean reAjustarCuadrante) {
        /// obtenemos las dimensiones
        int anchoImagen = w;
        int altoImagen = h;
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

         this.transformada = fft.calculateFT(datosIO, false);

        // crear la imagen del espectro 
        for (int y = 0; y < aux.getHeight(); y++) {
            for (int x = 0; x < aux.getWidth(); x++) {
                // modificamos la posicion de los cuadrantes 
                int ejeX = reAjustarCuadrante ? (x + (anchoImagen / 2)) % anchoImagen : x;
                int ejeY = reAjustarCuadrante ? (y + (altoImagen / 2)) % altoImagen : y;
                // setear la info a la imagen 
                // el que se ecuentre en la imagen 
                int color1 = aux.getRGB(x, y);
                int color2 = obtenerColorRealDeFrecuencia(ejeX, ejeY, transformada, HerramientasColor.CanalColor.ROJO);
                int rgb = HerramientasColor.acumularColor(color1, color2);
                aux.setRGB(x, y, rgb);

            }
        }

        return aux;
    }

    private int obtenerColorRealDeFrecuencia(int ejeX, int ejeY, NumeroComplejo[][] transformada, HerramientasColor.CanalColor canal) {
        int color = (int) Math.abs(transformada[ejeX][ejeY].getParteReal());
        color = espacial.EspacialUno.verificar(color);
        color = HerramientasColor.obtenerRGBPorCanal(color, canal);
        return color;
    }

    public void aplicarFiltro(NumeroComplejo[][] filtro, BufferedImage imagenOriginal, NumeroComplejo[][] frecuencia) {

        // recorrer el filtro 
        for (int x = 0; x < imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < imagenOriginal.getHeight(); y++) {
                // obtener el color el RGB de la parte de frecuencias
                if (filtro[x][y].getParteReal() < 1) {
                    int rgb = obtenerPixelDominioFrecuencias(x, y, true, imagenOriginal, frecuencia);
                    Color aux = new Color(rgb);
                    int r = (int) (aux.getRed() * filtro[x][y].getParteReal());
                    int g = (int) (aux.getGreen() * filtro[x][y].getParteReal());
                    int b = (int) (aux.getBlue() * filtro[x][y].getParteReal());
                    aux = new Color(r, g, b);
                    setPixelDominioFrecuencias(x, y, true, aux.getRGB(), imagenOriginal, frecuencia);
                }
            }
        }
    }

    private int obtenerPixelDominioFrecuencias(int x, int y, boolean encuadre, BufferedImage imagenOriginal, NumeroComplejo[][] aux) {
        /// obtenemos las dimensiones
        int anchoImagen = imagenOriginal.getWidth();
        int altoImagen = imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;

        // acumulamos 
        int valorColor = 0;
        for (HerramientasColor.CanalColor canal : HerramientasColor.CanalColor.values()) {
            //NumeroComplejo[][] aux = representacionFrecuencias.get(canal);
            valorColor += obtenerColorRealDeFrecuencia(ejeX, ejeY, aux, canal);
        }

        return valorColor;
    }

    private void setPixelDominioFrecuencias(int x, int y, boolean encuadre, int color, BufferedImage imagenOriginal, NumeroComplejo[][] aux) {
        /// obtenemos las dimensiones
        int anchoImagen = imagenOriginal.getWidth();
        int altoImagen = imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;

        // recorrer por canal de color 
        for (HerramientasColor.CanalColor canal : HerramientasColor.CanalColor.values()) {
            //NumeroComplejo[][] datos = representacionFrecuencias.get(canal);
            int nuevo = HerramientasColor.obtenerValorPorCanal(color, canal);

            aux[ejeX][ejeY] = new NumeroComplejo(nuevo, nuevo);

        }

    }
     public BufferedImage obtenerImagenEspacial() {
        /// obtenemos las dimensiones
        int anchoImagen = this.transformada.length;
        int altoImagen = this.transformada.length;
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

            NumeroComplejo[][] transformadaInv = fft.calculateFT(this.transformada, true);
           
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {

                    int color = (int) Math.abs(transformadaInv[x][y].getParteReal());
                    color = espacial.EspacialUno.verificar(color);
                    color = HerramientasColor.obtenerRGBPorCanal(color, HerramientasColor.CanalColor.ROJO);

                    int rgb = HerramientasColor.acumularColor(aux.getRGB(x, y), color);
                    aux.setRGB(x, y, rgb);
                }
            }
       
        return aux;

    }
}
