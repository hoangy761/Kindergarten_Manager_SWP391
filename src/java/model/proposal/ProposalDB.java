/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.proposal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.DBUnitil.DatabaseInfo;
import model.User.UserVote;

/**
 *
 * @author PC
 */
public class ProposalDB {

    public static boolean newProposal(Proposal pro) {
        boolean result = false;
        Connection con = null;

        try {

            con = DatabaseInfo.getConnect();
            if (con != null) {
                String sql = "INSERT INTO Proposal "
                        + "(idProposal, idUser, title, contentProposal, timeStart, timeEnd, accept, status, totalVote)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, pro.getIdProposal());
                stmt.setString(2, pro.getIdUser());
                stmt.setString(3, pro.getTitle());
                stmt.setString(4, pro.getContentProposal());
                stmt.setObject(5, pro.getTimeStart());
                stmt.setObject(6, pro.getTimeEnd());
                stmt.setInt(7, pro.getAccept());
                stmt.setString(8, pro.getStatus());
                stmt.setInt(9, pro.getTotalVote());

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

    public static List<Proposal> getProposalAll() throws SQLException {

        Connection con = null;

        List<Proposal> listProposal = new ArrayList<>();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DatabaseInfo.getConnect();
            if (con != null) {

                String sql = "SELECT idProposal, idUser, title, contentProposal, timeStart, timeEnd, accept, status, totalVote "
                        + " FROM Proposal ";

                pstm = con.prepareStatement(sql);

                rs = pstm.executeQuery();

                while (rs.next()) {
                    String idProposal = rs.getString(1);
                    String idUser = rs.getString(2);
                    String title = rs.getString(3);
                    String contentProposal = rs.getString(4);

                    LocalDateTime timeStart = rs.getTimestamp("timeStart").toLocalDateTime();

                    LocalDateTime timeEnd = rs.getTimestamp("timeEnd").toLocalDateTime();

                    int accept = rs.getInt(7);

                    String status = rs.getString(8);

                    int totalVote = rs.getInt(9);

                    listProposal.add(new Proposal(idProposal, idUser, title, contentProposal, timeStart, timeEnd, accept, status, totalVote));

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
        return listProposal;
    }

    public static Proposal getProposalById(String idProposal) throws SQLException {

        Connection con = null;

        Proposal pro = null;

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DatabaseInfo.getConnect();
            if (con != null) {

                String sql = "SELECT idProposal, idUser, title, contentProposal, timeStart, timeEnd, accept, status, totalVote "
                        + " FROM Proposal "
                        + " Where idProposal =?";

                pstm = con.prepareStatement(sql);
                pstm.setString(1, idProposal);
                rs = pstm.executeQuery();

                while (rs.next()) {

                    String idUser = rs.getString(2);
                    String title = rs.getString(3);
                    String contentProposal = rs.getString(4);
                    LocalDateTime timeStart = rs.getTimestamp("timeStart").toLocalDateTime();
                    LocalDateTime timeEnd = rs.getTimestamp("timeEnd").toLocalDateTime();

//                    LocalDateTime timeStart = (LocalDateTime) rs.getObject(5);
//                    LocalDateTime timeEnd = (LocalDateTime) rs.getObject(6);
                    int accept = rs.getInt(7);
                    String status = rs.getString(8);
                    int totalVote = rs.getInt(9);

                    pro = new Proposal(idProposal, idUser, title, contentProposal, timeStart, timeEnd, accept, status, totalVote);

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
        return pro;
    }

    public static boolean setCountAcceptVote(UserVote userVote) {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            con = DatabaseInfo.getConnect();
            if (con != null) {

                if (userVote.getVote() == 1) {
                    String sql = "Update [Proposal] \n"
                            + "  set [accept] = [accept]+1 , [totalVote] = [totalVote]+1\n"
                            + "  where [idProposal] = ? ";

                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, userVote.getIdProposal());
                }
                if (userVote.getVote() == 0) {
                    String sql = "Update [Proposal] \n"
                            + "  set [totalVote] = [totalVote]+1\n"
                            + "  where [idProposal] = ? ";

                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, userVote.getIdProposal());
                }

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
    
    public static boolean updateStatusProposal(Proposal pro) {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            con = DatabaseInfo.getConnect();
            if (con != null) {

                
                    String sql = "Update [Proposal] \n"
                            + "  set [status] = 'close'\n"
                            + "  where [idProposal] = ? ";

                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, pro.getIdProposal());
                

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
    

    public static void checkTimeEnd(List<Proposal> list) {
        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < list.size(); i++) {
            Proposal get = list.get(i);
            int comparisonResult = now.compareTo(get.getTimeEnd());
            if (comparisonResult > 0) {
                // Update thành Close
                updateStatusProposal(get);
//                System.out.println(get.getTimeEnd() + "is earlier than " + now);
            }
        }

    }
    
     public static void main(String[] args) throws SQLException {
        checkTimeEnd(ProposalDB.getProposalAll());
    }

}
