/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import service.FakturService;
import service.MasterService;
import service.Impl.MasterServiceImpl;
import service.Impl.FakturServiceImpl;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author STMIK-VII
 */
public class App {
    
    public static MenuView menuView;
    public static LoginView loginView;
    
    public static MasterService masterService;
    public static FakturService fakturService;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        masterService = new MasterServiceImpl();
        fakturService = new FakturServiceImpl();
        
        menuView = new MenuView();
//        menuView.setVisible(true);
        
        loginView = new LoginView();
        loginView.setVisible(true);
    }
    
}
