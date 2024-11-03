/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Warna;

/**
 *
 * @author LENOVO
 */
public class WarnaDao {
    
    public BarangDao barangDao;
    
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    private PreparedStatement getAllKdStatement;
    
    private final String queryInsert = "INSERT INTO stok_warna (kode_barang, warna, no_urut, berat, stok) VALUES (?,?,?,?,?)";
    private final String queryUpdate = "UPDATE stok_warna SET warna=?, no_urut=?, berat=?, stok=? WHERE kode_barang=? AND warna=? AND no_urut=?";
    private final String queryDelete = "DELETE FROM stok_warna WHERE kode_barang=? AND warna=? AND no_urut=?";
    private final String querySelectAll = "SELECT * FROM stok_warna";
    private final String querySelectById = "SELECT * FROM stok_warna WHERE kode_barang LIKE ?";
//    private final String querySelectById = "SELECT stok_warna.*, barang.harga_per_kg FROM stok_warna JOIN barang ON barang.kode_barang = stok_warna.kode_barang";
    private final String querySelectAllName = "SELECT warna from stok_warna";
    private final String querySelectAllKd = "SELECT kode_barang from barang";
    private final String querySelectByName = "SELECT * FROM stok_warna WHERE warna=?";
    
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        this.barangDao = new BarangDao();
        this.barangDao.setConnection(connection);
        
        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
        getAllKdStatement = connection.prepareStatement(querySelectAllKd);
    }
    
    public Warna simpan(Warna w) throws SQLException{
        simpanStatement.setString(1, w.getBarang().getKodeBarang());
        simpanStatement.setString(2, w.getWarna());
        simpanStatement.setString(3, w.getNo_urut());
        simpanStatement.setDouble(4, w.getBerat());
        simpanStatement.setInt(5, w.getStok());
        simpanStatement.executeUpdate();
        return w;
    }
    
    public Warna ubah(Warna w) throws SQLException {
        ubahStatement.setString(1, w.getWarna());
        ubahStatement.setString(2, w.getNo_urut());
        ubahStatement.setDouble(3, w.getBerat());
        ubahStatement.setInt(4, w.getStok());
        ubahStatement.setString(5, w.getBarang().getKodeBarang());
        ubahStatement.setString(6, w.getWarna());
        ubahStatement.setString(7, w.getNo_urut());
        ubahStatement.executeUpdate();
        return w;
    }
    
    public Warna hapus(Warna w) throws SQLException {
        hapusStatement.setString(1, w.getBarang().getKodeBarang());
        hapusStatement.setString(2, w.getWarna());
        hapusStatement.setString(3, w.getNo_urut());
        hapusStatement.executeUpdate();
        return w;
    }
    
    public List<Warna> getAllWarna() throws SQLException{
//        Object[] name = new Object[] {};
        List<Warna> newObj = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();
        while(rs.next()){
            Warna w = new Warna();
//            newObj.add(rs.getString("warna"));
            w.setBarang(barangDao.getById(rs.getString("kode_barang")));
            w.setWarna(rs.getString("warna"));
            w.setNo_urut(rs.getString("no_urut"));
            w.setBerat(rs.getDouble("berat"));
            w.setStok(rs.getInt("stok"));
            newObj.add(w);
        }
        return newObj;
    }
    
    public List<Warna> findWarnaByKode(String kode) throws SQLException{
        List<Warna> list = new ArrayList<Warna>();
        getByIdStatement.setString(1, "%"+kode+"%");
        ResultSet rs = getByIdStatement.executeQuery();
        while(rs.next()){
            Warna w = new Warna();
            w.setBarang(barangDao.getById(rs.getString("kode_barang")));
            w.setWarna(rs.getString("warna"));
            w.setNo_urut(rs.getString("no_urut"));
            w.setBerat(rs.getDouble("berat"));
            w.setStok(rs.getInt("stok"));
//            w.setBarang(barangDao.getById(rs.getString("harga_per_kg")));
            list.add(w);
        }
        return list;
    }
    
//    public List<Warna> getAll() throws SQLException {
//        List<Warna> list = new ArrayList<>();
//        ResultSet rs = getAllStatement.executeQuery();
//
//        while (rs.next()) {
//            Warna w = new Warna();
//            w.setBarang(barangDao.getById(rs.getString("kode_barang")));
//            w.setWarna(rs.getString("warna"));
//            w.setNo_urut(rs.getString("no_urut"));
//            w.setBerat(rs.getDouble("berat"));
//            w.setStok(rs.getDouble("stok"));
//            list.add(w);
//        }
//
//        return list;
//    }
    

    public Object[] getAllKd() throws SQLException {
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllKdStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("kode_barang"));
        }
        return newObj.toArray();
    }
    
    
}
