/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ai
 */
public class Jejak {
    private String akun,keg;
    private Date tgl;
    private Time jam;
    private String ip;

    public Jejak(String akun, String keg, Date tgl, Time jam, String ip) {
        this.akun = akun;
        this.keg = keg;
        this.tgl = tgl;
        this.jam = jam;
        this.ip = ip;
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public String getKeg() {
        return keg;
    }

    public void setKeg(String keg) {
        this.keg = keg;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}