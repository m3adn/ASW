/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.model;

import java.util.ArrayList;

import back_end.class_obj.Portfolio_Item;
import back_end.class_obj.Request_Coins;
import back_end.class_obj.Request_Money;
import back_end.class_obj.User_Account;

/**
 *
 * @author epilif3sotnas
 */
public class DAO {
    
    public boolean insertUser (User_Account user) {
        return true;
    }
    
    public User_Account getUserData (String email) {
        User_Account obj = new User_Account("asd", "asd", "asd", "asd", "asd");
        return obj;
    }
    
    public boolean updateUserData (User_Account user) {
        return true;
    }
    
    public boolean deleteUser (String email) {
        return true;
    }
    
    public boolean verifyUser (String email, String password) {
        return true;
    }
    
    public boolean existsUser (String email) {
        return true;
    }
    
    public boolean recoverUser (String email, String password) {
        return true;
    }
    
    public ArrayList getPortfolio (String email) {
        return new ArrayList<Portfolio_Item>();
    }
    
    public boolean buyCoins (String username, Request_Coins reqCoins) {
        return true;
    }
    
    public boolean sellCoins (String username, Request_Coins reqCoins) {
        return true;
    }
    
    public boolean deposit (String username, Request_Money reqMoney) {
        return true;
    }
    
    public boolean withdraw (String username, Request_Money reqMoney) {
        return true;
    }
}
