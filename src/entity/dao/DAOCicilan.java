/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Cicilan;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOCicilan implements DAO<Cicilan>{
    private util.db d;
    public DAOCicilan(util.db db){
        d=db;
    }

    @Override
    public void createTable() throws SQLException {
        d.masuk("create table cicilan("
                + "kode text primary key,"
                + "piutang text not null,"
                + "jum bigint not null,"
                + "tgl date not null,"
                + "jam time not null,"
                + "akun text not null,"
                + "lunas boolean not null"
                + ")");
        d.masuk("alter table cicilan add foreign key(piutang)references piutang(kode)on update cascade on delete cascade");
        d.masuk("alter table cicilan add foreign key(akun)references akun(akun)on update cascade on delete cascade");
    }

    @Override
    public void insert(Cicilan v) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("insert into cicilan values(?,?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getPiutang());
        ps.setLong(3, v.getJum());
        ps.setDate(4, v.getTgl());
        ps.setTime(5, v.getJam());
        ps.setString(6, v.getAkun());
        ps.setBoolean(7, v.isLunas());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Cicilan w) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("delete from cicilan where kode=?");
        ps.setString(1, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Cicilan a, Cicilan b) throws SQLException {
        java.sql.PreparedStatement ps=d.getPS("update cicilan set piutang=?,jum=?,tgl=?,jam=?,akun=?,lunas=? where kode=?");
        ps.setString(1, b.getPiutang());
        ps.setLong(2, b.getJum());
        ps.setDate(3, b.getTgl());
        ps.setTime(4, b.getJam());
        ps.setString(5, b.getAkun());
        ps.setBoolean(6, b.isLunas());
        ps.setString(7, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Cicilan> getData() throws SQLException {
        ArrayList<Cicilan>a=new ArrayList();
        java.sql.ResultSet rs=d.keluar("select kode from cicilan");
        while(rs.next())a.add(new Cicilan(rs.getString("kode"), d));
        rs.close();
        return a;
    }
}