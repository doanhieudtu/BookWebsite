package com.bansachonline.springmvc.model;

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by DELL on 05/22/2018.
 */
@Entity
@javax.persistence.Table(name ="UserToken")
public class UserToken {
    @Id
    @Column(name="MaUT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long MaUT;

    @ManyToOne
    @JoinColumn(name="MaKH")
    KhachHang UserToken;

    @Column(name="TimeChange")
    private long TimeChange;

    public long getMaUT() {
        return MaUT;
    }

    public void setMaUT(long maUT) {
        MaUT = maUT;
    }

    public KhachHang getUserToken() {
        return UserToken;
    }

    public void setUserToken(KhachHang userToken) {
        UserToken = userToken;
    }

    public long getTimeChange() {
        return TimeChange;
    }

    public void setTimeChange(long timeChange) {
        TimeChange = timeChange;
    }
}
