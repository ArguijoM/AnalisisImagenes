/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import espacial.Histograma;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Manuel
 */
public class JInternalFrameExpansionLog extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameExpansionExp
     */
    private Image imagenOriginal;
    private JInternalFrameImagen internal;
    private Image imagenEditada;
    public JInternalFrameExpansionLog(JInternalFrameImagen internal) {
        initComponents();
        this.internal = internal;
        this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        setClosable(true);
        jSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int c = jSlider1.getValue();
                Image img = espacial.EspacialUno.ExpansionLogaritmica(imagenOriginal, c);
                imagenEditada=img;
                internal.setImagen(img);
            }
        });
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Histograma h = new Histograma(imagenEditada);
                h.calcularHistogramas();
            }
        });
    }
    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();

        jButton1.setText("Calcular");

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(255);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
