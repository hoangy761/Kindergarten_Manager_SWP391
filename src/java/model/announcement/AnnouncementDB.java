/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.announcement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.DBUnitil.DatabaseInfo;
import model.proposal.Proposal;

/**
 *
 * @author PC
 */
public class AnnouncementDB {

    public static boolean newAnnouncement(Announcement ann) {
        boolean result = false;
        Connection con = null;

        try {

            con = DatabaseInfo.getConnect();
            if (con != null) {
                String sql = "INSERT INTO Announce "
                        + "(idAnn, idUser, datePost, titleAnn, contentAnn, status)"
                        + " VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, ann.getIdAnn());
                stmt.setString(2, ann.getIdUser());
                stmt.setObject(3, ann.getDatePost());
                stmt.setString(4, ann.getTitleAnn());
                stmt.setString(5, ann.getContentAnn());
                stmt.setString(6, ann.getStatus());

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

    public static List<Announcement> getAnnouncementAll() throws SQLException {
        Connection con = null;

        List<Announcement> listAnn = new ArrayList<>();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DatabaseInfo.getConnect();
            if (con != null) {

                String sql = "SELECT idAnn, idUser, datePost, titleAnn, contentAnn, status "
                        + " FROM Announce ";

                pstm = con.prepareStatement(sql);

                rs = pstm.executeQuery();

                while (rs.next()) {
                    String idAnn = rs.getString(1);
                    String idUser = rs.getString(2);
                    LocalDateTime datePost = rs.getTimestamp("datePost").toLocalDateTime();
                    String titleAnn = rs.getString(4);
                    String contentAnn = rs.getString(5);
                    String status = rs.getString(6);

                    listAnn.add(new Announcement(idAnn, idUser, datePost, titleAnn, contentAnn, status));

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listAnn;
    }

}
