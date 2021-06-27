/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;
import FFT.Gestor;
import FFT.Gestor2;
import FFT.HerramientasColor;
import FFT.NumeroComplejo;
import Filtros.*;
import espacial.EspacialUno;
import espacial.Histograma;

import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameBinario2U;
import gui.JInternalFrameConvolucion3x3;
import gui.JInternalFrameConvolucion5x5;
import gui.JInternalFrameEcualizacion;
import gui.JInternalFrameExpansionExp;
import gui.JInternalFrameExpansionLineal;
import gui.JInternalFrameExpansionLog;
import gui.JInternalFrameFiltro;
import gui.JInternalFrameIluminacion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import gui.JInternalFrameRuido;
import herramientas.HerramientasImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JMenuItem;

/**
 *
 * @author working
 */
public class ModificarImagenListener implements ActionListener{
    
     
    private  JFramePrincipal framePrincipal;

    public ModificarImagenListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if (item.getText().equals("Modificar Pixeles")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameModificar internalNuevo = new JInternalFrameModificar(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        if(item.getText().equals("Filtros")){
            JInternalFrameImagen internal2 = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameFiltro internalNuevo2 = new JInternalFrameFiltro(internal2);
            internalNuevo2.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
        }
         if(item.getText().equals("Binario")){
            JInternalFrameImagen internal3 = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameBinario internalNuevo3 = new JInternalFrameBinario(internal3);
            internalNuevo3.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo3);
        }
         if(item.getText().equals("Binario con 2 umbrales")){
            JInternalFrameImagen internal3 = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameBinario2U internalNuevo3 = new JInternalFrameBinario2U(internal3);
            internalNuevo3.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo3);
        }
        if(item.getText().equals("Histograma")){
            JInternalFrameImagen internal4 = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Histograma histograma = new Histograma(internal4.getImagenOriginal());
            histograma.calcularHistogramas();
        }
        if(item.getText().equals("Iluminacion")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            JInternalFrameIluminacion internalNuevo = new JInternalFrameIluminacion(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
        if(item.getText().equals("Lineal")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            JInternalFrameExpansionLineal internalNuevo = new JInternalFrameExpansionLineal(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
        if(item.getText().equals("Exponencial")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            JInternalFrameExpansionExp internalNuevo = new JInternalFrameExpansionExp(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
        if(item.getText().equals("Logaritmica")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            JInternalFrameExpansionLog internalNuevo = new JInternalFrameExpansionLog(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
        if(item.getText().equals("Ecualizacion")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            Image img = espacial.EspacialUno.Ecualizacion(internal.getImagenOriginal());
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(img);
            internalNuevo.setImagen(img);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
        if(item.getText().equals("3x3")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            JInternalFrameConvolucion3x3 internalNuevo = new JInternalFrameConvolucion3x3(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
         if(item.getText().equals("5x5")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
             JInternalFrameConvolucion5x5 internalNuevo = new JInternalFrameConvolucion5x5(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
         if(item.getText().equals("Ruido")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal     
            JInternalFrameRuido internalNuevo = new JInternalFrameRuido(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            
        }
        if(item.getText().equals("Imagen de frecuencia")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image imagen = internal.getImagenOriginal();
            Image grises = EspacialUno.convertirAGrises(imagen);
            JInternalFrameImagen imagenGrises = new JInternalFrameImagen(grises);
            imagenGrises.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(imagenGrises);
           
            BufferedImage bImage = HerramientasImagen.toBufferedImage(grises);
            Gestor gestor = new Gestor();
            NumeroComplejo[][] imagenOriginal = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.ROJO);
            BufferedImage biRes = gestor.obtenerImagenFrecuencias(imagenOriginal, bImage.getWidth(),
                 bImage.getHeight(), true);
            Image iRes = herramientas.HerramientasImagen.toImage(biRes);
            JInternalFrameImagen imagenFrecuencia = new JInternalFrameImagen(iRes);
            imagenFrecuencia.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(imagenFrecuencia);
            
            Gestor2 gestor2 = new Gestor2(HerramientasImagen.toBufferedImage(imagen));
            BufferedImage iFre = gestor2.obtenerImagenFrecuencias(true);
            
           //FiltroButterworthyPasaAltas fipb = new FiltroButterworthyPasaAltas(10, new Dimension(bImage.getHeight(), bImage.getWidth()), 10);
           FiltroButterworthyPasaBajas fipb = new FiltroButterworthyPasaBajas(10, new Dimension(bImage.getHeight(), bImage.getWidth()), 2);
           //FiltroIdealPasaAltas fipb = new FiltroIdealPasaAltas(15, new Dimension(bImage.getHeight(), bImage.getWidth()));
           //FiltroIdealPasaBajas fipb = new FiltroIdealPasaBajas(50,new Dimension(bImage.getHeight(), bImage.getWidth()));
            fipb.crearFiltro();
            NumeroComplejo [][] filtro = fipb.getFiltroEspacial();
            gestor2.aplicarFiltro(filtro);
            JInternalFrameImagen imagenFiltro = new JInternalFrameImagen(fipb.getImagen());
            imagenFiltro.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(imagenFiltro);
            
            BufferedImage imagenEspacial = gestor2.obtenerImagenEspacial();
            JInternalFrameImagen imagenResultado = new JInternalFrameImagen(HerramientasImagen.toImage(imagenEspacial));
            imagenResultado.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(imagenResultado);
            
        }
    }
    
}
