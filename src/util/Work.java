/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Work {
    public static void saveConfig(String host, int port, String name, String user, String pass) throws FileNotFoundException {
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.akutansi/config.oke");
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        java.io.PrintWriter o=new java.io.PrintWriter(f);
        o.println(host);
        o.println(port);
        o.println(name);
        o.println(user);
        o.print(pass);
        o.close();
    }

    public static db currentDB() throws FileNotFoundException, SQLException {
        db d=null;
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.akutansi/config.oke");if(f.exists()){
            java.util.ArrayList<String>a=new java.util.ArrayList<String>();
            java.util.Scanner i=new java.util.Scanner(f);
            while(i.hasNextLine())a.add(i.nextLine());
            d=new util.db(a.get(0), Integer.parseInt(a.get(1)), a.get(2), a.get(3), a.get(4));
        }return d;
    }
}