/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.User;

import model.User.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DBUnitil.DatabaseInfo;
import java.util.Random;

/**
 *
 * @author ASUS-PRO
 */
public class UsersDB {

    private static char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static Users checkLogin(String acc, String pass) {
        Users user = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idUser]\n"
                    + "      ,[fullName]\n"
                    + "      ,[address]\n"
                    + "      ,[dob]\n"
                    + "      ,[gender]\n"
                    + "      ,[email]\n"
                    + "      ,[phoneNumber]\n"
                    + "      ,[password]\n"
                    + "      ,[role]\n"
                    + "      ,[idChild]\n"
                    + "      ,[certicate]\n"
                    + "      ,[imgAvt]\n"
                    + "  FROM [dbo].[Users] where ([email]=? or [phoneNumber]= ?)and [password]=?");
            stmt.setString(1, acc);
            stmt.setString(2, acc);
            stmt.setString(3, pass);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String mail = rs.getString(6);
                String phone = rs.getString(7);
                String pw = rs.getString(8);
                String role = rs.getString(9).trim();
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12).trim();
                user = new Users(id, name, address, mail, pw, idChild, certicate, imgAvt, role, gender, dob, phone);
            }
            con.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }

    public static Users registration(Users u) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "INSERT INTO [dbo].[Users]\n"
                    + "           ([idUser],[fullName] ,[address],[dob]  ,[gender],[email],[phoneNumber],[password],[role],[idChild],[certicate] ,[imgAvt]) VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getIdUser());
            stmt.setString(2, u.getFullName());
            stmt.setString(3, u.getAddress());
            stmt.setDate(4, u.getDateOB());
            stmt.setString(5, u.getGender());
            stmt.setString(6, u.getEmail());
            stmt.setString(7, u.getPhoneNumber());
            stmt.setString(8, u.getPassword());
            stmt.setString(9, u.getRole());
            stmt.setString(10, u.getIdChild());
            stmt.setString(11, u.getCerticate());
            stmt.setString(12, u.getImgAvt());
            stmt.executeUpdate();
            con.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkEmail(String email, String phone) {
        Users user = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select [idUser]  ,[fullName]  ,[address]  "
                    + " ,[dob] ,[gender]    ,[email]  ,[phoneNumber] ,[password]\n"
                    + ",[role] ,[idChild] ,[certicate] ,[imgAvt] FROM [dbo].[Users] "
                    + "where [email]=? or phoneNumber =?");
            stmt.setString(1, email);
            stmt.setString(2, phone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String mail = rs.getString(6);
                String phoneNumber = rs.getString(7);
                String pw = rs.getString(8);
                String role = rs.getString(9);
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12);
                user = new Users(id, name, address, mail, pw, idChild, certicate, imgAvt, role, gender, dob, phone);

            }
            con.close();
            if (user != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static boolean checkPhoneNumber(String phone) {
        Users user = null;
        int affected_rows = 0;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select [idUser]  ,[fullName]  ,[address]  "
                    + " ,[dob] ,[gender]    ,[email]  ,[phoneNumber] ,[password]\n"
                    + ",[role] ,[idChild] ,[certicate] ,[imgAvt] FROM [dbo].[Users] "
                    + "where [phone]=?");
            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String mail = rs.getString(6);
                String phoneN = rs.getString(7);
                String pw = rs.getString(8);
                String role = rs.getString(9);
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12);
                user = new Users(id, name, address, mail, pw, idChild, certicate, imgAvt, role, gender, dob, phone);
                affected_rows++;
            }
            con.close();
            if (affected_rows == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static String createID() {
        Random generator = new Random();
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 3; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        String randomStrValue = "";
        StringBuilder sb1 = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 7; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb1.append(chars[index]);
        }
        return sb.toString() + sb1.toString();
    }

    public static void main(String[] args) {
        System.out.println(UsersDB.createID());
    }

    // Ý 
    public static boolean updateProfile(Users us) {

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Users] SET  [fullName] = ?  ,[address] = ?  "
                    + " ,[dob] = ? ,[gender] = ? ,[email] = ? ,[phoneNumber] = ? "
                    + " where [idUser]=?");

            stmt.setString(1, us.getFullName());
            stmt.setString(2, us.getAddress());
            stmt.setString(3, us.getDob());
            stmt.setString(4, us.getGender());
            stmt.setString(5, us.getEmail());
            stmt.setString(6, us.getPhoneNumber());
            stmt.setString(7, us.getIdUser());

            boolean rowUpdated = stmt.executeUpdate() > 0;

            con.close();
            return rowUpdated;

        } catch (Exception ex) {

            ex.printStackTrace();
            throw new RuntimeException(ex);

        }

    }

    public static void updateCertificate(String idUsers, String img) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Users set [certicate]=? where idUser=?");
            stmt.setString(1, img);
            stmt.setString(2, idUsers);
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void getNewPassword(String password, String email) {

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Users] SET  [password]=? where [email]=?");

            stmt.setString(1, password);
            stmt.setString(2, email);
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {

            throw new RuntimeException(ex);

        }

    }

    public int getTotal(String role) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from Users where role=? ");
            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public List<Users> getAllUsersByRole(String role1) {
        List<Users> user = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idUser],[fullName]  ,[address],[dob] ,[gender],"
                    + "[email]  ,[phoneNumber] ,[password]\n"
                    + "                    ,[role] ,[idChild] ,[certicate] ,[imgAvt] FROM [dbo].[Users] where [role]='" + role1 + "    ' ");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String mail = rs.getString(6);
                String phone = rs.getString(7);
                String pw = rs.getString(8);
                String role = rs.getString(9).trim();
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12);
                user.add(new Users(id, name, address, mail, pw, idChild, certicate, imgAvt, role, gender, dob, phone));
            }
            con.close();
            return user;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static ArrayList<Users> getAllUsers() {
        String role1 = "Teacher   ";
        ArrayList<Users> user = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idUser],[fullName]  ,[address],[dob] ,[gender],"
                    + "[email]  ,[phoneNumber] ,[password]\n"
                    + "                    ,[role] ,[idChild] ,[certicate] ,[imgAvt] FROM [dbo].[Users] where [role]='" + role1 + "    '");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String mail = rs.getString(6);
                String phone = rs.getString(7);
                String pw = rs.getString(8);
                String role = rs.getString(9).trim();
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12);
                user.add(new Users(id, name, address, mail, pw, idChild, certicate, imgAvt, role, gender, dob, phone));
            }
            con.close();
            return user;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
    
    
        public static ArrayList<Users> getAllUsersAnalys() {
        ArrayList<Users> user = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT "
                    + "[idUser] ,"
                    + "[fullName]  ,"
                    + "[address] ,"
                    + "[dob] ,"
                    + "[gender], "
                    + "[email]  ,"
                    + "[phoneNumber] ,"
                    + "[password],"
                    + "[role] ,"
                    + "[idChild] ,"
                    + "[certicate] ,"
                    + "[imgAvt] "
                    + "FROM [dbo].[Users]");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String mail = rs.getString(6);
                String phone = rs.getString(7);
                String pw = rs.getString(8);
                String role = rs.getString(9).trim();
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12);
                user.add(new Users(id, name, address, mail, pw, idChild, certicate, imgAvt, role, gender, dob, phone));
            }
            con.close();
            return user;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static Users getUserById(String idUser) {
        Users user = null;

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idUser]  ,[fullName]  ,[address]  "
                    + " ,[dob] ,[gender]    ,[email]  ,[phoneNumber] ,[password]\n"
                    + ",[role] ,[idChild] ,[certicate] ,[imgAvt] FROM [dbo].[Users] "
                    + "where [idUser]= ? ");
            stmt.setString(1, idUser);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
//                String idUser = rs.getString(1);
                String fullName = rs.getString(2);
                String address = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String email = rs.getString(6);
                String phoneNumber = rs.getString(7);
                String password = "";
                String role = rs.getString(9).trim();
                String idChild = rs.getString(10);
                String certicate = rs.getString(11);
                String imgAvt = rs.getString(12);
                user = new Users(idUser, fullName, address, email, password, idChild, certicate, imgAvt, role, gender, dob, phoneNumber);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        return user;
    }

    public static void updateStatus(String idUser, String role) {

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Users] SET  [role]=? where [idUser]=?");

            stmt.setString(1, role);
            stmt.setString(2, idUser);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {

            throw new RuntimeException(ex);

        }

    }

    public static void updateImg(String idUsers, String img) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Users set imgAvt=? where idUser=?");
            stmt.setString(1, img);
            stmt.setString(2, idUsers);
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
