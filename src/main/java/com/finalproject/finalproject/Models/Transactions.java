package com.finalproject.finalproject.Models;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @Column(name = "transactionid")
    private String Transactionid;
    @Column(name = "receiptnumber")
    private long ReceiptNumber;
    @Column(name = "employee_id")
    private String Employeeid;
    @Column(name = "customer_id")
    private String Customerid;
    @Column(name = "inventory_id")
    private String Inventoryid;


    public Transactions(){

    }

    public Transactions(String Transactionid, String Employeeid, String Customerid, String Inventoryid, int Receiptnumber) {
        this.Transactionid = Transactionid;
        this.Employeeid = Employeeid;
        this.Customerid = Customerid;
        this.Inventoryid = Inventoryid;
        this.ReceiptNumber = Receiptnumber;


    }
    public String getTransactionid() {
        return Transactionid;
    }

    public void setTransactionid(String Transactionid) {
        this.Transactionid = Transactionid;
    }

    public String getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(String Employeeid) {
        this.Employeeid = Employeeid;
    }

    public String getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(String Customerid) {
        this.Customerid = Customerid;
    }

    public String getInventoryid() {return Inventoryid;}

    public void setInventoryid(String Inventoryid) {this.Inventoryid = Inventoryid;}

    public long getReceiptNumber() {return ReceiptNumber; }

    public void setReceiptNumber(long ReceiptNumber) {this.ReceiptNumber = ReceiptNumber;}
}
