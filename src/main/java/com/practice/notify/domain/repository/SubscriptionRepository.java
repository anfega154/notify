package com.practice.notify.domain.repository;

import com.practice.notify.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);
    List<Subscription> findByAssetSymbolAndEventType(String assetSymbol, String eventType);
}
