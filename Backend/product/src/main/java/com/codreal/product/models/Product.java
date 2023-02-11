package com.codreal.product.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "sequence";

    @Id
    private int pid;

    private String pname;
    private String pcategory;
    private Date pdatepost = new Date(System.currentTimeMillis());
    private String description;
    private String pcity;
    private double pcoin;

    private String image;

    public Product() {
    }

    public Product(int pid, String pname, String pcategory, Date pdatepost, String description, String pcity, double pcoin, String image) {
        this.pid = pid;
        this.pname = pname;
        this.pcategory = pcategory;
        this.pdatepost = pdatepost;
        this.description = description;
        this.pcity = pcity;
        this.pcoin = pcoin;
        this.image = image;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcategory() {
        return pcategory;
    }

    public void setPcategory(String pcategory) {
        this.pcategory = pcategory;
    }

    public Date getPdatepost() {
        return pdatepost;
    }

    public void setPdatepost(Date pdatepost) {
        this.pdatepost = pdatepost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    public double getPcoin() {
        return pcoin;
    }

    public void setPcoin(double pcoin) {
        this.pcoin = pcoin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
