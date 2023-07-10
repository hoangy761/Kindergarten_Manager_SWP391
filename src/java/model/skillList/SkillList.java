/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.skillList;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.User.Users;

/**
 *
 * @author DELL-G3
 */
public class SkillList extends Users {

    private String idSkill;
    private String skillName;
    private String idTeacher;
    private int totalSeat;
    private LocalDateTime timeStartSemester;
    private LocalDateTime timeEndSemester;
    private int tuition;
     private String status;
     private String condition;
      private String slot;

    public SkillList() {
    }

    public SkillList(String idSkill, String skillName,  int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, int tuition, String status, String condition,String slot, String idUser, String fullName, String address, String email, String password, String idChild, String certicate, String imgAvt, String role, String gender, Date dob, String phoneNumber) {
        super(idUser, fullName, address, email, password, idChild, certicate, imgAvt, role, gender, dob, phoneNumber);
        this.idSkill = idSkill;
        this.skillName = skillName;
        this.totalSeat = totalSeat;
        this.timeStartSemester = timeStartSemester;
        this.timeEndSemester = timeEndSemester;
        this.tuition = tuition;
        this.status = status;
        this.condition = condition;
          this.slot = slot;
    }

    public SkillList(String idClass, String className, String idTeacher, int totalSeat, LocalDateTime timeStartSemester, LocalDateTime timeEndSemester, int tuition, String status, String condition,String slot) {
        this.idSkill = idClass;
        this.skillName = className;
        this.idTeacher = idTeacher;
        this.totalSeat = totalSeat;
        this.timeStartSemester = timeStartSemester;
        this.timeEndSemester = timeEndSemester;
        this.tuition = tuition;
        this.status = status;
        this.condition = condition;
         this.slot = slot;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(String idSkill) {
        this.idSkill = idSkill;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public LocalDateTime getTimeStartSemester() {
        return timeStartSemester;
    }

    public void setTimeStartSemester(LocalDateTime timeStartSemester) {
        this.timeStartSemester = timeStartSemester;
    }

    public LocalDateTime getTimeEndSemester() {
        return timeEndSemester;
    }

    public void setTimeEndSemester(LocalDateTime timeEndSemester) {
        this.timeEndSemester = timeEndSemester;
    }

    

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getStartDate1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
        String startDate1 = getTimeStartSemester().format(formatter);
        return startDate1;
    }

    

    public String getEndDate1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate1 = getTimeEndSemester().format(formatter);
        return startDate1;
    }

    public String getTimeStart1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String startDate1 = getTimeStartSemester().format(formatter);
        return startDate1;
    }

    public String getTimeEnd1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String startDate1 = getTimeEndSemester().format(formatter);
        return startDate1;
    }
}
