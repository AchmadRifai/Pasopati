/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Akun;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOAkun implements DAO<entity.Akun>{
    private util.db d;

    public DAOAkun(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table akun("
                + "akun text primary key,"
                + "pass text not null,"
                + "nama text not null,"
                + "alamat text not null,"
                + "jk text not null check(jk in('pria','wanita')),"
                + "role boolean not null,"
                + "deleted boolean not null,"
                + "blocked boolean not null,"
                + "sesi boolean not null"
                + ")");
    }

    @Override
    public void insert(Akun v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into akun values(?,?,?,?,?,?,?,?,?)");
        ps.setString(1, v.getAkun());
        ps.setString(2, v.getPass());
        ps.setString(3, v.getNama());
        ps.setString(4, v.getAlamat());
        ps.setString(5, v.getJk());
        ps.setBoolean(6, v.isRole());
        ps.setBoolean(7, v.isDeleted());
        ps.setBoolean(8, v.isBlocked());
        ps.setBoolean(9, v.isSesi());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Akun w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update akun set deleted=? where akun=?");
        ps.setBoolean(1, true);
        ps.setString(2, w.getAkun());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Akun a, Akun b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update akun set pass=?,nama=?,alamat=?,jk=?,role=?,blocked=?,sesi=? where akun=?");
        ps.setString(1, b.getPass());
        ps.setString(2, b.getNama());
        ps.setString(3, b.getAlamat());
        ps.setString(4, b.getJk());
        ps.setBoolean(5, b.isRole());
        ps.setBoolean(6, b.isBlocked());
        ps.setBoolean(7, b.isSesi());
        ps.setString(8, a.getAkun());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Akun> getData() throws SQLException {
        ArrayList<Akun>a=new ArrayList<Akun>();
        java.sql.ResultSet rs=d.keluar("select akun from akun where not deleted");
        while(rs.next())a.add(new Akun(rs.getString("akun"),d));
        rs.close();
        return a;
    }
}