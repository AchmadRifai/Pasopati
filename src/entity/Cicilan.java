/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author ai
 */
public class Cicilan {
    private String kode,piutang,akun;
    private long jum;
    private Date tgl;
    private Time jam;
    private boolean lunas;

    public Cicilan(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from cicilan where kode=?");ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            piutang=rs.getString("piutang");
            jum=rs.getLong("jum");
            tgl=rs.getDate("tgl");
            jam=rs.getTime("jam");
            akun=rs.getString("akun");
            lunas=rs.getBoolean("lunas");
        }rs.close();ps.close();
    }

    public Cicilan(String kode, String piutang, long jum, Date tgl, Time jam,String a,boolean l) {
        this.kode = kode;lunas=l;
        this.piutang = piutang;
        this.jum = jum;
        this.tgl = tgl;
        this.jam = jam;akun=a;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPiutang() {
        return piutang;
    }

    public void setPiutang(String piutang) {
        this.piutang = piutang;
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

    public Time getJam() {
        return jam;
    }

    public void setJam(Time jam) {
        this.jam = jam;
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
}