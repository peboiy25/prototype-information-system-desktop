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
import model.DetailFKeluar;
import model.Warna;
import view.BarangView;
import view.FKeluarView;
import view.HasilCariView;
import view.StokView;

/**
 *
 * @author ASUS
 */
public class FKeluarController {
    
    private final FKeluarView fKeluarView;
    private List<Warna> listWarna;
    private Warna warna;
    private Barang barang;
    
    public FKeluarController(FKeluarView fKeluarView) {
        this.fKeluarView = fKeluarView;
    }
    
    public void cariWarna(String kode){
        HasilCariView hasilCari = new HasilCariView(App.menuView, true);
        listWarna = App.masterService.findWarnaByKode(kode);
        StokView wv = new StokView();
        StokView.WarnaTableModel warnaTabelModel = wv.new WarnaTableModel(listWarna);
        hasilCari.getTabelCari().setModel(warnaTabelModel);
        
        WarnaController wc = new WarnaController(wv);
        hasilCari.getTabelCari().getSelectionModel().addListSelectionListener((lse) -> {
            if(hasilCari.getTabelCari().getSelectedRow()>=0){
                int row = hasilCari.getTabelCari().getSelectedRow();
                warna = listWarna.get(row);
                fKeluarView.getTextKode().setText(warna.getBarang().getKodeBarang());
                fKeluarView.getTextWarna().setText(warna.getWarna());
                fKeluarView.getTextNomor().setText(warna.getNo_urut());
                fKeluarView.getTextBerat().setText(String.valueOf(warna.getBerat()));
                fKeluarView.getTextHarga().setText(String.valueOf(warna.getBarang().getHarga()));
            }
        });
        hasilCari.setVisible(true);
    }
    
    public boolean cekWarna(List<DetailFKeluar> listDetail, String kode, String warna, String nomor, Double berat){
        boolean kondisi = false;
        for (DetailFKeluar detailFKeluar : listDetail) {
            if(detailFKeluar.getWarna().getBarang().getKodeBarang().equals(kode)
                    && detailFKeluar.getWarna().getWarna().equals(warna)
                    && detailFKeluar.getWarna().getNo_urut().equals(nomor)
                    && detailFKeluar.getWarna().getBerat().equals(berat)
                    && detailFKeluar.getWarna().getBarang().getKodeBarang() !=null
                    && detailFKeluar.getWarna().getWarna() !=null
                    && detailFKeluar.getWarna().getNo_urut() !=null
                    && detailFKeluar.getWarna().getBerat()!=null
                    && detailFKeluar.getWarna().getBarang().getKodeBarang() != null){
                kondisi = true;
                JOptionPane.showMessageDialog(fKeluarView, "Produk sudah dimasukkan!");
                break;
            }
        }
        return kondisi;
    }
    
    public void tambahBeli(List<DetailFKeluar> listDetail, String warnaBarang, String nomor, Double berat) {
        fKeluarView.getTextTotal().setEnabled(false);
        int value1 = (int)Math.round(warna.getBerat());
        if(cekWarna(listDetail, warna.getBarang().getKodeBarang(), warnaBarang, nomor, berat)){
            clearWarna();
        }else{
            DetailFKeluar detail = new DetailFKeluar();
            detail.setWarna(warna);
            detail.setJumlah(Integer.parseInt(fKeluarView.getTextJumlah().getText()));
            if (detail.getSubTotal()!= null) {
                detail.setSubTotal(detail.getSubTotal()+ warna.getBarang().getHarga());
            } else {
                detail.setSubTotal(warna.getBarang().getHarga() * value1 * detail.getJumlah());
            }
            listDetail.add(detail);
            refreshTotal(listDetail);
            clearWarna();
        }
    }
    
    private void refreshTotal(List<DetailFKeluar> listDetail) {
        if (listDetail != null && !listDetail.isEmpty()) {
            Integer total = 0;
            for (DetailFKeluar od : listDetail) {
                total = total + od.getSubTotal();
            }
            fKeluarView.getTextTotal().setText(total.toString());
        }else{
	    fKeluarView.getTextTotal().setText("0");
	}
    }
    
    public void deleteItem(List<DetailFKeluar> listDetail){
        if (fKeluarView.getTabelFKeluar().getSelectedRow() >= 0) {
            int row = fKeluarView.getTabelFKeluar().getSelectedRow();
            listDetail.remove(row);
	    refreshTotal(listDetail);
            fKeluarView.getTabelFKeluar().getSelectionModel().clearSelection();
        } 
    }
    
    public void clearWarna(){
        fKeluarView.getTextWarna().setText(null);
        fKeluarView.getTextHarga().setText(null);
        fKeluarView.getTextJumlah().setText(null);
        fKeluarView.getTextBerat().setText(null);
        fKeluarView.getTextNomor().setText(null);
        fKeluarView.getTabelFKeluar().clearSelection();
    }
    
    public void clearForm(){
        clearWarna();
        fKeluarView.getTextNoFKeluar().setText(null);
        fKeluarView.getTanggalFKeluar().setDate(null);
        fKeluarView.getTextNamaPelanggan().setText(null);
        fKeluarView.getTextTotal().setText("0");
    }
}
