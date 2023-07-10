/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.child;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBUnitil.DatabaseInfo;

/**
 *
 * @author PC
 */
// private String idChild;
//    private String childName;
//    private String idUser;
//    private Date dob;
//    private String gender;
//    private String progress;
//    private String weight;
//    private String height;
//    private String health;
//    private String imgAvt;
public class ChildDB {

    public static boolean newChild(Child c) {
        boolean result = false;
        Connection con = null;

        try {

            con = DatabaseInfo.getConnect();
            if (con != null) {
                String sql = " INSERT INTO "
                        + " Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt) "
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, c.getIdChild());
                stmt.setString(2, c.getChildName());
                stmt.setString(3, c.getIdUser());
                stmt.setDate(4, c.getDateOB());
                stmt.setString(5, c.getGender());
                stmt.setString(6, c.getProgress());
                stmt.setDouble(7, c.getWeight());
                stmt.setInt(8, c.getHeight());
                stmt.setString(9, c.getHealth());
                stmt.setString(10, c.getImgAvt());

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

    public static List<Child> getChildbyIdParent(String idParent) {

        Connection con = null;

        List<Child> listChild = new ArrayList<>();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DatabaseInfo.getConnect();
            if (con != null) {

                String sql = "SELECT idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt,imgDob "
                        + " FROM Child "
                        + " where idUser = ?";

                pstm = con.prepareStatement(sql);
                pstm.setString(1, idParent);

                rs = pstm.executeQuery();

                while (rs.next()) {
                    String idChild = rs.getString(1);
                    String childName = rs.getString(2);
                    String idUser = rs.getString(3);
                    Date dob = rs.getDate(4);
                    String gender = rs.getString(5);
                    String progress = rs.getString(6);
                    double weight = rs.getDouble(7);
                    int height = rs.getInt(8);
                    String health = rs.getString(9);
                    String imgAvt = rs.getString(10);
                    String imgDob = rs.getString(11);
                    listChild.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChildDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChildDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChildDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listChild;
    }

    public static Child getChildbyIdChild(String idChild) {
        Child child = null;

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idChild]\n"
                    + "      ,[childName]\n"
                    + "      ,[idUser]\n"
                    + "      ,[dob]\n"
                    + "      ,[gender]\n"
                    + "      ,[progress]\n"
                    + "      ,[weight]\n"
                    + "      ,[height]\n"
                    + "      ,[health]\n"
                    + "      ,[imgAvt]\n"
                    + "      ,[imgDob]\n"
                    + "  FROM [A01_RT03].[dbo].[Child]"
                    + "  Where idChild = ? ");

            stmt.setString(1, idChild);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idChild1 = rs.getString(1);
                String childName = rs.getString(2);
                String idUser = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String progress = rs.getString(6);
                double weight = rs.getDouble(7);
                int height = rs.getInt(8);
                String health = rs.getString(9);
                String imgAvt = rs.getString(10);
                String imgDob = rs.getString(11);
                child = new Child(idChild1, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob);

            }
            con.close();

        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return child;
    }

    public static boolean updateProfileChild(Child child) {
        boolean rowUpdated = false;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Child] "
                    + "SET  "
                    + "  [childName] = ?  ,[dob] = ?  "
                    + " ,[gender] = ? ,[progress] = ? ,[weight] = ? ,[height] = ? "
                    + " ,[health] = ? ,[imgAvt] = ? ,[imgDob] = ?,[idUser] = ? "
                    + " where [idChild]=?");

            stmt.setString(1, child.getChildName());
            stmt.setString(2, child.getDob());
            stmt.setString(3, child.getGender());
            stmt.setString(4, child.getProgress());
            stmt.setDouble(5, child.getWeight());
            stmt.setInt(6, child.getHeight());
            stmt.setString(7, child.getHealth());
            stmt.setString(8, child.getImgAvt());
            stmt.setString(9, child.getImgDob());
            stmt.setString(10, child.getIdUser());
            stmt.setString(11, child.getIdChild());

            rowUpdated = stmt.executeUpdate() > 0;

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return rowUpdated;

    }

    public static ArrayList<Child> getAllChildByIdChildAndStatusSkill(String id, String status) {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("  SELECT Child.idChild, Child.childName, Child.idUser, Child.dob, Child.gender, Child.progress, Child.weight, Child.height, Child.health, Child.imgAvt, Child.imgDob, Skill.status, Class.status\n"
                    + "                FROM Child\n"
                    + "               LEFT JOIN Skill ON Child.idChild = Skill.idChild AND Skill.status = '" + status + "    '\n"
                    + "			    INNER JOIN Class ON Child.idChild = Class.idChild\n"
                    + "                WHERE  Child.idUser='" + id + "' And  Class.status='" + status + "    '\n"
                    + "               ORDER BY Child.childName");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(1);
                String childName = rs.getString(2);
                String idUser = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String progress = rs.getString(6);
                double weight = rs.getDouble(7);
                int height = rs.getInt(8);
                String health = rs.getString(9);
                String imgAvt = rs.getString(10);
                String imgDob = rs.getString(11);
                String status1 = rs.getString(12);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob, status1));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    public static ArrayList<Child> getAllChildByIdChildAndStatusClass(String id, String status) {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT Child.idChild, Child.childName, Child.idUser, Child.dob, Child.gender, Child.progress, "
                    + "Child.weight, Child.height, Child.health, Child.imgAvt, Child.imgDob, Class.status\n"
                    + "                    FROM Child\n"
                    + " LEFt JOIN Class ON Child.idChild = Class.idChild AND Class.status = '" + status + "    '\n"
                    + "                   WHERE( NOT EXISTS (SELECT 1 FROM Class WHERE Class.idChild = Child.idChild) OR Class.status != '" + status + "    ')And Child.idUser='" + id + "'\n"
                    + "                   ORDER BY Child.childName");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(1);
                String childName = rs.getString(2);
                String idUser = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String progress = rs.getString(6);
                double weight = rs.getDouble(7);
                int height = rs.getInt(8);
                String health = rs.getString(9);
                String imgAvt = rs.getString(10);
                String imgDob = rs.getString(11);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob,status));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    public static void updateImageChild(String idChild, String img) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Child] "
                    + "SET  [imgAvt] = ? where [idChild]=?");

            stmt.setString(1, img);
            stmt.setString(2, idChild);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateImageDobChild(String idChild, String imgDob) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Child] "
                    + "SET  [imgDob] = ? where [idChild]=?");

            stmt.setString(1, imgDob);
            stmt.setString(2, idChild);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Child> getAllChildByIdClass(String id, String status) {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,Child.idChild\n"
                    + "      ,Child.[childName]\n"
                    + "      ,Child.[idUser]\n"
                    + "      ,Child.[dob]\n"
                    + "      ,Child.[gender]\n"
                    + "      ,Child.[progress]\n"
                    + "      ,Child.[weight]\n"
                    + "      ,Child.[height]\n"
                    + "      ,Child.[health]\n"
                    + "      ,Child.[imgAvt]\n"
                    + "      ,Child.[imgDob]\n"
                    + "    ,Class.[status]\n"
                    + "  FROM [A01_RT03].[dbo].[Class]\n"
                    + "  INNER JOIN Child\n"
                    + "  ON Child.idChild  = [Class].idChild\n"
                    + "   INNER JOIN [ClassList]\n"
                    + "  ON [ClassList].[idClass]  = [Class].idClass\n"
                    + "  where [ClassList].[idClass] ='" + id + "' AND Class.[status] ='" + status + "' \n"
                    + "  order by childName");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(2);
                String childName = rs.getString(3);
                String idUser = rs.getString(4);
                Date dob = rs.getDate(5);
                String gender = rs.getString(6);
                String progress = rs.getString(7);
                double weight = rs.getDouble(8);
                int height = rs.getInt(9);
                String health = rs.getString(10);
                String imgAvt = rs.getString(11);
                String imgDob = rs.getString(12);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public ArrayList<Child> getAllChildByStatus(String status) {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,Child.idChild\n"
                    + "      ,Child.[childName]\n"
                    + "      ,Child.[idUser]\n"
                    + "      ,Child.[dob]\n"
                    + "      ,Child.[gender]\n"
                    + "      ,Child.[progress]\n"
                    + "      ,Child.[weight]\n"
                    + "      ,Child.[height]\n"
                    + "      ,Child.[health]\n"
                    + "      ,Child.[imgAvt]\n"
                    + "      ,Child.[imgDob]\n"
                    + "    ,Class.[status]\n"
                    + "  FROM [A01_RT03].[dbo].[Class]\n"
                    + "  INNER JOIN Child\n"
                    + "  ON Child.idChild  = [Class].idChild\n"
                    + "   INNER JOIN [ClassList]\n"
                    + "  ON [ClassList].[idClass]  = [Class].idClass\n"
                    + "  where Class.[status] ='" + status + "' \n"
                    + "  order by childName");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(2);
                String childName = rs.getString(3);
                String idUser = rs.getString(4);
                Date dob = rs.getDate(5);
                String gender = rs.getString(6);
                String progress = rs.getString(7);
                double weight = rs.getDouble(8);
                int height = rs.getInt(9);
                String health = rs.getString(10);
                String imgAvt = rs.getString(11);
                String imgDob = rs.getString(12);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public ArrayList<Child> getAllChildByStatus2(String status) {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "       ,Child.idChild \n"
                    + "	   ,Child.[childName]   \n"
                    + "       ,Child.[idUser] \n"
                    + "       ,Child.[dob]\n"
                    + "	   ,Child.[gender]\n"
                    + "	   ,Child.[progress] \n"
                    + "	   ,Child.[weight]\n"
                    + "	   ,Child.[height]\n"
                    + "	   ,Child.[health]\n"
                    + "	   ,Child.[imgAvt]\n"
                    + "      ,Child.[imgDob]\n"
                    + "    ,Skill.[status]\n"
                    + "FROM [A01_RT03].[dbo].[Skill]\n"
                    + "INNER JOIN Child \n"
                    + "ON Child.idChild  = [Skill].idChild   \n"
                    + "INNER JOIN [SkillList] \n"
                    + "ON [SkillList].[idSkill]  = [Skill].idSkill \n"
                    + "  where  Skill.[status] ='" + status + "' \n"
                    + "order by childName");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(2);
                String childName = rs.getString(3);
                String idUser = rs.getString(4);
                Date dob = rs.getDate(5);
                String gender = rs.getString(6);
                String progress = rs.getString(7);
                double weight = rs.getDouble(8);
                int height = rs.getInt(9);
                String health = rs.getString(10);
                String imgAvt = rs.getString(11);
                String imgDob = rs.getString(12);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public ArrayList<Child> getAllChildByIdSkill(String id, String status) {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "       ,Child.idChild \n"
                    + "	   ,Child.[childName]   \n"
                    + "       ,Child.[idUser] \n"
                    + "       ,Child.[dob]\n"
                    + "	   ,Child.[gender]\n"
                    + "	   ,Child.[progress] \n"
                    + "	   ,Child.[weight]\n"
                    + "	   ,Child.[height]\n"
                    + "	   ,Child.[health]\n"
                    + "	   ,Child.[imgAvt]\n"
                    + "      ,Child.[imgDob]\n"
                    + "    ,Skill.[status]\n"
                    + "FROM [A01_RT03].[dbo].[Skill]\n"
                    + "INNER JOIN Child \n"
                    + "ON Child.idChild  = [Skill].idChild   \n"
                    + "INNER JOIN [SkillList] \n"
                    + "ON [SkillList].[idSkill]  = [Skill].idSkill \n"
                    + "  where [SkillList].[idSkill] ='" + id + "' AND Skill.[status] ='" + status + "' \n"
                    + "order by childName");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(2);
                String childName = rs.getString(3);
                String idUser = rs.getString(4);
                Date dob = rs.getDate(5);
                String gender = rs.getString(6);
                String progress = rs.getString(7);
                double weight = rs.getDouble(8);
                int height = rs.getInt(9);
                String health = rs.getString(10);
                String imgAvt = rs.getString(11);
                String imgDob = rs.getString(12);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public ArrayList<Child> getAllChild() {
        ArrayList<Child> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idChild]\n"
                    + "      ,[childName]\n"
                    + "      ,[idUser]\n"
                    + "      ,[dob]\n"
                    + "      ,[gender]\n"
                    + "      ,[progress]\n"
                    + "      ,[weight]\n"
                    + "      ,[height]\n"
                    + "      ,[health]\n"
                    + "      ,[imgAvt]\n"
                    + "      ,[imgDob]\n"
                    + "  FROM [A01_RT03].[dbo].[Child]");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idChild = rs.getString(1);
                String childName = rs.getString(2);
                String idUser = rs.getString(3);
                Date dob = rs.getDate(4);
                String gender = rs.getString(5);
                String progress = rs.getString(6);
                double weight = rs.getDouble(7);
                int height = rs.getInt(8);
                String health = rs.getString(9);
                String imgAvt = rs.getString(10);
                String imgDob = rs.getString(11);
                list.add(new Child(idChild, childName, idUser, dob, gender, progress, weight, height, health, imgAvt, imgDob));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static void main(String[] args) {
        Child c = ChildDB.getChildbyIdChild("llp3525945");

        System.out.println(LocalDate.now().getYear() - c.getDateOB().toLocalDate().getYear());
    }
}
