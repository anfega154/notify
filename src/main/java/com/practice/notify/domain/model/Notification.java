package com.practice.notify.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    private String message;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveredVia;

    @Column(nullable = false)
    private LocalDateTime sentAt = LocalDateTime.now();

    public enum DeliveryMethod {
        EMAIL, SMS, WEBSOCKET
    }

    public Long getId() {
        return id;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public String getMessage() {
        return message;
    }

    public DeliveryMethod getDeliveredVia() {
        return deliveredVia;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}