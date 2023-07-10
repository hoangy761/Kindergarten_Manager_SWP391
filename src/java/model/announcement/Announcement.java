/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.announcement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class Announcement {
    private String idAnn;
    private String idUser;
    private LocalDateTime datePost;
    private String titleAnn;
    private String contentAnn;
    private String status;

    
    public Announcement() {
        
    }
    

    public Announcement(String idAnn, String idUser, LocalDateTime datePost, String titleAnn, String contentAnn, String status) {
        this.idAnn = idAnn;
        this.idUser = idUser;
        this.datePost = datePost;
        this.titleAnn = titleAnn;
        this.contentAnn = contentAnn;
        this.status = status;
    }

    public String getIdAnn() {
        return idAnn;
    }

    public void setIdAnn(String idAnn) {
        this.idAnn = idAnn;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDatePost() {
        return datePost;
    }
    
     public String getDatePostF() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String getDatePost1 = getDatePost().format(formatter);
        return getDatePost1;
    }

    public void setDatePost(LocalDateTime datePost) {
        this.datePost = datePost;
    }

    public String getTitleAnn() {
        return titleAnn;
    }

    public void setTitleAnn(String titleAnn) {
        this.titleAnn = titleAnn;
    }

    public String getContentAnn() {
        return contentAnn;
    }

    public void setContentAnn(String contentAnn) {
        this.contentAnn = contentAnn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
