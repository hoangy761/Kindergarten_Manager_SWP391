/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.listfee;

/**
 *
 * @author PC
 */
public class ListFeesV2 {
    private String idPay;
    private String idNameFee;
    private String idChild;
    private int tuition;
    private String status;
    private String idTuition;

    public ListFeesV2(String idPay, String idNameFee, String idChild, int tuition, String status, String idTuition) {
        this.idPay = idPay;
        this.idNameFee = idNameFee;
        this.idChild = idChild;
        this.tuition = tuition;
        this.status = status;
        this.idTuition = idTuition;
    }

    public String getIdPay() {
        return idPay;
    }

    public void setIdPay(String idPay) {
        this.idPay = idPay;
    }

    public String getIdNameFee() {
        return idNameFee;
    }

    public void setIdNameFee(String idNameFee) {
        this.idNameFee = idNameFee;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdTuition() {
        return idTuition;
    }

    public void setIdTuition(String idTuition) {
        this.idTuition = idTuition;
    }

    
    
    
    
    
}
