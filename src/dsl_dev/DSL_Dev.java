/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsl_dev;

/**
 *
 * @author Ana
 */
import View.Index;
import javax.swing.JFrame;
public class DSL_Dev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Index minhaAplicacao;
        minhaAplicacao = new Index();
        //minhaAplicacao.setVisible(true);
        minhaAplicacao.setExtendedState(JFrame.MAXIMIZED_BOTH);
        minhaAplicacao.setVisible(true);
    }
    
}
