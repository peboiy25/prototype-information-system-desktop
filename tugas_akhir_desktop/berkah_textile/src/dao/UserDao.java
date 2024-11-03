/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author ASUS
 */
public class UserDao {
    
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement findByNameStatement;
    private PreparedStatement getAllByIdNameStatement;
    
    private final String queryInsert = "INSERT INTO user (kode_user, username, password, role) VALUES (?,?,?,?)";
    private final String queryUpdate = "UPDATE user SET username=?, password=?, role=? WHERE kode_user=?";
    private final String queryDelete = "DELETE FROM user WHERE kode_user=?";
    private final String querySelectAll = "SELECT * FROM user";
    private final String querySelectById = "SELECT * FROM user WHERE kode_user=?";
    private final String queryLikeByName = "SELECT * from user where username LIKE ?";
    private final String querySelectByIdName = "SELECT * from user where username=? AND password=?";
    
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        
        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        findByNameStatement = connection.prepareStatement(queryLikeByName);
        getAllByIdNameStatement = connection.prepareStatement(querySelectByIdName);
    }
    
    public User simpan(User user) throws SQLException {
        simpanStatement.setString(1, user.getKodeUser());
        simpanStatement.setString(2, user.getUsername());
        simpanStatement.setString(3, user.getPassword());
        simpanStatement.setString(4, user.getRole());
        simpanStatement.executeUpdate();
        return user;
    }
    
    public User ubah(User user) throws SQLException {
        ubahStatement.setString(1, user.getUsername());
        ubahStatement.setString(2, user.getPassword());
        ubahStatement.setString(3, user.getRole());
        ubahStatement.setString(4, user.getKodeUser());
        ubahStatement.executeUpdate();
        return user;
    }
    
    public User hapus(User user) throws SQLException {
        hapusStatement.setString(1, user.getKodeUser());
        hapusStatement.executeUpdate();
        return user;
    }
    
    public List<User> getAll() throws SQLException {
        List<User> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setKodeUser(rs.getString("kode_user"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            list.add(user);
        }

        return list;
    }
    
    public User getByIdUser(String id) throws SQLException {
        User user = new User();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            user.setKodeUser(rs.getString("kode_user"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }

        return user;
    }
    
    public List<User> findProdukByName(String nama) throws SQLException{
        List<User> list = new ArrayList<User>();
        findByNameStatement.setString(1, "%"+ nama +"%");
        ResultSet rs = findByNameStatement.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setKodeUser(rs.getString("kode_user"));
            user.setUsername(rs.getString("username"));
            user.setRole(rs.getString("role"));
            list.add(user);
        }
        return list;
    }
    
    public User getByIdNameUser(User user) throws SQLException{
        
        User u = null;
        
        getAllByIdNameStatement.setString(1, user.getUsername());
        getAllByIdNameStatement.setString(2, user.getPassword());
        
        ResultSet rs = getAllByIdNameStatement.executeQuery();

        if (rs.next()) {
            u = new User();
//            System.out.println(rs.getString("username"));
            u.setKodeUser(rs.getString("kode_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setRole(rs.getString("role"));
        }
        return u;
    }
}
