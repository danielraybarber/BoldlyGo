package com.tts.BoldlyGo.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="GOLOCATION")
public class GoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="go_location_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @CreationTimestamp
    private Date createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    private boolean hasBeenReached = false;

    public GoLocation() {

    }

    public GoLocation(Long id, User user, Date createdAt, Location location, boolean hasBeenReached) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
        this.location = location;
        this.hasBeenReached = hasBeenReached;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean getHasBeenReached() {
        return hasBeenReached;
    }

    public void setHasBeenReached(boolean hasBeenReached) {
        this.hasBeenReached = hasBeenReached;
    }
}