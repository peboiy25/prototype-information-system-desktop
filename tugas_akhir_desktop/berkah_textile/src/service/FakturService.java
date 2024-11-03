/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.DetailFKeluar;
import model.DetailFMasuk;
import model.FKeluar;
import model.FMasuk;

/**
 *
 * @author LENOVO
 */
public interface FakturService {
    // Faktur Masuk
    FMasuk simpanFakturMasuk (FMasuk fm);
    // Detail FakturMasuk
    DetailFMasuk simpanDetailFMasuk(DetailFMasuk dfm);
    
    // Faktur Keluar
    FKeluar simpanFakturKeluar(FKeluar fKeluar);
    //Detail Faktur Keluar
    DetailFKeluar simpanDetailFKeluar(DetailFKeluar dfk);
}
