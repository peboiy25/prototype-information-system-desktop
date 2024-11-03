/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DetailFMasuk;

/**
 *
 * @author ASUS
 */
public class DetailFMasukDao {
    
    private Connection connection;
    private PreparedStatement simpanStatement;
    
    private final String queryInsert = "INSERT INTO detail_faktur_masuk (no_faktur, kode_barang, warna, berat, qty) VALUES (?,?,?,?,?)";
    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = connection;
        simpanStatement = connection.prepareStatement(queryInsert);
    }
    
    public DetailFMasuk simpan(DetailFMasuk dfm) throws SQLException{
        simpanStatement.setString(1, dfm.getfMasuk().getNoFaktur());
        simpanStatement.setString(2, dfm.getBarang().getKodeBarang());
        simpanStatement.setString(3, dfm.getWarna());
        simpanStatement.setDouble(4, dfm.getBerat());
        simpanStatement.setInt(5, dfm.getJumlah());
        simpanStatement.executeUpdate();
        return dfm;
    }
}
