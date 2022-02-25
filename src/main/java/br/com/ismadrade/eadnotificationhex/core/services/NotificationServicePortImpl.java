package br.com.ismadrade.eadnotificationhex.core.services;

import br.com.ismadrade.eadnotificationhex.core.domain.NotificationDomain;
import br.com.ismadrade.eadnotificationhex.core.domain.PageInfo;
import br.com.ismadrade.eadnotificationhex.core.domain.enums.NotificationStatus;
import br.com.ismadrade.eadnotificationhex.core.ports.NotificationPersistencePort;
import br.com.ismadrade.eadnotificationhex.core.ports.NotificationServicePort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NotificationServicePortImpl implements NotificationServicePort {

    private final NotificationPersistencePort notificationPersistencePort;

    public NotificationServicePortImpl(NotificationPersistencePort notificationPersistencePort) {
        this.notificationPersistencePort = notificationPersistencePort;
    }

    @Override
    public NotificationDomain saveNotification(NotificationDomain NotificationDomain) {
        return notificationPersistencePort.save(NotificationDomain);
    }

    @Override
    public List<NotificationDomain> findAllNotificationsByUser(UUID userId, PageInfo pageInfo) {
        return notificationPersistencePort.findAllByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageInfo);
    }

    @Override
    public Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        return notificationPersistencePort.findByNotificationIdAndUserId(notificationId, userId);
    }
}
