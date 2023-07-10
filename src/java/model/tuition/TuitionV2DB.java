/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tuition;

import java.sql.Connection;
import model.DBUnitil.DatabaseInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-PRO
 */
public class TuitionV2DB {

    public static void addListFeesV2(String idPay, String idNameFee, String idChild, int tuition, String status, String idTuition) {
        try ( Connection con = DatabaseInfo.getConnect();  PreparedStatement stmt = con.prepareStatement("INSERT INTO [dbo].[ListFeesV2] "
                + "([idPay], [idNameFee], [idChild], [tuition], [status],[idTuition]) "
                + "VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, idPay);
            stmt.setString(2, idNameFee);
            stmt.setString(3, idChild);
            stmt.setInt(4, tuition);
            stmt.setString(5, status.trim());
            stmt.setString(6, idTuition);
            int value = stmt.executeUpdate();
            System.out.println("Rows affected: " + value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkTuition(String idChild) {
        TuitionV2 tuitionV2 = null;
        int affected_rows = 0;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idTuition]\n"
                    + "      ,[idChild]\n"
                    + "      ,[tuition]\n"
                    + "      ,[datePay]\n"
                    + "      ,[dateStart]\n"
                    + "      ,[dateEnd]\n"
                    + "      ,[status]\n"
                    + "  FROM [A01_RT03].[dbo].[TuitionV2] where [idChild]=? AND status='No'");

            stmt.setString(1, idChild);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idTuition = rs.getString(1);
                String idChild1 = rs.getString(2);
                int tuition = rs.getInt(3);
                LocalDateTime datePay = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime dateStart = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime dateEnd = rs.getTimestamp(6).toLocalDateTime();
                String status = rs.getString(7);
                tuitionV2 = new TuitionV2(idTuition, idChild, tuition, datePay, dateStart, dateEnd, status);
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
     public static TuitionV2 getTuition(String idChild) {
        TuitionV2 tuitionV2 = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idTuition]\n"
                    + "      ,[idChild]\n"
                    + "      ,[tuition]\n"
                    + "      ,[datePay]\n"
                    + "      ,[dateStart]\n"
                    + "      ,[dateEnd]\n"
                    + "      ,[status]\n"
                    + "  FROM [A01_RT03].[dbo].[TuitionV2] where [idChild]=?");

            stmt.setString(1, idChild);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idTuition = rs.getString(1);
                String idChild1 = rs.getString(2);
                int tuition = rs.getInt(3);
                LocalDateTime datePay = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime dateStart = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime dateEnd = rs.getTimestamp(6).toLocalDateTime();
                String status = rs.getString(7);
                tuitionV2 = new TuitionV2(idTuition, idChild1, tuition, datePay, dateStart, dateEnd, status);
            }
            con.close();
           return  tuitionV2;
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
        

    }
public static void UpdateTuition(String id, int tuition) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "UPDATE [dbo].[TuitionV2] SET [tuition] = ?  WHERE [idTuition] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, tuition);
             stmt.setString(2, id);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addTuitionV2(TuitionV2 tuitionV2 , String idTuition) {
        try ( Connection con = DatabaseInfo.getConnect();  PreparedStatement stmt = con.prepareStatement("INSERT INTO [dbo].[TuitionV2] "
                + "([idTuition], [idChild], [tuition], [datePay], [dateStart], [dateEnd], [status]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, idTuition);
            stmt.setString(2, tuitionV2.getIdChild());
            stmt.setInt(3, tuitionV2.getTuition());
            stmt.setTimestamp(4, Timestamp.valueOf(tuitionV2.getDatePay()));
            stmt.setTimestamp(5, Timestamp.valueOf(tuitionV2.getDateStart()));
            stmt.setTimestamp(6, Timestamp.valueOf(tuitionV2.getDateEnd()));
            stmt.setString(7, tuitionV2.getStatus().trim());

            int value = stmt.executeUpdate();
            System.out.println("Rows affected: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static List<TuitionV2> getTuitionByIdChild(String idChild,String status) {
//        TuitionV2 tuitionV2 = null;
//        List<TuitionV2> TuitionV2 = new ArrayList<>();
//        try ( Connection con = DatabaseInfo.getConnect()) {
//            PreparedStatement stmt = con.prepareStatement("SELECT [idTuition]\n"
//                    + "      ,[idChild]\n"
//                    + "      ,[tuition]\n"
//                    + "      ,[datePay]\n"
//                    + "      ,[dateStart]\n"
//                    + "      ,[dateEnd]\n"
//                    + "      ,[status]\n"
//                    + "  FROM [A01_RT03].[dbo].[TuitionV2] where [idChild]=? and [status]='No'");
//
//            stmt.setString(1, idChild);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String idTuition = rs.getString(1);
//                String idChild1 = rs.getString(2);
//                int tuition = rs.getInt(3);
//                LocalDateTime datePay = rs.getTimestamp(4).toLocalDateTime();
//                LocalDateTime dateStart = rs.getTimestamp(5).toLocalDateTime();
//                LocalDateTime dateEnd = rs.getTimestamp(6).toLocalDateTime();
//                String status1 = rs.getString(7);
//                TuitionV2.add(new TuitionV2(idTuition, idChild1, tuition, datePay, dateStart, dateEnd, status1));
//            }
//            con.close();
//           return  TuitionV2;
//        } catch (Exception ex) {
//           throw new RuntimeException(ex);
//        }
//      
//    }
     public static boolean UpdateTuitionByIdChild(String id,String status) {
           boolean result = false;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "UPDATE [dbo].[TuitionV2] SET [status] = ?  WHERE [idChild] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, status);
             stmt.setString(2, id);
            int rs = stmt.executeUpdate();
              result = rs > 0 ? true : false;
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
      public static boolean UpdateListFeesV2ByIdChild(String id,String status) {
            boolean result = false;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "UPDATE [dbo].[ListFeesV2] SET [status] = ?  WHERE [idChild] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, status);
             stmt.setString(2, id);
            int rs = stmt.executeUpdate();
            result = rs > 0 ? true : false;
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         return result;
    }
     public static TuitionV2 getTuitionByIdChild(String idChild, String status) {
        TuitionV2 tuitionV2 = null;
        
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idTuition]\n"
                    + "      ,[idChild]\n"
                    + "      ,[tuition]\n"
                    + "      ,[datePay]\n"
                    + "      ,[dateStart]\n"
                    + "      ,[dateEnd]\n"
                    + "      ,[status]\n"
                    + "  FROM [A01_RT03].[dbo].[TuitionV2] where [idChild]=? and [status]=? ");

            stmt.setString(1, idChild);
            stmt.setString(2, status);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idTuition = rs.getString(1);
                String idChild1 = rs.getString(2);
                int tuition = rs.getInt(3);
                LocalDateTime datePay = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime dateStart = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime dateEnd = rs.getTimestamp(6).toLocalDateTime();
                String status1 = rs.getString(7);
                
                tuitionV2 =new TuitionV2(idTuition, idChild1, tuition, datePay, dateStart, dateEnd, status1);
            }
            con.close();
           return  tuitionV2;
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
        

    }
     public  ArrayList<TuitionV2> getAllTuition() {
        ArrayList<TuitionV2> tuitionV2 =   new ArrayList<>();
        
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idTuition]\n"
                    + "      ,[idChild]\n"
                    + "      ,[tuition]\n"
                    + "      ,[datePay]\n"
                    + "      ,[dateStart]\n"
                    + "      ,[dateEnd]\n"
                    + "      ,[status]\n"
                    + "  FROM [A01_RT03].[dbo].[TuitionV2]");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idTuition = rs.getString(1);
                String idChild1 = rs.getString(2);
                int tuition = rs.getInt(3);
                LocalDateTime datePay = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime dateStart = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime dateEnd = rs.getTimestamp(6).toLocalDateTime();
                String status1 = rs.getString(7);
                
                tuitionV2.add(new TuitionV2(idTuition, idChild1, tuition, datePay, dateStart, dateEnd, status1));
            }
            con.close();
           return  tuitionV2;
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
        

    }

}
