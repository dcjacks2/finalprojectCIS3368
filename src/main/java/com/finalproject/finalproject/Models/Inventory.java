package com.finalproject.finalproject.Models;
import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "invdescription")
    private String invDescription;
    @Column(name = "invprice")
    private double invPrice;


    public Inventory(){

    }

    public Inventory(String id, String invDescription, double invPrice) {
        this.id = id;
        this.invDescription = invDescription;
        this.invPrice = invPrice;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) { this.invDescription = invDescription; }

    public double getInvPrice() {        return invPrice;    }

    public void setInvPrice(double invPrice) { this.invPrice = invPrice; }





}

