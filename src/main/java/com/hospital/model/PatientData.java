package com.hospital.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patientdata")
public class PatientData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, contact_number;
    private Date bookingDate;
    private int token;

    public PatientData(int id, String name, String contact_number, Date bookingDate, int token) {

        this.id = id;
        this.name = name;
        this.contact_number = contact_number;
        this.bookingDate = bookingDate;
        this.token = token;
    }

    public PatientData() {

        // TODO Auto-generated constructor stub
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {

        this.contact_number = contact_number;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}

