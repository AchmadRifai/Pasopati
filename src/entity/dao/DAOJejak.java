/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Jejak;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOJejak implements DAO<entity.Jejak>{
    private util.db d;
    public DAOJejak(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table jejak("
                + "akun text not null,"
                + "keg text not null,"
                + "tgl date not null,"
                + "jam time not null,"
                + "dari text not null"
                + ")");
        d.masuk("alter table jejak add foreign key(akun)references akun(akun)on update cascade on delete cascade");
    }

    @Override
    public void insert(Jejak v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into jejak values(?,?,?,?,?)");
        ps.setString(1, v.getAkun());
        ps.setString(2, v.getKeg());
        ps.setDate(3, v.getTgl());
        ps.setTime(4, v.getJam());
        ps.setString(5, v.getIp());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Jejak w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from jejak where akun=? and keg=? and tgl=? and jam=? and ip=?");
        ps.setString(1, w.getAkun());
        ps.setString(2, w.getKeg());
        ps.setDate(3, w.getTgl());
        ps.setTime(4, w.getJam());
        ps.setString(5, w.getIp());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Jejak a, Jejak b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update jejak set akun=?,keg=?,tgl=?,jam=?,ip=? where akun=? and keg=? and tgl=? and jam=? and ip=?");
        ps.setString(1, b.getAkun());
        ps.setString(2, b.getKeg());
        ps.setDate(3, b.getTgl());
        ps.setTime(4, b.getJam());
        ps.setString(5, b.getIp());
        ps.setString(6, a.getAkun());
        ps.setString(7, a.getKeg());
        ps.setDate(8, a.getTgl());
        ps.setTime(9, a.getJam());
        ps.setString(10, a.getIp());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Jejak> getData() throws SQLException {
        ArrayList<Jejak>a=new ArrayList<Jejak>();
        java.sql.ResultSet rs=d.keluar("select*from jejak");
        while(rs.next())a.add(new Jejak(rs.getString("akun"),rs.getString("keg"),rs.getDate("tgl"),rs.getTime("jam"),rs.getString("ip")));
        rs.close();
        return a;
    }
}