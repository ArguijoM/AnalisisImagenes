/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author working
 */
public class JInternalFrameImagen extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameImagen
     */
    private Image imagenOriginal;
    public JInternalFrameImagen(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        initComponents();
        // establecer la imagen en la etiqueta
        this.jLabelImagen.setIcon(new ImageIcon(imagenOriginal));
        this.setSize(imagenOriginal.getWidth(null),imagenOriginal.getHeight(null)); 
        setClosable(true);
    }

    public void setClosable(boolean closable) {
        this.closable = closable;
    }
    public void setImagen(Image imagenNueva){
        this.imagenOriginal = imagenNueva;
        this.jLabelImagen.setIcon(new ImageIcon(imagenNueva));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 230, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelImagen)
                .addGap(0, 627, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelImagen)
                .addGap(0, 424, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagen;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the imagenOriginal
     */
    public Image getImagenOriginal() {
        return imagenOriginal;
    }
}
