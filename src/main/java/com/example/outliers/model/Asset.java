package com.example.outliers.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Asset implements Serializable {
    /** Entity ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /** The version used for optimistic locking. */
    @Version
    @Column(name = "VERSION")
    private Integer version;

    private String age;
    private String uptime;
    private int numOfFailures;


    public Asset() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public int getNumOfFailures() {
        return numOfFailures;
    }

    public void setNumOfFailures(int numOfFailures) {
        this.numOfFailures = numOfFailures;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", uptime='" + uptime + '\'' +
                ", numOfFailures=" + numOfFailures +
                '}';
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        final Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override public int hashCode() {
        return Objects.hash(id);
    }
}
