package com.hadas.zooticketssystem.visitors;

import javax.persistence.Entity;

@Entity
public class Senior extends Visitor{
    int age;

    public Senior(Long id, String timeStamp, int age) {
        super(id, timeStamp);
        this.age = age;
    }

    public Senior() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
