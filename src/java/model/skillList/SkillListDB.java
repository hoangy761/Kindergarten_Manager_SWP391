/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.skillList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.DBUnitil.DatabaseInfo;
import model.User.Users;
import model.User.UsersDB;

/**
 *
 * @author DELL-G3
 */
public class SkillListDB {

    public static boolean addSkillList(SkillList skillList) {
        boolean result = false;
        Connection con = null;
        try {
            con = DatabaseInfo.getConnect();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[SkillList]\n"
                        + "           ([idSkill]\n"
                        + "           ,[skillName]\n"
                        + "           ,[idTeacher]\n"
                        + "           ,[totalSeat]\n"
                        + "           ,[timeStartSemester]\n"
                        + "           ,[timeEndSemester]\n"
                        + "           ,[tuition]\n"
                        + "           ,[status]\n"
                        + "           ,[condition]\n"
                        + "           ,[slot])\n"
                        + "     VALUES\n"
                        + "           (?,? ,? ,?,? ,? ,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, skillList.getIdSkill());
                stmt.setString(2, skillList.getSkillName());
                stmt.setString(3, skillList.getIdTeacher());
                stmt.setInt(4, skillList.getTotalSeat());
                stmt.setTimestamp(5, Timestamp.valueOf(skillList.getTimeStartSemester()));
                stmt.setTimestamp(6, Timestamp.valueOf(skillList.getTimeEndSemester()));
                stmt.setInt(7, skillList.getTuition());
                stmt.setString(8, skillList.getStatus());
                stmt.setString(9, skillList.getCondition());
                stmt.setString(10, skillList.getSlot().trim());
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

    public static List<SkillList> getAllChildByIdChildSkillAccept(String id, String status) {
    List<SkillList> list = new ArrayList<SkillList>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT [SkillList].[idSkill], [SkillList].[skillName], [SkillList].[idTeacher], [SkillList].[totalSeat], "
                    + "[SkillList].[timeStartSemester], [SkillList].[timeEndSemester], [SkillList].[tuition], [SkillList].[status], "
                    + "[SkillList].[condition], [SkillList].[slot] "
                    + "FROM [A01_RT03].[dbo].[SkillList] "
                    + "INNER JOIN [Skill] ON [SkillList].[idSkill] = [Skill].[idSkill] "
                    + "INNER JOIN Child ON [Skill].[idChild] = Child.[idChild] "
                    + "WHERE Child.[idChild] = ? AND [Skill].[status] = ? "
                    + "ORDER BY [SkillList].[skillName]");

            stmt.setString(1, id);
            stmt.setString(2, status);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString("idSkill");
                String skillName = rs.getString("skillName");
                String idTeacher = rs.getString("idTeacher");
                int totalSeat = rs.getInt("totalSeat");
                LocalDateTime timeStartSemester = rs.getTimestamp("timeStartSemester").toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp("timeEndSemester").toLocalDateTime();
                int tuition = rs.getInt("tuition");
                String status1 = rs.getString("status");
                String condition = rs.getString("condition");
                String slot = rs.getString("slot");

                list.add(new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status1, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }}

    public void regisClas(String idRegist, String idChild, String idSkill, String status) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "INSERT INTO [dbo].[Skill] ([idRegist]\n"
                    + "           ,[idChild] ,[idSkill] ,[status])  VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, idRegist);
            stmt.setString(2, idChild);
            stmt.setString(3, idSkill);
            stmt.setString(4, status);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SkillList getAllChildByIdChild(String id, String status) {
        SkillList list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT [SkillList].[idSkill], [SkillList].[skillName], [SkillList].[idTeacher], [SkillList].[totalSeat], "
                    + "[SkillList].[timeStartSemester], [SkillList].[timeEndSemester], [SkillList].[tuition], [SkillList].[status], "
                    + "[SkillList].[condition], [SkillList].[slot] "
                    + "FROM [A01_RT03].[dbo].[SkillList] "
                    + "INNER JOIN [Skill] ON [SkillList].[idSkill] = [Skill].[idSkill] "
                    + "INNER JOIN Child ON [Skill].[idChild] = Child.[idChild] "
                    + "WHERE Child.[idChild] = ? AND [Skill].[status] = ? "
                    + "ORDER BY [SkillList].[skillName]");

            stmt.setString(1, id);
            stmt.setString(2, status);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idSkill = rs.getString("idSkill");
                String skillName = rs.getString("skillName");
                String idTeacher = rs.getString("idTeacher");
                int totalSeat = rs.getInt("totalSeat");
                LocalDateTime timeStartSemester = rs.getTimestamp("timeStartSemester").toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp("timeEndSemester").toLocalDateTime();
                int tuition = rs.getInt("tuition");
                String status1 = rs.getString("status");
                String condition = rs.getString("condition");
                String slot = rs.getString("slot");

                list = new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status1, condition, slot);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static SkillList getAllChildByIdChild2(String id) {
        SkillList list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT [SkillList].[idSkill], [SkillList].[skillName], [SkillList].[idTeacher], [SkillList].[totalSeat], "
                    + "[SkillList].[timeStartSemester], [SkillList].[timeEndSemester], [SkillList].[tuition], [SkillList].[status], "
                    + "[SkillList].[condition], [SkillList].[slot] "
                    + "FROM [A01_RT03].[dbo].[SkillList] "
                    + "INNER JOIN [Skill] ON [SkillList].[idSkill] = [Skill].[idSkill] "
                    + "INNER JOIN Child ON [Skill].[idChild] = Child.[idChild] "
                    + "WHERE Child.[idChild] = ? "
                    + "ORDER BY [SkillList].[skillName]");

            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idSkill = rs.getString("idSkill");
                String skillName = rs.getString("skillName");
                String idTeacher = rs.getString("idTeacher");
                int totalSeat = rs.getInt("totalSeat");
                LocalDateTime timeStartSemester = rs.getTimestamp("timeStartSemester").toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp("timeEndSemester").toLocalDateTime();
                int tuition = rs.getInt("tuition");
                String status1 = rs.getString("status");
                String condition = rs.getString("condition");
                String slot = rs.getString("slot");

                list = new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status1, condition, slot);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    public static boolean delete(String id) {
        boolean result = false;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM [dbo].[Skill] WHERE [Skill].idSkill=?");
            stmt.setString(1, id);
            int rc = stmt.executeUpdate();
            result = rc > 0 ? true : false;
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException("Delete faile!");
        }
        return result;
    }

    public static void UpdateSubTotalSeat(String id) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "UPDATE [dbo].[SkillList] SET [totalSeat] = totalSeat - 1  WHERE [idSkill] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void UpdateStatus(String id, String status) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "UPDATE [dbo].[Skill] SET [status] = ?  WHERE [idChild] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, id);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<SkillList> getAllSkillByIdTeacher(String id, int offet) {
        ArrayList<SkillList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList] where [SkillList].[idTeacher]='" + id + "'"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC"
                    + " OFFSET  ? ROWS FETCH NEXT 4 ROWS ONLY;");
            stmt.setInt(1, (offet - 1) * 4);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idSkill,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,   tuition,  status,slot
                list.add(new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public SkillList getAllSkillById(String id) {
        SkillList list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[condition]\n"
                    + "      ,[slot]\n"
                    + "	  ,Users.idUser\n"
                    + "  FROM [dbo].[SkillList]\n"
                    + "   INNER JOIN Users\n"
                    + "   ON  Users.idUser =[SkillList].[idTeacher]\n"
                    + "   Where [SkillList].[idSkill]='" + id + "'");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idSkill,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,   tuition,  status,slot

                list = new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<SkillList> getAllSkilOffet(int offet) {
        ArrayList<SkillList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList]"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC"
                    + " OFFSET  ? ROWS FETCH NEXT 2 ROWS ONLY;");
            stmt.setInt(1, (offet - 1) * 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idSkill,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,   tuition,  status,slot
                list.add(new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<SkillList> getAllSkil() {
        ArrayList<SkillList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList]"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idSkill,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,   tuition,  status,slot
                list.add(new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ArrayList<SkillList> getAllSkilAnalys() {
        ArrayList<SkillList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList]"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idSkill,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,   tuition,  status,slot
                list.add(new SkillList(idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from SkillList");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public static int getTotalSeat(String id) {
        int totalSeat = 0;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "select totalSeat from SkillList where [idSkill] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                totalSeat = rs.getInt(1);
            }
            con.close();
            return totalSeat;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<SkillList> getAllSkillByDate() {
        ArrayList<SkillList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList]"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                if (idTeacher != null) {
                    u = UsersDB.getUserById(idTeacher);
                    if (u != null) {
                        list.add(new SkillList(idSkill, skillName, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));
                    }
                }

            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<SkillList> getAllSkillByCondition(String condi) {
        ArrayList<SkillList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList] where condition='" + condi + "'"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                if (idTeacher != null) {
                    u = UsersDB.getUserById(idTeacher);
                    if (u != null) {
                        list.add(new SkillList(idSkill, skillName, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));
                    }
                }

            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<SkillList> getAllSkillByTotalSeatFull(String totalSeat1) {
        ArrayList<SkillList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList] where totalSeat='" + totalSeat1 + "'"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                if (idTeacher != null) {
                    u = UsersDB.getUserById(idTeacher);
                    if (u != null) {
                        list.add(new SkillList(idSkill, skillName, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));
                    }
                }

            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<SkillList> getAllSkillByTotalSeat() {
        ArrayList<SkillList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList] where totalSeat!='0'"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                if (idTeacher != null) {
                    u = UsersDB.getUserById(idTeacher);
                    if (u != null) {
                        list.add(new SkillList(idSkill, skillName, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));
                    }
                }

            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<SkillList> SeacrchSkillByNameAndTeacher(String search) {
        ArrayList<SkillList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [SkillList].[idSkill]\n"
                    + "      ,[SkillList].[skillName]\n"
                    + "      ,[SkillList].[idTeacher]\n"
                    + "      ,[SkillList].[totalSeat]\n"
                    + "      ,[SkillList].[timeStartSemester]\n"
                    + "      ,[SkillList].[timeEndSemester]\n"
                    + "      ,[SkillList].[tuition]\n"
                    + "      ,[SkillList].[status]\n"
                    + "      ,[SkillList].[condition]\n"
                    + "      ,[SkillList].[slot]\n"
                    + "      ,Users.idUser\n"
                    + "      ,Users.fullName\n"
                    + "  FROM [A01_RT03].[dbo].[SkillList] "
                    + " INNER JOIN Users\n"
                    + "  ON Users.idUser = [SkillList].[idTeacher]"
                    + "Where Users.fullName LIKE '%"+ search +"%'"
                    + " OR [SkillList].[skillName] LIKE '%"+ search +"%'"
                    + " OR [SkillList].[totalSeat] LIKE '%"+ search +"%'"
                    + " OR [SkillList].[slot] LIKE '%"+ search +"%'"
                    + " OR [SkillList].[condition] LIKE '%"+ search +"%'"
                    + "order by [SkillList].[timeStartSemester] DESC,[SkillList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idSkill = rs.getString(1);
                String skillName = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                if (idTeacher != null) {
                    u = UsersDB.getUserById(idTeacher);
                    if (u != null) {
                        list.add(new SkillList(idSkill, skillName, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));
                    }
                }

            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
