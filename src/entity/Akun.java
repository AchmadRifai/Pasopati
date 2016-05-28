/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Akun {
    private String akun,pass,nama,alamat,jk;
    private boolean role,deleted,blocked,sesi;

    public Akun(String akun,util.db d) throws SQLException {
        this.akun = akun;
        java.sql.PreparedStatement ps=d.getPS("select*from akun where akun=?");ps.setString(1, akun);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            pass=rs.getString("pass");
            nama=rs.getString("nama");
            alamat=rs.getString("alamat");
            jk=rs.getString("jk");
            role=rs.getBoolean("role");
            deleted=rs.getBoolean("deleted");
            blocked=rs.getBoolean("blocked");
            sesi=rs.getBoolean("sesi");
        }rs.close();ps.close();
    }

    public Akun(String akun, String pass, String nama, String alamat, String jk, boolean role, boolean deleted, boolean blocked, boolean sesi) {
        this.akun = akun;
        this.pass = pass;
        this.nama = nama;
        this.alamat = alamat;
        this.jk = jk;
        this.role = role;
        this.deleted = deleted;
        this.blocked = blocked;
        this.sesi = sesi;
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isSesi() {
        return sesi;
    }

    public void setSesi(boolean sesi) {
        this.sesi = sesi;
    }
}