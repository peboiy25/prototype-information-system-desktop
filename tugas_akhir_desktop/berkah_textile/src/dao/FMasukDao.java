/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.FMasuk;

/**
 *
 * @author LENOVO
 */
public class FMasukDao {
    
    private Connection connection;
    private PreparedStatement simpanStatement;

    
    private final String queryInsert = "INSERT INTO faktur_masuk (no_faktur, tanggal, stok_masuk, nama_pabrik) VALUES (?,?,?,?)";

    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = (Connection)connection;
        simpanStatement = connection.prepareStatement(queryInsert);
        
        simpanStatement = connection.prepareStatement(queryInsert);
    }
    
    public FMasuk simpan(FMasuk fm) throws SQLException{
        simpanStatement.setString(1, fm.getNoFaktur());
        simpanStatement.setString(2, fm.getTanggal());
        simpanStatement.setInt(3, fm.getStokMasuk());
        simpanStatement.setString(4, fm.getNamaPabrik());
        simpanStatement.executeUpdate();
        return fm;
    }
    
}
