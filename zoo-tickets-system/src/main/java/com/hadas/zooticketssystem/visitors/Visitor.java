package com.hadas.zooticketssystem.visitors;

import org.springframework.data.redis.core.RedisHash;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@RedisHash("Visitor")
@Entity
public class Visitor implements Serializable {
    @Id
    private Long id;
    private String timeStamp;
    private boolean status;

    public Visitor(Long id, String timeStamp) {
        this.timeStamp = timeStamp;
        this.id = id;
        this.status = true;
    }

    public Visitor() {
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Long getId() {
        return id;
    }

}
