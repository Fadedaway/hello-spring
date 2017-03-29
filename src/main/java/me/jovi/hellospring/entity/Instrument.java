package me.jovi.hellospring.entity;

import javax.persistence.*;

/**
 * Created by joyce on 2017/3/29.
 */
@Table(name = "t_instrument")
@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "left_knife")
    private int leftKnife;

    @Column(name = "right_knife")
    private int rightKnife;

    @Column(name = "status")
    private int status;

    @Column(name = "number")
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeftKnife() {
        return leftKnife;
    }

    public void setLeftKnife(int leftKnife) {
        this.leftKnife = leftKnife;
    }

    public int getRightKnife() {
        return rightKnife;
    }

    public void setRightKnife(int rightKnife) {
        this.rightKnife = rightKnife;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
