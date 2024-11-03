/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Barang;
import view.BarangView;

/**
 *
 * @author STMIK-VII
 */
public class BarangController {

    private final BarangView barangView;

    public BarangController(BarangView barangView) {
        this.barangView = barangView;
    }

    public void clearForm() {
        barangView.getTextKode().setText(null);
        barangView.getTextNama().setText(null);
        barangView.getTextSatuan().setText(null);
        barangView.getTextHarga().setText(null);
        barangView.getTextGrand().setText(null);
        barangView.getTabelBarang().clearSelection();
    }
    
    public void enableForm(boolean kondisi) {
        barangView.getTextKode().setEnabled(kondisi);
        barangView.getTextNama().setEnabled(kondisi);
        barangView.getTextSatuan().setEnabled(kondisi);
        barangView.getTextHarga().setEnabled(kondisi);
        barangView.getTextGrand().setEnabled(kondisi);
        barangView.getTombolSimpan().setEnabled(kondisi);
        barangView.getTombolEdit().setEnabled(!kondisi);
        barangView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(barangView.getTextKode().getText().equals("")){
            JOptionPane.showMessageDialog(barangView, "Kode harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    
    public void loadData(Barang barang, List<Barang> list){
        if(barangView.getTabelBarang().getSelectedRow() >= 0){
            int row = barangView.getTabelBarang().getSelectedRow();
            barang = list.get(row);
            barangView.getTextKode().setText(barang.getKodeBarang());
            barangView.getTextNama().setText(barang.getNamaBarang());
            barangView.getTextSatuan().setText(barang.getSatuan());
            barangView.getTextHarga().setText(String.valueOf(barang.getHarga()));
            barangView.getTextGrand().setText(String.valueOf(barang.getGrandStok()));
            enableForm(false);
            barangView.getTextNama().setEnabled(true);
            barangView.getTextSatuan().setEnabled(true);
            barangView.getTextHarga().setEnabled(true);
//            barangView.getTextGrand().setEnabled(true);
        }else{
            
        }
    }
    
}
