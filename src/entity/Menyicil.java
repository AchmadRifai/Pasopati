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
public class Menyicil {
    private String kode,hutang,sumber;
    private Date tgl;
    private Time jam;
    private long jum;

    public Menyicil(String kode,util.db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from menyicil where kode=?");ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();if(rs.next()){
            hutang=rs.getString("hutang");
            sumber=rs.getString("sumber");
            tgl=rs.getDate("tgl");
            jam=rs.getTime("jam");
            jum=rs.getLong("jum");
        }rs.close();ps.close();
    }

    public Menyicil(String kode, String hutang, String sumber, Date tgl, Time jam,long j) {
        this.kode = kode;
        this.hutang = hutang;
        this.sumber = sumber;jum=j;
        this.tgl = tgl;
        this.jam = jam;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getHutang() {
        return hutang;
    }

    public void setHutang(String hutang) {
        this.hutang = hutang;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
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
}