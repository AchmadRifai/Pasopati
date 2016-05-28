/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Aset;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOAset implements DAO<entity.Aset>{
    private util.db d;
    public DAOAset(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table aset("
                + "kode text primary key,"
                + "ket text not null,"
                + "jum bigint not null,"
                + "tipe text not null check(tipe in('lancar','tetap'))"
                + ")");
    }

    @Override
    public void insert(Aset v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into aset values(?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getKet());
        ps.setLong(3, v.getJum());
        ps.setString(4, v.getTipe());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Aset w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from aset where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Aset a, Aset b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update aset set ket=?,jum=?,tipe=? where kode=?");
        ps.setString(1, b.getKet());
        ps.setString(3, b.getTipe());
        ps.setLong(2, b.getJum());
        ps.setString(4, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Aset> getData() throws SQLException {
        ArrayList<Aset>a=new ArrayList<Aset>();
        java.sql.ResultSet rs=d.keluar("select kode from aset");
        while(rs.next())a.add(new Aset(rs.getString("kode"),d));
        rs.close();
        return a;
    }
}