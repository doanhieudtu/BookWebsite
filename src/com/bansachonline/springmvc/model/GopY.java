package com.bansachonline.springmvc.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "GopY")
public class GopY {
    @Id
    @Column(name="MaGopY")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int MaGopY;
    @Column(name = "Email")
    private String Email;
    @Column(name = "NoiDung")
    private String NoiDung;

    public int getMaGopY() {
        return MaGopY;
    }

    public void setMaGopY(int maGopY) {
        MaGopY = maGopY;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
