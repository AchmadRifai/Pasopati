/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Piutang {
    private String kode,ke;
    private Date tgl;
    private long jum;
    private float bunga;
    private boolean lunas;

    public Piutang(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from piutang where kode=?");ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            ke=rs.getString("ke");
            tgl=rs.getDate("tgl");
            jum=rs.getLong("jum");
            bunga=rs.getFloat("bunga");
            lunas=rs.getBoolean("lunas");
        }rs.close();ps.close();
    }

    public Piutang(String kode, String ke, Date tgl, long jum, float bunga, boolean lunas) {
        this.kode = kode;
        this.ke = ke;
        this.tgl = tgl;
        this.jum = jum;
        this.bunga = bunga;
        this.lunas = lunas;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKe() {
        return ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public long getJum() {
        return jum;
    }

    public void setJum(long jum) {
        this.jum = jum;
    }

    public float getBunga() {
        return bunga;
    }

    public void setBunga(float bunga) {
        this.bunga = bunga;
    }

    public boolean isLunas() {
        return lunas;
    }

    public void setLunas(boolean lunas) {
        this.lunas = lunas;
    }
}