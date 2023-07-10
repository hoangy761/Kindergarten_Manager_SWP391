/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import model.DBUnitil.DatabaseInfo;

/**
 *
 * @author PC
 */
public class UserVoteDB {

    public static boolean voteProposal(UserVote userVote) {
        boolean result = false;
        Connection con = null;

        try {

            con = DatabaseInfo.getConnect();
            if (con != null) {
                String sql = "INSERT INTO UserVote "
                        + "(idVote, idUser, vote, date, idProposal)"
                        + " VALUES (?, ?, ?, ?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, userVote.getIdVote());
                stmt.setString(2, userVote.getIdUser());
                stmt.setInt(3, userVote.getVote());
                stmt.setObject(4, userVote.getDate());
                stmt.setString(5, userVote.getIdProposal());

                int value = stmt.executeUpdate();

                result = value > 0 ? true : false;
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    public static UserVote checkVoted(String idUser, String idProposal) {
        UserVote userVote = null;

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT "
                    + "      [idVote]\n"
                    + "      ,[idUser]\n"
                    + "      ,[vote]\n"
                    + "      ,[date]\n"
                    + "      ,[idProposal]\n"
                    + "  FROM [A01_RT03].[dbo].[UserVote]\n"
                    + "  where [idUser] = ? and [idProposal] = ? ");
            stmt.setString(1, idUser);
            stmt.setString(2, idProposal);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                String idVote = rs.getString(1);
//                String idUser = rs.getString(2);
                int vote = rs.getInt(3);
                LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();

                userVote = new UserVote(idVote, idUser, vote, date, idProposal);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        return userVote;
    }

}
