/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.classes.user;

/**
 *
 * @author epilif3sotnas
 */
public class User_Account {
    private String email;
    private String username;
    private String password;
    private String phoneNumber = "";
    private String referralCode = "";
    private float balance = 0.0f;
    
    public User_Account (String _email,
                  String _username,
                  String _password,
                  String _phoneNumber,
                  String _referralCode) {        
        int i = 0;
        i = checkEmail(_email, i);
        i = checkUsername(_username, i);
        i = checkPassword(_password, i);
        i = checkPhoneNumber(_phoneNumber, i);
        i = checkReferralCode(_referralCode, i);
        
        if (i != 0) throw new IllegalArgumentException("Data not valid!!");
        
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.phoneNumber = _phoneNumber;
        this.referralCode = _referralCode;
    }
    
    private int checkEmail (String _email, int i) {
        return i++;
    }
    
    private int checkUsername (String _username, int i) {
        return i++;
    }
    
    private int checkPassword (String _password, int i) {
        return i++;
    }
    
    private int checkPhoneNumber (String _phoneNumber, int i) {
        return i++;
    }
    
    private int checkReferralCode (String _referralCode, int i) {
        return i++;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
