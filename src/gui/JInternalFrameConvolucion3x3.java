/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import espacial.Convolucion;
import espacial.MascarasBordes;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manuel
 */
public class JInternalFrameConvolucion3x3 extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameConvolucion
     */
    private Image imagenOriginal;
    private Image imagen;
    private Image imagenNueva;
    public JInternalFrameConvolucion3x3(JInternalFrameImagen internal) {
        initComponents();
        this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        this.imagen = internal.getImagenOriginal();
        setClosable(true);
        
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(jComboBox1.getSelectedItem().toString()){
                    case "Enfoque":
                        jSpinner1.setValue(0);jSpinner2.setValue(-1);jSpinner3.setValue(0);
                        jSpinner4.setValue(-1);jSpinner5.setValue(5);jSpinner6.setValue(-1);
                        jSpinner7.setValue(0);jSpinner8.setValue(-1);jSpinner9.setValue(0);
                    break;
                    case "Desenfoque":
                        jSpinner1.setValue(1);jSpinner2.setValue(1);jSpinner3.setValue(1);
                        jSpinner4.setValue(1);jSpinner5.setValue(1);jSpinner6.setValue(1);
                        jSpinner7.setValue(1);jSpinner8.setValue(1);jSpinner9.setValue(1);
                    break;
                    case "Realce de bordes":
                        jSpinner1.setValue(0);jSpinner2.setValue(0);jSpinner3.setValue(0);
                        jSpinner4.setValue(-1);jSpinner5.setValue(1);jSpinner6.setValue(0);
                        jSpinner7.setValue(0);jSpinner8.setValue(0);jSpinner9.setValue(0);
                    break;
                    case "Repujado":
                        jSpinner1.setValue(-2);jSpinner2.setValue(-1);jSpinner3.setValue(0);
                        jSpinner4.setValue(-1);jSpinner5.setValue(1);jSpinner6.setValue(1);
                        jSpinner7.setValue(0);jSpinner8.setValue(1);jSpinner9.setValue(2);
                    break;
                    case "Deteccion de bordes":
                        jSpinner1.setValue(0);jSpinner2.setValue(1);jSpinner3.setValue(0);
                        jSpinner4.setValue(1);jSpinner5.setValue(-4);jSpinner6.setValue(1);
                        jSpinner7.setValue(0);jSpinner8.setValue(1);jSpinner9.setValue(0);
                    break;
                    case "Filtro de tipo Sobel":
                        jSpinner1.setValue(-1);jSpinner2.setValue(0);jSpinner3.setValue(1);
                        jSpinner4.setValue(-2);jSpinner5.setValue(0);jSpinner6.setValue(2);
                        jSpinner7.setValue(-1);jSpinner8.setValue(0);jSpinner9.setValue(1);
                    break;
                    case "Filtro de tipo Sharpen":
                        jSpinner1.setValue(1);jSpinner2.setValue(-2);jSpinner3.setValue(1);
                        jSpinner4.setValue(-2);jSpinner5.setValue(5);jSpinner6.setValue(-2);
                        jSpinner7.setValue(1);jSpinner8.setValue(-2);jSpinner9.setValue(1);
                    break;
                    case "Filtro Norte":
                        jSpinner1.setValue(1);jSpinner2.setValue(1);jSpinner3.setValue(1);
                        jSpinner4.setValue(1);jSpinner5.setValue(-2);jSpinner6.setValue(1);
                        jSpinner7.setValue(-1);jSpinner8.setValue(-1);jSpinner9.setValue(-1);
                    break;
                    case "Filtro Este ":
                        jSpinner1.setValue(-1);jSpinner2.setValue(1);jSpinner3.setValue(1);
                        jSpinner4.setValue(-1);jSpinner5.setValue(-2);jSpinner6.setValue(1);
                        jSpinner7.setValue(-1);jSpinner8.setValue(1);jSpinner9.setValue(1);
                    break;
                }
                
            }
        });
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Convolucion ce = new Convolucion(imagenOriginal);
                imagenNueva = ce.convolucion3x3(new int [][]{{(int)jSpinner1.getValue(),(int)jSpinner2.getValue(),(int)jSpinner3.getValue()},
                                                                {(int)jSpinner4.getValue(),(int)jSpinner5.getValue(),(int)jSpinner6.getValue()},
                                                                {(int)jSpinner7.getValue(),(int)jSpinner8.getValue(),(int)jSpinner9.getValue()}},
                                                                (int)jSpinner10.getValue(),(int)jSpinner11.getValue());
                internal.setImagen(imagenNueva);
            }
        });
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MascarasBordes mb = new MascarasBordes(imagenOriginal,(int)jSpinner10.getValue(),(int)jSpinner11.getValue());
                internal.setImagen(mb.getImg());
                
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
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jSpinner9 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jSpinner11 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jButton1.setText("Calcular");

        jLabel1.setText("Desfase: ");

        jLabel2.setText("Divisor: ");

        jSpinner11.setValue(1);

        jButton2.setText("Kirsch");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una máscara predeterminada.", "Enfoque", "Desenfoque", "Realce de bordes", "Repujado", "Deteccion de bordes", "Filtro de tipo Sobel", "Filtro de tipo Sharpen", "Filtro Norte", "Filtro Este " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(201, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSpinner7)
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinner10, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                            .addComponent(jSpinner11))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(jSpinner1))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSpinner5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(jSpinner6))))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    // End of variables declaration//GEN-END:variables
}
