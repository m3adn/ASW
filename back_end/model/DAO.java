/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.model;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import io.github.cdimascio.dotenv.Dotenv;

import back_end.classes.portfolio.Portfolio_Item;
import back_end.classes.request.Request_Coins;
import back_end.classes.request.Request_Money;
import back_end.classes.user.User_Account;
import back_end.classes.transaction.Transaction;

/**
 *name
 * @author epilif3sotnas
 */
public class DAO {
    private Connection con = null;
   
    static {
        try {
            System.out.println("Loading Driver...");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    // db connection
    public boolean connect () {
        try {
            Dotenv dotenv = Dotenv.load();
            con = DriverManager.getConnection(dotenv.get("url"),
                                              dotenv.get("user"),
                                              dotenv.get("password"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void disconnect () {
        if (con != null) {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // Users
    public boolean insertUser (User_Account user) {
        if (connect()) {
            // INSERT INTO TABLE_NAME (column1, column2, column3,...columnN)
            // VALUES (value1, value2, value3,...valueN);
            String sql = "insert into " + table_name + " ";
            try {
                Statement stm = con.createStatement();
                if (stm.executeUpdate(sql) > 0) {
                    disconnect();
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public User_Account getUserData (String email) {
        if (connect()) {
            String sql = "select * from " + table_name + " where";
            try {
                Statement stm = con.createStatement();
                ResultSet data = stm.executeQuery(sql);
                if (!data.wasNull()) {
                    disconnect();
                    return new User_Account(data.getString("Email"),
                                data.getString("Username"),
                                data.getString("Password"),
                                data.getString("PhoneNumber"),
                                data.getString("ReferralCode"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return new User_Account(null, null, null, null, null);
    }
    
    public boolean updateUserData (User_Account user) {
        if (connect()) {
            String sql = "update " + table_name + " set";
            try {
                Statement stm = con.createStatement();
                if (stm.executeUpdate(sql) > 0) {
                    disconnect();
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public boolean deleteUser (String email) {
        if (connect()) {
            String sql = "delete from " + table_name + " where";
            try {
                Statement stm = con.createStatement();
                if (stm.executeUpdate(sql) > 0) {
                    disconnect();
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public boolean verifyUser (String email, String password) {
        if (connect()) {
            String sql = "select * from " + table_name + " where";
            try {
                Statement stm = con.createStatement();
                ResultSet data = stm.executeQuery(sql);
                if (!data.wasNull()) {
                    disconnect();
                    
                    if (password.equals(data.getString("Password"))) {
                        return true;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public boolean existsUser (String email) {
        if (connect()) {
            String sql = "select * from " + table_name + " where Email=" + email;
            try {
                Statement stm = con.createStatement();
                ResultSet data = stm.executeQuery(sql);
                if (!data.wasNull()) {
                    // send email and generate a new password
                    disconnect();
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
        
    // Transfers
    public ArrayList<Portfolio_Item> getPortfolio (String email) {
        ArrayList<Portfolio_Item> portfolio = new ArrayList<>();
        if (connect()) {
            String sql = "select * from " + table_name + " where";
            try {
                Statement stm = con.createStatement();
                ResultSet data = stm.executeQuery(sql);
                while (data.next()) {
                    Portfolio_Item item = new Portfolio_Item(data.getString("Coin"),
                            data.getFloat("Units"),
                            data.getString("PurchaseDate"),
                            data.getFloat("PurchaseValue"));
                    
                    portfolio.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return portfolio;
    }
    
    public boolean buyCoins (String username, String sellID) {
        if (connect()) {
            String sql = "select * from " + table_name + " where";
            try {
                // get user balance
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet data = stm.executeQuery();
                if (!data.wasNull()) {
                    disconnect();
                    // balance in dollars
                    float balance = data.getFloat("Balance");
                    
                    // get units and coin/cryptocurrency
                    float units = 0.0f;
                    String coin;
                    
                    // get current price coin -> binance
                    float currentPrice = 0.0f;
                    
                    if (balance >= currentPrice * units) {
                        // buy coin
                        // insert to Transactions table
                        // delete sellID if successful
                        return true;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public boolean sellCoins (String username, Request_Coins reqCoins) {
        if (connect()) {
            String sql = "insert into " + table_name + " where";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                if (stm.executeUpdate() > 0) {
                    disconnect();
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public boolean deposit (String username, Request_Money reqMoney) {
        return true;
    }
    
    public boolean withdraw (String username, Request_Money reqMoney) {
        return true;
    }
    
    // Admin Transfers
    public boolean verifyDeposit (String depositID) {
        return true;
    }
    
    public boolean verifyWithdraw (String withdrawID) {
        return true;
    }

    public boolean verifyTransaction (String transactionID) {
        if (connect()) {
            String sql = "select * from " + table_name + " where";
            String sql2 = "select * from " + table_name + " where";
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet data = stm.executeQuery();
                if (!data.wasNull()) {
                    Transaction transaction = new Transaction();
                    
                    // verify transaction
                    
                    stm = con.prepareStatement(sql2);
                    if (stm.executeUpdate() > 0) {
                        disconnect();
                        return true;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return false;
    }
    
    public ArrayList<Transaction> getTransactions () {
        ArrayList<Transaction> transactions = new ArrayList<>();
        if (connect()) {
            String sql = "select * from " + table_name;
            try {
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet data = stm.executeQuery();
                while (data.next()) {
                    disconnect();
                    Transaction trans = new Transaction();
                    
                    transactions.add(trans);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        disconnect();
        return transactions;
    }
}