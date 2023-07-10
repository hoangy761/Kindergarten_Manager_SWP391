/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.proposal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class Proposal {

    private String idProposal;
    private String idUser;
    private String title;
    private String contentProposal;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private int accept;
    private String status;
    private int totalVote;

    public Proposal() {
    }

//    public Proposal(String idProposal, String idUser, String title, String contentProposal, LocalDateTime timeStart, LocalDateTime timeEnd, int accept, String status) {
//        this.idProposal = idProposal;
//        this.idUser = idUser;
//        this.title = title;
//        this.contentProposal = contentProposal;
//        this.timeStart = timeStart;
//        this.timeEnd = timeEnd;
//        this.accept = accept;
//        this.status = status;
//    }

    public Proposal(String idProposal, String idUser, String title, String contentProposal, LocalDateTime timeStart, LocalDateTime timeEnd, int accept, String status, int totalVote) {
        this.idProposal = idProposal;
        this.idUser = idUser;
        this.title = title;
        this.contentProposal = contentProposal;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.accept = accept;
        this.status = status;
        this.totalVote = totalVote;
    }

    public int getTotalVote() {
        return totalVote;
    }

    public void setTotalVote(int totalVote) {
        this.totalVote = totalVote;
    }
    
    

    public String getIdProposal() {
        return idProposal;
    }

    public void setIdProposal(String idProposal) {
        this.idProposal = idProposal;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentProposal() {
        return contentProposal;
    }

    public void setContentProposal(String contentProposal) {
        this.contentProposal = contentProposal;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStartF() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String startDate1 = getTimeStart().format(formatter);
        return startDate1;
    }

    public String getTimeEndF() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String startDate1 = getTimeEnd().format(formatter);
        return startDate1;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
