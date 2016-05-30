/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Menyicil;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOMenyicil implements DAO<Menyicil>{
    private util.db d;
    public DAOMenyicil(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table menyicil("
                + "kode text primary key,"
                + "hutang text not null,"
                + "sumber text not null,"
                + "tgl date not null,"
                + "jam time not null,"
                + "jum bigint not null"
                + ")");
        d.masuk("alter table menyicil add foreign key(hutang)references hutang(kode)on update cascade on delete cascade");
        d.masuk("alter table menyicil add foreign key(sumber)references aset(kode)on update cascade on delete cascade");
    }

    @Override
    public void insert(Menyicil v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into menyicil values(?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getHutang());
        ps.setString(3, v.getSumber());
        ps.setDate(4, v.getTgl());
        ps.setTime(5, v.getJam());
        ps.setLong(6, v.getJum());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Menyicil w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from menyicil where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Menyicil a, Menyicil b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update menyicil set hutang=?,sumber=?,tgl=?,jam=?,jum=? where kode=?");
        ps.setString(1, b.getHutang());
        ps.setString(2, b.getSumber());
        ps.setDate(3, b.getTgl());
        ps.setTime(4, b.getJam());
        ps.setLong(5, b.getJum());
        ps.setString(6, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Menyicil> getData() throws SQLException {
        ArrayList<Menyicil>a=new ArrayList();
        java.sql.ResultSet rs=d.keluar("select kode from menyicil");
        while(rs.next())a.add(new Menyicil(rs.getString("kode"), d));
        rs.close();
        return a;
    }
}