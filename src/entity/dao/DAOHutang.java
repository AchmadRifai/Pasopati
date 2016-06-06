/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Hutang;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOHutang implements DAO<Hutang>{
    private util.db d;
    public DAOHutang(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table hutang("
                + "kode text primary key,"
                + "ke text not null,"
                + "akun text not null,"
                + "aset text not null,"
                + "jum bigint not null,"
                + "tgl date not null,"
                + "ket text not null,"
                + "lunas boolean not null,"
                + "bunga float not null"
                + ")");
        d.masuk("alter table hutang add foreign key(akun)references akun(akun)on update cascade on delete cascade");
        d.masuk("alter table hutang add foreign key(aset)references aset(kode)on update cascade on delete cascade");
    }

    @Override
    public void insert(Hutang v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into hutang values(?,?,?,?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getKe());
        ps.setString(3, v.getAkun());
        ps.setString(4, v.getAset());
        ps.setLong(5, v.getJum());
        ps.setDate(6, v.getTgl());
        ps.setString(7, v.getKet());
        ps.setBoolean(8, v.isLunas());
        ps.setFloat(9, v.getBunga());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Hutang w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from hutang where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Hutang a, Hutang b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update hutang set ke=?,akun=?,aset=?,jum=?,tgl=?,ket=?,bunga=?,lunas=? where kode=?");
        ps.setString(1, b.getKe());
        ps.setString(2, b.getAkun());
        ps.setString(3, b.getAset());
        ps.setLong(4, b.getJum());
        ps.setDate(5, b.getTgl());
        ps.setString(6, b.getKet());
        ps.setFloat(7, b.getBunga());
        ps.setBoolean(8, b.isLunas());
        ps.setString(9, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Hutang> getData() throws SQLException {
        ArrayList<Hutang>a=new ArrayList();
        java.sql.ResultSet rs=d.keluar("select kode from hutang");
        while(rs.next())a.add(new entity.Hutang(rs.getString("kode"), d));
        rs.close();
        return a;
    }
}