/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author SR
 */
public class Member {

    private int id;
    private int status;
    private String name;
    private String fc;
    private String plateform;
    private String comment;
    private String lodestoneNumber;
    private LocalDate joinDate;

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", status=" + status + ", name=" + name + ", fc=" + fc + ", plateform=" + plateform + ", comment=" + comment + ", lodestoneNumber=" + lodestoneNumber + ", joinDate=" + joinDate + '}';
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

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getPlateform() {
        return plateform;
    }

    public void setPlateform(String plateform) {
        this.plateform = plateform;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLodestoneNumber() {
        return lodestoneNumber;
    }

    public void setLodestoneNumber(String lodestoneNumber) {
        this.lodestoneNumber = lodestoneNumber;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Member(int id, int status, String name, String fc, String plateform, String comment, String lodestoneNumber, LocalDate joinDate) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.fc = fc;
        this.plateform = plateform;
        this.comment = comment;
        this.lodestoneNumber = lodestoneNumber;
        this.joinDate = joinDate;
    }

    public Member() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.fc);
        hash = 79 * hash + Objects.hashCode(this.plateform);
        hash = 79 * hash + this.status;
        hash = 79 * hash + Objects.hashCode(this.comment);
        hash = 79 * hash + Objects.hashCode(this.lodestoneNumber);
        hash = 79 * hash + Objects.hashCode(this.joinDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.fc, other.fc)) {
            return false;
        }
        if (!Objects.equals(this.plateform, other.plateform)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.lodestoneNumber, other.lodestoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.joinDate, other.joinDate)) {
            return false;
        }
        return true;
    }

    

}
