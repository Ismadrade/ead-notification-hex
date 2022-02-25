package br.com.ismadrade.eadnotificationhex.core.ports;

import br.com.ismadrade.eadnotificationhex.core.domain.NotificationDomain;
import br.com.ismadrade.eadnotificationhex.core.domain.PageInfo;
import br.com.ismadrade.eadnotificationhex.core.domain.enums.NotificationStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationPersistencePort {

    NotificationDomain save(NotificationDomain notificationDomain);
    List<NotificationDomain> findAllByUserIdAndNotificationStatus(UUID userId, NotificationStatus notificationStatus, PageInfo pageInfo);
    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
