package com.practice.notify.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private boolean notifyViaEmail = false;
    private boolean notifyViaSms = false;
    private boolean notifyViaWs = true;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public boolean isNotifyViaEmail() {
        return notifyViaEmail;
    }

    public boolean isNotifyViaSms() {
        return notifyViaSms;
    }

    public boolean isNotifyViaWs() {
        return notifyViaWs;
    }

    public void setNotifyViaEmail(boolean notifyViaEmail) {
        this.notifyViaEmail = notifyViaEmail;
    }

    public void setNotifyViaSms(boolean notifyViaSms) {
        this.notifyViaSms = notifyViaSms;
    }

    public void setNotifyViaWs(boolean notifyViaWs) {
        this.notifyViaWs = notifyViaWs;
    }
}
