/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Class;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.DBUnitil.DatabaseInfo;
import model.User.Users;
import model.User.UsersDB;

/**
 *
 * @author ASUS-PRO
 */
public class ClassListDB {

    public static boolean addClassList(ClassList classList) {
        boolean result = false;
        Connection con = null;
        try {
            con = DatabaseInfo.getConnect();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[ClassList]\n"
                        + "           ([idClass]\n"
                        + "           ,[className]\n"
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
                stmt.setString(1, classList.getIdClass());
                stmt.setString(2, classList.getClassName());
                stmt.setString(3, classList.getIdTeacher());
                stmt.setInt(4, classList.getTotalSeat());
                stmt.setTimestamp(5, Timestamp.valueOf(classList.getTimeStartSemester()));
                stmt.setTimestamp(6, Timestamp.valueOf(classList.getTimeEndSemester()));
                stmt.setInt(7, classList.getTuition());
                stmt.setString(8, classList.getStatus());
                stmt.setString(9, classList.getCondition());
                stmt.setString(10, classList.getSlot().trim());
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

    public void regisClas(String idRegist, String idChild, String idClass, String status) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "INSERT INTO [dbo].[Class] ([idRegist]\n"
                    + "           ,[idChild] ,[idClass] ,[status])  VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, idRegist);
            stmt.setString(2, idChild);
            stmt.setString(3, idClass);
            stmt.setString(4, status);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void UpdateStatus(String id, String status) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "UPDATE [dbo].[Class] SET [status] = ?  WHERE [idChild] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, id);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int getTotalSeat(String id) {
        int totalSeat = 0;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "select totalSeat from ClassList where [idClass] = ?";
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

    public static boolean delete(String id) {
        boolean result = false;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM [dbo].[Class] WHERE [Class].idClass=?");
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
            String sql = "UPDATE [dbo].[ClassList] SET [totalSeat] = totalSeat - 1  WHERE [idClass] = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ClassList getAllClassById(String id) {
        ClassList list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "	  ,Users.idUser\n"
                    + "  FROM [dbo].[ClassList]\n"
                    + "   INNER JOIN Users\n"
                    + "   ON  Users.idUser =[ClassList].[idTeacher]\n"
                    + "   Where [ClassList].[idClass]='" + id + "'");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idClass = rs.getString(1);
                String className = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idClass,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,  tuition,  status,slot
                list = new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ClassList getClassChildByIdChild(String id, String status) {
        ClassList list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT [ClassList].[idClass], [ClassList].[className], [ClassList].[idTeacher], [ClassList].[totalSeat], "
                    + "[ClassList].[timeStartSemester], [ClassList].[timeEndSemester], [ClassList].[tuition], [ClassList].[status], "
                    + "[ClassList].[condition], [ClassList].[slot] "
                    + "FROM [A01_RT03].[dbo].[ClassList] "
                    + "INNER JOIN [Class] ON [ClassList].[idClass] = [Class].[idClass] "
                    + "INNER JOIN Child ON [Class].[idChild] = Child.[idChild] "
                    + "WHERE Child.[idChild] = ? AND [Class].[status] = ? "
                    + "ORDER BY [ClassList].[className]");

            stmt.setString(1, id);
            stmt.setString(2, status);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idClass = rs.getString("idClass");
                String className = rs.getString("className");
                String idTeacher = rs.getString("idTeacher");
                int totalSeat = rs.getInt("totalSeat");
                LocalDateTime timeStartSemester = rs.getTimestamp("timeStartSemester").toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp("timeEndSemester").toLocalDateTime();
                int tuition = rs.getInt("tuition");
                String status1 = rs.getString("status");
                String condition = rs.getString("condition");
                String slot = rs.getString("slot");

                list = new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status1, condition, slot);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    public static ClassList getAllChildByIdChild2(String id) {
        ClassList list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT [ClassList].[idClass], [ClassList].[className], [ClassList].[idTeacher], [ClassList].[totalSeat], "
                    + "[ClassList].[timeStartSemester], [ClassList].[timeEndSemester], [ClassList].[tuition], [ClassList].[status], "
                    + "[ClassList].[condition], [ClassList].[slot] "
                    + "FROM [A01_RT03].[dbo].[ClassList] "
                    + "INNER JOIN [Class] ON [ClassList].[idClass] = [Class].[idClass] "
                    + "INNER JOIN Child ON [Class].[idChild] = Child.[idChild] "
                    + "WHERE Child.[idChild] = ? "
                    + "ORDER BY [ClassList].[className]");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String idClass = rs.getString("idClass");
                String className = rs.getString("className");
                String idTeacher = rs.getString("idTeacher");
                int totalSeat = rs.getInt("totalSeat");
                LocalDateTime timeStartSemester = rs.getTimestamp("timeStartSemester").toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp("timeEndSemester").toLocalDateTime();
                int tuition = rs.getInt("tuition");
                String status1 = rs.getString("status");
                String condition = rs.getString("condition");
                String slot = rs.getString("slot");

                list = new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status1, condition, slot);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    public ArrayList<ClassList> getAllClassByIdTeacher(String id, int offet) {
        ArrayList<ClassList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[ClassList].[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[ClassList] where [ClassList].[idTeacher]='" + id + "'"
                    + "order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC "
                    + "OFFSET  ? ROWS FETCH NEXT 4 ROWS ONLY;");
            stmt.setInt(1, (offet - 1) * 4);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idClass = rs.getString(1);
                String className = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                // idClass,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,  tuition,  status,slot
                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ClassList> getAllClass(int offet) {
        ArrayList<ClassList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [idClass]\n"
                    + "      ,[className]\n"
                    + "      ,[idTeacher]\n"
                    + "      ,[totalSeat]\n"
                    + "      ,[timeStartSemester]\n"
                    + "      ,[timeEndSemester]\n"
                    + "      ,[tuition]\n"
                    + "      ,[status]\n"
                    + "      ,[condition]\n"
                    + "      ,[slot]\n"
                    + "  FROM [dbo].[ClassList]\n"
                    + "  order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC\n"
                    + "  OFFSET  ? ROWS FETCH NEXT 2 ROWS ONLY");
            stmt.setInt(1, (offet - 1) * 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idClass = rs.getString(1);
                String className = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                //idClass,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,  tuition,  status,slot
                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ClassList> getAllClassByDateClass() {
        ArrayList<ClassList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[ClassList].[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[ClassList]"
                    + "order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String idClass = rs.getString(1);
                String className = rs.getString(2);
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
                        // public ClassList(String idClass, String className, int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, LocalDateTime timeFrom, LocalDateTime timeTo, int tuition, String status, String condition, 
// String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber)                       

                        list.add(new ClassList(idClass, className, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));

                    }
                }
//                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, timeFrom, timeTo, tuition, status, condition));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ClassList> getAllClassByConditionClass(String condi) {
        ArrayList<ClassList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[ClassList].[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[ClassList] where [condition]='" + condi + "'"
                    + "order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String idClass = rs.getString(1);
                String className = rs.getString(2);
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
                        // public ClassList(String idClass, String className, int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, LocalDateTime timeFrom, LocalDateTime timeTo, int tuition, String status, String condition, 
// String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber)                       

                        list.add(new ClassList(idClass, className, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));

                    }
                }
//                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, timeFrom, timeTo, tuition, status, condition));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ClassList> getAllClassByTotalSeatClassFull(String tuition1) {
        ArrayList<ClassList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[ClassList].[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[ClassList] where [totalSeat]='" + tuition1 + "'"
                    + "order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String idClass = rs.getString(1);
                String className = rs.getString(2);
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
                        // public ClassList(String idClass, String className, int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, LocalDateTime timeFrom, LocalDateTime timeTo, int tuition, String status, String condition, 
// String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber)                       

                        list.add(new ClassList(idClass, className, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));

                    }
                }
//                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, timeFrom, timeTo, tuition, status, condition));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ClassList> getAllClassByTotalSeatClass() {
        ArrayList<ClassList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[ClassList].[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "  FROM [A01_RT03].[dbo].[ClassList] where [totalSeat]!='0'"
                    + "order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String idClass = rs.getString(1);
                String className = rs.getString(2);
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
                        // public ClassList(String idClass, String className, int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, LocalDateTime timeFrom, LocalDateTime timeTo, int tuition, String status, String condition, 
// String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber)                       

                        list.add(new ClassList(idClass, className, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));

                    }
                }
//                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, timeFrom, timeTo, tuition, status, condition));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ClassList> SeacrchClassByNameAndTeacher(String search) {
        ArrayList<ClassList> list = new ArrayList<>();
        Users u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT  [ClassList].[idClass]\n"
                    + "      ,[ClassList].[className]\n"
                    + "      ,[ClassList].[idTeacher]\n"
                    + "      ,[ClassList].[totalSeat]\n"
                    + "      ,[ClassList].[timeStartSemester]\n"
                    + "      ,[ClassList].[timeEndSemester]\n"
                    + "      ,[ClassList].[tuition]\n"
                    + "      ,[ClassList].[status]\n"
                    + "      ,[ClassList].[condition]\n"
                    + "      ,[ClassList].[slot]\n"
                    + "      ,Users.idUser\n"
                    + "      ,Users.fullName\n"
                    + "  FROM [A01_RT03].[dbo].[ClassList]"
                    + " INNER JOIN Users\n"
                    + "  ON Users.idUser = [ClassList].[idTeacher]"
                    + "Where Users.fullName LIKE '%" + search + "%'"
                    + " OR [ClassList].[className] LIKE '%" + search + "%'"
                    + "OR [ClassList].[totalSeat] LIKE '%" + search + "%'"
                    + "OR [ClassList].[slot] LIKE '%" + search + "%'"
                    + "OR [ClassList].[condition] LIKE '%" + search + "%'"
                    + "order by [ClassList].[timeStartSemester] DESC,[ClassList].[timeEndSemester]ASC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String idClass = rs.getString(1);
                String className = rs.getString(2);
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
                        // public ClassList(String idClass, String className, int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, LocalDateTime timeFrom, LocalDateTime timeTo, int tuition, String status, String condition, 
// String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber)                       

                        list.add(new ClassList(idClass, className, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot, u.getIdUser(), u.getFullName(), u.getAddress(), u.getEmail(), "****", u.getIdChild(), u.getCerticate(), u.getImgAvt(), u.getRole(), u.getGender(), u.getDateOB(), u.getPhoneNumber()));

                    }
                }
//                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, timeFrom, timeTo, tuition, status, condition));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from ClassList");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

//    public static void main(String[] args) {
//        ClassListDB c = new ClassListDB();
//        List<ClassList> cs = c.getAllClassByDateClass();
//        for (ClassList c1 : cs) {
//            System.out.println(c1);
//        }
//    }
    public static ArrayList<ClassList> getAllClassAnalys() {
        ArrayList<ClassList> list = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT "
                    + "       [idClass]\n"
                    + "      ,[className]\n"
                    + "      ,[idTeacher]\n"
                    + "      ,[totalSeat]\n"
                    + "      ,[timeStartSemester]\n"
                    + "      ,[timeEndSemester]\n"
                    + "      ,[tuition]\n"
                    + "      ,[status]\n"
                    + "      ,[condition]\n"
                    + "      ,[slot]\n"
                    + "  FROM [dbo].[ClassList]");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idClass = rs.getString(1);
                String className = rs.getString(2);
                String idTeacher = rs.getString(3);
                int totalSeat = rs.getInt(4);
                LocalDateTime timeStartSemester = rs.getTimestamp(5).toLocalDateTime();
                LocalDateTime timeEndSemester = rs.getTimestamp(6).toLocalDateTime();
                int tuition = rs.getInt(7);
                String status = rs.getString(8);
                String condition = rs.getString(9);
                String slot = rs.getString(10);
                //idClass,  className,  idTeacher,  totalSeat,  timeStartSemester,  timeEndSemester,  tuition,  status,slot
                list.add(new ClassList(idClass, className, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status, condition, slot));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
