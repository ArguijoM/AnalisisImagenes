/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import FFT.NumeroComplejo;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author Manuel
 */
public class FiltroIdealPasaBajas extends FiltroFrecuencia{

    private int radio;
    private Dimension dim;
    private Image imagen;
    
    public FiltroIdealPasaBajas(int radio, Dimension dim) {
        super((int)dim.getWidth(),(int) dim.getHeight());
        this.radio = radio;
        this.dim = dim;
        this.imagen = null;
    }
   
    @Override
    public void crearFiltro() {
       
    int tamanoImagen = (int)dim.getWidth();
    for(int i=0; i < tamanoImagen;i++){
        for(int j=0; j < tamanoImagen;j++){
            int u = -1*(tamanoImagen/2)+i;
            int v = (tamanoImagen/2)-j;
            
            double r = Math.sqrt(Math.pow(u,2)+Math.pow(v, 2));
            // verificamos con respecto al  radio
            if(r<=this.radio){
                // asignamos el valor al filtro
                getFiltroEspacial()[i][j] = new NumeroComplejo(1, 1);
            }  else {
            
               // asignamos el valor al filtro
               getFiltroEspacial()[i][j] = new NumeroComplejo(0, 0);
            
            }     
        }
    }    
    this.imagen = FiltroFrecuencia.toImageDeComplejo(super.getFiltroEspacial());
    }
    
    public void modificarFiltro(int radio){
      this.radio = radio;
      crearFiltro();
    }

    public Image getImagen() {
        return imagen;
    }
    
    
}
