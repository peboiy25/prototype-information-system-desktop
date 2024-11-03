/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class FKeluar {
    private String noFakturKeluar;
    private String namaPelanggan;
    private String tanggalKeluar;
    private Integer grandTotal;

    public String getNoFakturKeluar() {
        return noFakturKeluar;
    }

    public void setNoFakturKeluar(String noFakturKeluar) {
        this.noFakturKeluar = noFakturKeluar;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    
}
