/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Trans;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOTrans implements DAO<Trans>{
    private util.db d;

    public DAOTrans(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table trans("
                + "kode text primary key,"
                + "pelaku text not null,"
                + "ke text not null,"
                + "tgl date not null,"
                + "jam time not null,"
                + "jum bigint not null,"
                + "ket text not null"
                + ")");
        d.masuk("alter table trans add foreign key(ke)references aset(kode)on update cascade on delete cascade");
        d.masuk("alter table trans add foreign key(pelaku)references akun(akun)on update cascade on delete cascade");
    }

    @Override
    public void insert(Trans v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into trans values(?,?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getPelaku());
        ps.setString(3, v.getKe());
        ps.setDate(4, v.getTgl());
        ps.setTime(5, v.getJam());
        ps.setLong(6, v.getJum());
        ps.setString(7, v.getKet());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Trans w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from trans where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Trans a, Trans b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update trans set pelaku=?,ke=?,tgl=?,jam=?,jum=?,ket=? where kode=?");
        ps.setString(1, b.getPelaku());
        ps.setString(2, b.getKe());
        ps.setDate(3, b.getTgl());
        ps.setTime(4, b.getJam());
        ps.setLong(5, b.getJum());
        ps.setString(6, b.getKet());
        ps.setString(7, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Trans> getData() throws SQLException {
        ArrayList<Trans>a=new ArrayList();
        java.sql.ResultSet rs=d.keluar("select kode from trans");
        while(rs.next())a.add(new Trans(rs.getString("kode"), d));
        rs.close();
        return a;
    }
}