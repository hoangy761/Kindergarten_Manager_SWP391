/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.listfee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DBUnitil.DatabaseInfo;

/**
 *
 * @author PC
 */
public class ListFeesV2DB {
     public static List<ListFeesV2> getListFeeV2ByIdChildStatus(String idChild, String status) {
        
        List<ListFeesV2> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idPay]\n"
                    + "      ,[idNameFee]\n"
                    + "      ,[idChild]\n"
                    + "      ,[tuition]\n"
                    + "      ,[status]\n"
                    + "      ,[idTuition]\n"
                    + "  FROM [A01_RT03].[dbo].[ListFeesV2] where [idChild]=? and [status]=? ");

            stmt.setString(1, idChild);
            stmt.setString(2, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idPay = rs.getString(1);
                String idNameFee = rs.getString(2);
                 
                int tuition = Integer.parseInt(rs.getString(4));
                 
                String idTuition = rs.getString(6);
                
                list.add(new ListFeesV2(idPay, idNameFee, idChild, tuition, status, idTuition)) ;
            }
            con.close();
           return  list;
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
        

    }
}
