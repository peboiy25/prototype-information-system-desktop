/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Impl;

import config.Koneksi;
import dao.BarangDao;
import dao.UserDao;
import dao.WarnaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Barang;
import model.User;
import model.Warna;
import service.MasterService;

/**
 *
 * @author STMIK-VII
 */
public class MasterServiceImpl implements MasterService  {
    private BarangDao barangDao;
    private WarnaDao warnaDao;
    private UserDao userDao;
    
    private Koneksi koneksi;
    private Connection connection;
    
    public MasterServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();
            
            barangDao = new BarangDao();
            barangDao.setConnection(connection);
            
            warnaDao = new WarnaDao();
            warnaDao.setConnection(connection);
            
            userDao = new UserDao();
            userDao.setConnection(connection);
        }catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Barang simpanBarang(Barang b) {
        try {
            connection.setAutoCommit(false);
            barangDao.simpan(b);
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

        return b;
    }

    @Override
    public Barang ubahBarang(Barang b) {
        try {
            connection.setAutoCommit(false);
            barangDao.ubah(b);
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

        return b;
    }

    @Override
    public Barang hapusBarang(Barang b) {
        try {
            connection.setAutoCommit(false);
            barangDao.hapus(b);
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
        return b;
    }

    @Override
    public List<Barang> getAllBarang() {
        try {
            return barangDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    @Override
    public Barang getByIdBarang(String id) {
        try {
            return barangDao.getById(id);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Warna simpanWarna(Warna w) {
        try {
            connection.setAutoCommit(false);
            warnaDao.simpan(w);
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

        return w;
    }

    @Override
    public Warna ubahWarna(Warna w) {
        try {
            connection.setAutoCommit(false);
            warnaDao.ubah(w);
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
        return w;
    }

    @Override
    public Warna hapusWarna(Warna w) {
        try {
            connection.setAutoCommit(false);
            warnaDao.hapus(w);
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
        return w;
    }

    @Override
    public List<Warna> getAllWarna() {
        try {
            return warnaDao.getAllWarna();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Warna findWarnaById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Object[] getAllKdObj() {
        try {
            return barangDao.getAllKdObj();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Barang> findBarangByKode(String kode) {
        try {
            return barangDao.findBarangByKode(kode);
    }   catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Barang> getBarangByKd() {
        try {
            return barangDao.getBarangByKd();
    }   catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Warna> findWarnaByKode(String kode) {
        try {
            return warnaDao.findWarnaByKode(kode);
    }   catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User getByIdNameUser(User user) {
        try {
            return userDao.getByIdNameUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        try {
        return userDao.getAll();
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return new ArrayList<>();
    }

    @Override
    public User simpanUser(User u) {
        try {
            connection.setAutoCommit(false);
            userDao.simpan(u);
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

        return u;
    }

    @Override
    public User ubahUser(User u) {
        try {
        connection.setAutoCommit(false);
        userDao.ubah(u);
        connection.commit();
        connection.setAutoCommit(true);
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return u;
    }

    @Override
    public User hapusUser(User u) {
        try {
        connection.setAutoCommit(false);
        userDao.hapus(u);
        connection.commit();
        connection.setAutoCommit(true);
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return u;
    }

    @Override
    public User getByIdUser(String id) {
        try {
        return userDao.getByIdUser(id);
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return null;
    }

    @Override
    public User getByNameUser(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findProdukByNameUser(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
