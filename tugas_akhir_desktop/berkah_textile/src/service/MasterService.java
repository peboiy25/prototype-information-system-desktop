/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;
import model.Barang;
import model.User;
import model.Warna;

/**
 *
 * @author STMIK-VII
 */
public interface MasterService {
    
    //USER
    User simpanUser(User u);
    User ubahUser(User u);
    User hapusUser(User u);
    List<User> getAllUser();
    User getByIdUser(String idUser);
    User getByNameUser(String name);
    List<User> findProdukByNameUser(String nama);
    User getByIdNameUser(User user);
    
    
    //BARANG
    Barang simpanBarang(Barang b);
    Barang ubahBarang(Barang b);
    Barang hapusBarang(Barang b);
    List<Barang> getAllBarang();
    List<Barang> findBarangByKode(String kode);
    List<Barang> getBarangByKd();
    Barang getByIdBarang(String id);
//    List<Barang> getAllKd();
    Object[] getAllKdObj();
    
    //WARNA
    Warna simpanWarna(Warna w);
    Warna ubahWarna(Warna w);
    Warna hapusWarna(Warna w);
    List<Warna> getAllWarna();
    List<Warna> findWarnaByKode(String kode);
//    List<Warna> getWarnaByKode(String kode);
    Warna findWarnaById(String id);
//    Object[] getAllName();
}
