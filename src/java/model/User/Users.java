/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.User;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PRO
 */
public class Users {

    private String idUser, fullName, address, email, password, idChild, certicate, imgAvt, role, gender, phoneNumber;
    private Date dob;

    public Users() {
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    

    public Users(String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.idChild = idChild;
        this.certicate = certicate;
        this.imgAvt = imgAvt;
        this.role = role;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public Users(String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, String dob, String phoneNumber) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.idChild = idChild;
        this.certicate = certicate;
        this.imgAvt = imgAvt;
        this.role = role;
        this.gender = gender;
        setDob(dob);
        this.phoneNumber = phoneNumber;
    }

  

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdChild() {
        return idChild;
    }

    public void setIdChild(String idChild) {
        this.idChild = idChild;
    }

    public String getCerticate() {
        return certicate;
    }

    public void setCerticate(String certicate) {
        this.certicate = certicate;
    }

    public String getImgAvt() {
        return imgAvt;
    }

    public void setImgAvt(String imgAvt) {
        this.imgAvt = imgAvt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(dob);
    }

    public Date getDateOB() {
        return dob;
    }

    public void setDob(String Dob) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dob = new java.sql.Date(sd.parse(Dob).getTime());
        } catch (Exception ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid DOB");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
