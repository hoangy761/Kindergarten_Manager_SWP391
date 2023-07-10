/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tuition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS-PRO
 */
public class TuitionV2 {

    private String idTuition;
    private String idChild;
    private int tuition;
    private LocalDateTime datePay;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String status;

    public TuitionV2(String idTuition, String idChild, int tuition, LocalDateTime datePay, LocalDateTime dateStart, LocalDateTime dateEnd, String status) {
        this.idTuition = idTuition;
        this.idChild = idChild;
        this.tuition = tuition;
        this.datePay = datePay;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public String getIdTuition() {
        return idTuition;
    }

    public void setIdTuition(String idTuition) {
        this.idTuition = idTuition;
    }

    public String getIdChild() {
        return idChild;
    }

    public void setIdChild(String idChild) {
        this.idChild = idChild;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public LocalDateTime getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDateTime datePay) {
        this.datePay = datePay;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     public String getStartDate1() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
         String startDate1 =getDateStart().format(formatter);
        return startDate1;
    }
    
    public String getEndDate1() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
         String startDate1 =getDateEnd().format(formatter);
        return startDate1;
    }
public String getTimeStart1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String startDate1 = getDateStart().format(formatter);
        return startDate1;
    }

    public String getTimeEnd1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String startDate1 = getDateEnd().format(formatter);
        return startDate1;
    }
}
