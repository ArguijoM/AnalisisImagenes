/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Manuel
 */
public class MascarasBordes {
    // kirch
    private static int[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
    private static int[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
    private static int[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
    private static int[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
    private static int[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
    private static int[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
    private static int[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
    private static int[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
    private Image img;
    private Image imageOriginal;
    private int desfase,divisor;

    public MascarasBordes(Image imagenOriginal,int desfase,int divisor) {
        this.imageOriginal = imagenOriginal;
        this.desfase = desfase;
        this.divisor = divisor;
        mascarakirsch();
    }
    
    private void mascarakirsch(){
        Convolucion c = new Convolucion(imageOriginal);
        Image i1 = c.convolucion3x3(kirsch1, this.desfase, this.divisor);
        mascarakirsch1(i1);
    }

    private void mascarakirsch1(Image i1) {
       Convolucion c = new Convolucion(i1);
       Image i2 = c.convolucion3x3(kirsch2, this.desfase, this.divisor);
       mascarakirsch2(i2);
    }

    private void mascarakirsch2(Image i2) {
        Convolucion c = new Convolucion(i2);
        Image i3 = c.convolucion3x3(kirsch3, this.desfase, this.divisor);
        mascarakirsch3(i3);
    }

    private void mascarakirsch3(Image i3) {
       Convolucion c = new Convolucion(i3);
       Image i4 = c.convolucion3x3(kirsch4, this.desfase, this.divisor);
       mascarakirsch4(i4);
    }

    private void mascarakirsch4(Image i4) {
      Convolucion c = new Convolucion(i4);
      Image i5 = c.convolucion3x3(kirsch5, this.desfase, this.divisor);
      mascarakirsch5(i5);
    }

    private void mascarakirsch5(Image i5) {
       Convolucion c = new Convolucion(i5);
       Image i6 = c.convolucion3x3(kirsch6, this.desfase, this.divisor);
       mascarakirsch6(i6);
    }

    private void mascarakirsch6(Image i6) {
      Convolucion c = new Convolucion(i6);
      Image i7 = c.convolucion3x3(kirsch7, this.desfase, this.divisor);
      mascarakirsch7(i7);
    }

    private void mascarakirsch7(Image i7) {
       Convolucion c = new Convolucion(i7);
       this.img = c.convolucion3x3(kirsch8, this.desfase, this.divisor);
    }

    public Image getImg() {
        return img;
    }
   
    
}
