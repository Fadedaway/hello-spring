package me.jovi.hellospring.entity;

import javax.persistence.*;

/**
 * Created by joyce on 2017/3/29.
 */
@Table(name = "t_knife")
@Entity
public class Knife {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "time")
    private int time;

    @Column(name = "number")
    private String number;

    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}