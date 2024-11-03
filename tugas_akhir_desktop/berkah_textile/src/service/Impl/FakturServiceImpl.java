/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Impl;

import config.Koneksi;
import dao.DetailFKeluarDao;
import dao.DetailFMasukDao;
import dao.FKeluarDao;
import dao.FMasukDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DetailFKeluar;
import model.DetailFMasuk;
import model.FKeluar;
import model.FMasuk;
import service.FakturService;

/**
 *
 * @author LENOVO
 */
public class FakturServiceImpl implements FakturService {
    
    private FMasukDao fMasukDao;
    private DetailFMasukDao detailFMasukDao;
    private FKeluarDao fKeluarDao;
    private DetailFKeluarDao detailFKeluarDao;
    
    private Koneksi koneksi;
    private Connection connection;

    public FakturServiceImpl(){
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();
            
            fMasukDao = new FMasukDao();
            fMasukDao.setConnection(connection);
            
            detailFMasukDao = new DetailFMasukDao();
            detailFMasukDao.setConnection(connection);
            
            fKeluarDao = new FKeluarDao();
            fKeluarDao.setConnection(connection);
            
            detailFKeluarDao = new DetailFKeluarDao();
            detailFKeluarDao.setConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(FakturServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public FMasuk simpanFakturMasuk(FMasuk fm) {
        try {
            connection.setAutoCommit(false);
            fMasukDao.simpan(fm);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fm;
    }

    @Override
    public DetailFMasuk simpanDetailFMasuk(DetailFMasuk dfm){
        try {
            connection.setAutoCommit(false);
            detailFMasukDao.simpan(dfm);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dfm;
    }

    @Override
    public FKeluar simpanFakturKeluar(FKeluar fk) {
        try {
            connection.setAutoCommit(false);
            fKeluarDao.simpan(fk);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fk;
    }

    @Override
    public DetailFKeluar simpanDetailFKeluar(DetailFKeluar dfk) {
        try {
            connection.setAutoCommit(false);
            detailFKeluarDao.simpan(dfk);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dfk;
    }
    
}
