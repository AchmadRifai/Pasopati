/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akutansi;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ai
 */
public class Akutansi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new com.jtattoo.plaf.mcwin.McWinLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    util.db.hindar(ex);
                }java.io.File f=new java.io.File(System.getProperty("user.home")+"/.akutansi/config.oke");
                if(!f.exists())new Start().setVisible(true);
            }
        });
    }
    
}
