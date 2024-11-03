/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import main.App;
import model.Warna;
import view.StokView;

/**
 *
 * @author LENOVO
 */
public class WarnaController {
    
    private final StokView stokView;
    
    public WarnaController(StokView stokView) {
        this.stokView = stokView;
    }
        
    public void clearForm(){
        stokView.getComboKode().setSelectedIndex(0);
        stokView.getTextWarna().setText(null);
        stokView.getTextNomor().setText(null);
        stokView.getTextBerat().setText(null);
        stokView.getTextStok().setText(null);
        stokView.getTabelWarna().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        stokView.getComboKode().setEnabled(kondisi);
        stokView.getTextWarna().setEnabled(kondisi);
        stokView.getTextNomor().setEnabled(kondisi);
        stokView.getTextBerat().setEnabled(kondisi);
        stokView.getTextStok().setEnabled(kondisi);
        stokView.getTombolBaru().setEnabled(kondisi);
        stokView.getTombolSimpan().setEnabled(!kondisi);
        stokView.getTombolTambah().setEnabled(kondisi);
        stokView.getTombolHapus().setEnabled(!kondisi);
    }
        
    public void loadBarang(){
        ComboBoxModel cbm = new DefaultComboBoxModel(App.masterService.getAllKdObj());
        stokView.getComboKode().setModel(cbm);
    }
    
    public void loadData (Warna warna, List<Warna> list){
        if(stokView.getTabelWarna().getSelectedRow()>=0){
            int row = stokView.getTabelWarna().getSelectedRow();
            warna = list.get(row);
            stokView.getComboKode().setSelectedItem(warna.getBarang().getKodeBarang());
            stokView.getTextWarna().setText(warna.getWarna());
            stokView.getTextNomor().setText(warna.getNo_urut());
            stokView.getTextBerat().setText(String.valueOf(warna.getBerat()));
            stokView.getTextStok().setText(String.valueOf(warna.getStok()));
            enableForm(false);
            stokView.getTombolSimpan().setEnabled(true);
            stokView.getTombolHapus().setEnabled(true);
            stokView.getTombolTambah().setEnabled(false);
            stokView.getTombolBaru().setEnabled(true);
            stokView.getTextNomor().setEnabled(true);
            stokView.getTextBerat().setEnabled(true);
            stokView.getTextStok().setEnabled(true);
        }
    }
}
