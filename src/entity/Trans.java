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
public class Trans {
    private String kode,ke,ket,pelaku;
    private Date tgl;
    private Time jam;
    private long jum;

    public Trans(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from trans where kode=?");ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            ke=rs.getString("ke");
            ket=rs.getString("ket");
            tgl=rs.getDate("tgl");
            jam=rs.getTime("jam");
            jum=rs.getLong("jum");
            pelaku=rs.getString("pelaku");
        }rs.close();ps.close();
    }

    public Trans(String kode, String ke, String ket, Date tgl, Time jam, long jum,String p) {
        this.kode = kode;
        this.ke = ke;
        this.ket = ket;
        this.tgl = tgl;
        this.jam = jam;
        this.jum = jum;pelaku=p;
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

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
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

    public long getJum() {
        return jum;
    }

    public void setJum(long jum) {
        this.jum = jum;
    }

    public String getPelaku() {
        return pelaku;
    }

    public void setPelaku(String pelaku) {
        this.pelaku = pelaku;
    }
}