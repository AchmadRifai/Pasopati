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
public class Hutang {
    private String kode,ke;
    private long jum;
    private Date tgl;
    private String ket,aset,akun;
    private boolean lunas;
    private float bunga;

    public Hutang(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from hutang where kode=?");ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            ke=rs.getString("ke");
            jum=rs.getLong("jum");
            tgl=rs.getDate("tgl");
            ket=rs.getString("ket");
            aset=rs.getString("aset");
            akun=rs.getString("akun");
            lunas=rs.getBoolean("lunas");
            bunga=rs.getFloat("bunga");
        }rs.close();ps.close();
    }

    public Hutang(String kode, String ke, long jum, Date tgl, String ket, String aset, String akun,boolean l,float b) {
        this.kode = kode;bunga=b;
        this.ke = ke;
        this.jum = jum;lunas=l;
        this.tgl = tgl;
        this.ket = ket;
        this.aset = aset;
        this.akun = akun;
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

    public long getJum() {
        return jum;
    }

    public void setJum(long jum) {
        this.jum = jum;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getAset() {
        return aset;
    }

    public void setAset(String aset) {
        this.aset = aset;
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public boolean isLunas() {
        return lunas;
    }

    public void setLunas(boolean lunas) {
        this.lunas = lunas;
    }

    public float getBunga() {
        return bunga;
    }

    public void setBunga(float bunga) {
        this.bunga = bunga;
    }
}