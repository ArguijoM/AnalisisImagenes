/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;
import espacial.Histograma;

import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameBinario2U;
import gui.JInternalFrameFiltro;
import gui.JInternalFrameIluminacion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }
    
}
