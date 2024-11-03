/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.User;
import view.UserView;

/**
 *
 * @author ASUS
 */
public class UserController {
    private final UserView userView;

    public UserController(UserView userView) {
        this.userView = userView;
    }
    
    public void clearForm(){
        userView.getTextKode().setText(null);
        userView.getTextUname().setText(null);
        userView.getTextPassword().setText(null);
        userView.getTextRole().setText(null);
        userView.getTabelUser().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        userView.getTextKode().setEnabled(kondisi);
        userView.getTextUname().setEnabled(kondisi);
        userView.getTextPassword().setEnabled(kondisi);
        userView.getTextRole().setEnabled(kondisi);
        userView.getTombolSimpan().setEnabled(kondisi);
        userView.getTombolUbah().setEnabled(!kondisi);
        userView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(userView.getTextKode().getText().equals("")){
            JOptionPane.showMessageDialog(userView, "ID User harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    
    public void loadData(User user, List<User> list){
        if(userView.getTabelUser().getSelectedRow() >= 0){
            int row = userView.getTabelUser().getSelectedRow();
            user = list.get(row);
            userView.getTextKode().setText(user.getKodeUser());
            userView.getTextUname().setText(user.getUsername());
            userView.getTextPassword().setText(user.getPassword());
            userView.getTextRole().setText(user.getRole());
            userView.getTextKode().setEnabled(false);
            userView.getTombolUbah().setEnabled(false);
            userView.getTombolHapus().setEnabled(false);
            enableForm(false);
            userView.getTextRole().setEnabled(true);
            userView.getTextUname().setEnabled(true);
            userView.getTextPassword().setEnabled(true);
        }
    }
}
