package br.com.ismadrade.eadnotificationhex.core.ports;


import br.com.ismadrade.eadnotificationhex.core.domain.NotificationDomain;
import br.com.ismadrade.eadnotificationhex.core.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationServicePort {

    NotificationDomain saveNotification(NotificationDomain notificationModel);
    List<NotificationDomain> findAllNotificationsByUser(UUID userId, PageInfo pageable);
    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
