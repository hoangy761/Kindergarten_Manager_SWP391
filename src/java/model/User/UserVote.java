/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class UserVote {
    
    private String idVote;
    private String idUser;
    private int vote;
    private LocalDateTime date;
    private String idProposal;

    public UserVote() {
    }

//    public UserVote(String idUser, int vote, LocalDateTime date, String idProposal) {
//        this.idUser = idUser;
//        this.vote = vote;
//        this.date = date;
//        this.idProposal = idProposal;
//    }

    public UserVote(String idVote, String idUser, int vote, LocalDateTime date, String idProposal) {
        this.idVote = idVote;
        this.idUser = idUser;
        this.vote = vote;
        this.date = date;
        this.idProposal = idProposal;
    }

    public String getIdVote() {
        return idVote;
    }

    public void setIdVote(String idVote) {
        this.idVote = idVote;
    }
    
    

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public String getTimeStartF() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String startDate1 = getDate().format(formatter);
        return startDate1;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getIdProposal() {
        return idProposal;
    }

    public void setIdProposal(String idProposal) {
        this.idProposal = idProposal;
    }
    
    
}
