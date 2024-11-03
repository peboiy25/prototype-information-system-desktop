/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.FKeluar;

/**
 *
 * @author ASUS
 */
public class FKeluarDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    
    private final String queryInsert = "INSERT INTO faktur_keluar (no_faktur_keluar, nama_pelanggan, tanggal, grand_total) VALUES (?,?,?,?)";
    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = connection;
        simpanStatement = connection.prepareStatement(queryInsert);
    }
    
    public FKeluar simpan(FKeluar fk) throws SQLException{
        simpanStatement.setString(1, fk.getNoFakturKeluar());
        simpanStatement.setString(2, fk.getNamaPelanggan());
        simpanStatement.setString(3, fk.getTanggalKeluar());
        simpanStatement.setInt(4, fk.getGrandTotal());
        simpanStatement.executeUpdate();
        return fk;
    }
}
