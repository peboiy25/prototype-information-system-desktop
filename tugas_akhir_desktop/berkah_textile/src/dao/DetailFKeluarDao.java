/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DetailFKeluar;

/**
 *
 * @author ASUS
 */
public class DetailFKeluarDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    
    private final String queryInsert = "INSERT INTO detail_faktur_keluar (no_faktur_keluar, kode_barang, warna, berat, qty, sub_total) VALUES (?,?,?,?,?,?)";
    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = connection;
        simpanStatement = connection.prepareStatement(queryInsert);
    }
    
    public DetailFKeluar simpan(DetailFKeluar dfk) throws SQLException{
        simpanStatement.setString(1, dfk.getfKeluar().getNoFakturKeluar());
        simpanStatement.setString(2, dfk.getWarna().getBarang().getKodeBarang());
        simpanStatement.setString(3, dfk.getWarna().getWarna());
        simpanStatement.setDouble(4, dfk.getWarna().getBerat());
//        simpanStatement.setString(5, dfk.getWarna().getNo_urut());
        simpanStatement.setInt(5, dfk.getJumlah());
        simpanStatement.setInt(6, dfk.getSubTotal());
        simpanStatement.executeUpdate();
        return dfk;
    }
}
