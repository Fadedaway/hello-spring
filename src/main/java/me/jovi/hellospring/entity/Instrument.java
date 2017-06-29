package me.jovi.hellospring.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by joyce on 2017/3/29.
 */
@Table(name = "t_instrument")
@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    /**
     * 左刀头
     */
    @Column(name = "left_knife")
    private int leftKnife;

    /**
     * 右刀头
     */
    @Column(name = "right_knife")
    private int rightKnife;

    /**
     * 工件状态
     */
    @Column(name = "status")
    private int status;

    /**
     * 工件编号
     */
    @Column(name = "number")
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
