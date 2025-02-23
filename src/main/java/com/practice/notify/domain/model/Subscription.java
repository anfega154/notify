package com.practice.notify.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String assetSymbol;
    private String eventType;
    private Double thresholdValue;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getAssetSymbol() {
        return assetSymbol;
    }

    public String getEventType() {
        return eventType;
    }

    public Double getThresholdValue() {
        return thresholdValue;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setAssetSymbol(String assetSymbol) {
        this.assetSymbol = assetSymbol;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setThresholdValue(Double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void removeNotification(Notification notification) {
        this.notifications.remove(notification);
    }
}
