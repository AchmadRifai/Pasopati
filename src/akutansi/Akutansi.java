/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akutansi;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
                if(f.exists()){
                    java.io.File f1=new java.io.File(System.getProperty("user.home")+"/.akutansi/config.user");try {
                        if(f1.exists()){
                            entity.Akun a=util.Work.currentAccount(util.Work.currentDB());
                            if(a.isRole())new ui.Admin(util.Work.currentDB(), a).setVisible(true);
                        }else new ui.Login(util.Work.currentDB()).setVisible(true);
                    } catch (FileNotFoundException | SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        util.db.hindar(ex);
                    }
                }else new Start().setVisible(true);
            }
        });
    }
    
}
