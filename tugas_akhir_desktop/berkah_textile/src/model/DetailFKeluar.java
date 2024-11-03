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
public class DetailFKeluar {
    private String id;
    private FKeluar fKeluar;
//    private Barang barang;
    private Warna warna;
//    private Warna warnaBarang;
//    private Double berat;
    private Integer jumlah;
    private Integer subTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FKeluar getfKeluar() {
        return fKeluar;
    }

    public void setfKeluar(FKeluar fKeluar) {
        this.fKeluar = fKeluar;
    }

    public Warna getWarna() {
        return warna;
    }

    public void setWarna(Warna warna) {
        this.warna = warna;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    
}
