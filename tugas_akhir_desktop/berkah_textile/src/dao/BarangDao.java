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
import model.Barang;

/**
 *
 * @author STMIK-VII
 */
public class BarangDao {
    
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    private PreparedStatement getAllKdStatement;
    
    private final String queryInsert = "INSERT INTO barang (kode_barang, nama_barang, satuan, harga_per_kg, grand_stok) VALUES (?,?,?,?,?)";
    private final String queryUpdate = "UPDATE barang SET nama_barang=?, satuan=?, harga_per_kg=?, grand_stok=? WHERE kode_barang=?";
    private final String queryDelete = "DELETE FROM barang WHERE kode_barang=?";
    private final String querySelectAll = "SELECT * FROM barang";
    private final String querySelectById = "SELECT * FROM barang WHERE kode_barang LIKE ?";
    private final String querySelectAllName = "SELECT nama_barang FROM barang";
    private final String querySelectAllKd = "SELECT * FROM barang";
    private final String querySelectByName = "SELECT * FROM barang WHERE nama_barang=?";
    
    public void setConnection(java.sql.Connection connection) throws SQLException {
        this.connection = (Connection) connection;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
        getAllKdStatement = connection.prepareStatement(querySelectAllKd);
    }
    
    public Barang simpan(Barang b) throws SQLException {
        simpanStatement.setString(1, b.getKodeBarang());
        simpanStatement.setString(2, b.getNamaBarang());
        simpanStatement.setString(3, b.getSatuan());
        simpanStatement.setInt(4, b.getHarga());
        simpanStatement.setDouble(5, b.getGrandStok());
        simpanStatement.executeUpdate();
        return b;
    }
    
    public Barang ubah(Barang b) throws SQLException {
        ubahStatement.setString(1, b.getNamaBarang());
        ubahStatement.setString(2, b.getSatuan());
        ubahStatement.setInt(3, b.getHarga());
        ubahStatement.setDouble(4, b.getGrandStok());
        ubahStatement.setString(5, b.getKodeBarang());
        ubahStatement.executeUpdate();
        return b;
    }
    
    public Barang hapus(Barang b) throws SQLException {
        hapusStatement.setString(1, b.getKodeBarang());
        hapusStatement.executeUpdate();
        return b;
    }
    
    public List<Barang> getAll() throws SQLException {
        List<Barang> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Barang b = new Barang();
            b.setKodeBarang(rs.getString("kode_barang"));
            b.setNamaBarang(rs.getString("nama_barang"));
            b.setSatuan(rs.getString("satuan"));
            b.setHarga(rs.getInt("harga_per_kg"));
            b.setGrandStok(rs.getDouble("grand_stok"));
            list.add(b);
        }

        return list;
    }
    
    public Barang getById(String kode) throws SQLException {
        Barang b = new Barang();
        
        getByIdStatement.setString(1, kode);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            b.setKodeBarang(rs.getString("kode_barang"));
            b.setNamaBarang(rs.getString("nama_barang"));
            b.setSatuan(rs.getString("satuan"));
            b.setHarga(rs.getInt("harga_per_kg"));
            b.setGrandStok(rs.getDouble("grand_stok"));
        }

        return b;
    }
    
    public Object[] getAllName() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("nama_barang"));
        }
        return newObj.toArray();
    }
     
    //COBA COBA AJA
    public List<Barang> findBarangByKode(String kode) throws SQLException {
        List<Barang> list = new ArrayList<Barang>();
        getByIdStatement.setString(1, "%"+kode+"%");
        ResultSet rs = getByIdStatement.executeQuery();
        while(rs.next()){
            Barang b = new Barang();
            b.setKodeBarang(rs.getString("kode_barang"));
            b.setNamaBarang(rs.getString("nama_barang"));
            b.setSatuan(rs.getString("satuan"));
            b.setHarga(rs.getInt("harga_per_kg"));
            b.setGrandStok(rs.getDouble("grand_stok"));
            list.add(b);
        }
        return list;
    }
    
    public List<Barang> getBarangByKd() throws SQLException {
        List<Barang> list = new ArrayList<>();
        ResultSet rs = getAllKdStatement.executeQuery();
        while(rs.next()){
            Barang b = new Barang();
            b.setKodeBarang(rs.getString("kode_barang"));;
            list.add(b);
        }
        return list;
    }
    
    
    public Barang getByName(String name) throws SQLException {
        Barang b = new Barang();
        
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        while (rs.next()) {
            b.setKodeBarang(rs.getString("kode_barang"));
            b.setNamaBarang(rs.getString("nama_barang"));
        }
        return b;
    }

    public Object[] getAllKdObj() throws SQLException {
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllKdStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("kode_barang"));
//            newObj.add(rs.getString("nama_barang"));
//            newObj.add(rs.getString("satuan"));
//            newObj.add(rs.getInt("harga_per_kg"));
//            newObj.add(rs.getDouble("grand_stok"));
        }
        return newObj.toArray();
    }
    
}
