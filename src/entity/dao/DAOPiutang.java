/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Piutang;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOPiutang implements DAO<Piutang>{
    private util.db d;
    public DAOPiutang(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table piutang("
                + "kode text primary key,"
                + "ke text not null,"
                + "tgl date not null,"
                + "jum bigint not null,"
                + "bunga float not null,"
                + "lunas boolean not null"
                + ")");
    }

    @Override
    public void insert(Piutang v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into piutang values(?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getKe());
        ps.setDate(3, v.getTgl());
        ps.setLong(4, v.getJum());
        ps.setFloat(5, v.getBunga());
        ps.setBoolean(6, v.isLunas());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Piutang w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update piutang set lunas=? where kode=?");
        ps.setBoolean(1, true);
        ps.setString(2, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Piutang a, Piutang b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update piutang set ke=?,tgl=?,jum=?,bunga=? where kode=?");
        ps.setString(1, b.getKe());
        ps.setDate(2, b.getTgl());
        ps.setLong(3, b.getJum());
        ps.setFloat(4, b.getBunga());
        ps.setString(5, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Piutang> getData() throws SQLException {
        ArrayList<Piutang>a=new ArrayList();
        java.sql.ResultSet rs=d.keluar("select kode from piutang where not lunas");
        while(rs.next())a.add(new entity.Piutang(rs.getString("kode"), d));
        rs.close();
        return a;
    }
}