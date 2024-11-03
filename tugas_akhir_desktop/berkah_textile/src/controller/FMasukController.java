/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import main.App;
import model.Barang;
import model.DetailFMasuk;
import model.Warna;
import view.BarangView;
import view.FMasukView;
import view.HasilCariView;
import view.StokView;

/**
 *
 * @author LENOVO
 */
public class FMasukController {
    
    private final FMasukView fMasukView;
    private List<Warna> listWarna;
    private List<Barang> listBarang;
    private Warna warna;
    private Barang barang;
    
    public FMasukController(FMasukView fMasukView) {
        this.fMasukView = fMasukView;
    }
    
    public void cariBarang(String kode){
        HasilCariView hasilCari = new HasilCariView(App.menuView, true);
        listBarang = App.masterService.findBarangByKode(kode);
        BarangView bv = new BarangView();
        BarangView.BarangTableModel barangTabelModel = bv.new BarangTableModel(listBarang);
        hasilCari.getTabelCari().setModel(barangTabelModel);
        
        BarangController bc = new BarangController(bv);
        hasilCari.getTabelCari().getSelectionModel().addListSelectionListener((lse) -> {
            if(hasilCari.getTabelCari().getSelectedRow()>=0){
                int row = hasilCari.getTabelCari().getSelectedRow();
                barang = listBarang.get(row);
                fMasukView.getTextKode().setText(barang.getKodeBarang());
            }
        });
        hasilCari.setVisible(true);
    }
    
    public boolean cekBarang(List<DetailFMasuk> listDetail, String kode, String warna, Double berat){
        boolean kondisi = false;
        for (DetailFMasuk detailFMasuk : listDetail) {
            if(detailFMasuk.getBarang().getKodeBarang().equals(kode)
                    && detailFMasuk.getWarna().equals(warna)
                    && detailFMasuk.getBerat().equals(berat)
                    && detailFMasuk.getWarna() !=null
                    && detailFMasuk.getBerat() !=null
                    && detailFMasuk.getBarang().getKodeBarang() != null){
                kondisi = true;
                JOptionPane.showMessageDialog(fMasukView, "Produk sudah dimasukkan!");
                break;
            }
        }
        return kondisi;
    }

    public void tambahStok(List<DetailFMasuk> listDetail, String warnaBarang, Double berat){
        if(cekBarang(listDetail, barang.getKodeBarang(), warnaBarang, berat)){
            clearBarang();
        }else{
            DetailFMasuk detail = new DetailFMasuk();
            detail.setBarang(barang);
            //detail.setJumlah(Integer.parseInt(penjualanView.getTextJumlahBeli().getText()));
            detail.setWarna(fMasukView.getTextWarna().getText());
            detail.setBerat(Double.parseDouble(fMasukView.getTextBerat().getText()));
            detail.setJumlah(Integer.parseInt(fMasukView.getTextJumlah().getText()));
//            if (detail.getJumlah() != null) {
//                detail.setJumlah(detail.getJumlah() + .getHargaJual());
//            } else {
//                detail.setSubtotal(produk.getHargaJual() * detail.getJumlah());
//            }
            listDetail.add(detail);
            refreshTotal(listDetail);
            clearBarang();
        }
    }

    public void deleteItem(List<DetailFMasuk> listDetail) {
        if (fMasukView.getTabelFMasuk().getSelectedRow() >= 0) {
            int row = fMasukView.getTabelFMasuk().getSelectedRow();
            listDetail.remove(row);
	    refreshTotal(listDetail);
            fMasukView.getTabelFMasuk().getSelectionModel().clearSelection();
        }
    }
    
    private void refreshTotal(List<DetailFMasuk> listDetail) {
        if (listDetail != null && !listDetail.isEmpty()) {
            Integer total = 0;
            for (DetailFMasuk od : listDetail) {
                total = total + od.getJumlah();
            }
            fMasukView.getTextTotal().setText(total.toString());
        }else{
	    fMasukView.getTextTotal().setText("0");
	}
    }
    
    public void clearBarang(){
        fMasukView.getTextKode().setText(null);
        fMasukView.getTextNama().setText(null);
        fMasukView.getTextWarna().setText(null);
        fMasukView.getTextBerat().setText(null);
        fMasukView.getTextJumlah().setText(null);
        fMasukView.getTabelFMasuk().clearSelection();
    }
    
    public void clearForm(){
        clearBarang();
        fMasukView.getTextNoFMasuk().setText(null);
        fMasukView.getTanggalFMasuk().setDate(null);
        fMasukView.getTextTotal().setText("0");
    }
    
}
