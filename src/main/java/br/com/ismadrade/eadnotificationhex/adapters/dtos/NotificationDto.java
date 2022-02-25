package br.com.ismadrade.eadnotificationhex.adapters.dtos;

import br.com.ismadrade.eadnotificationhex.core.domain.enums.NotificationStatus;

import javax.validation.constraints.NotNull;

public class NotificationDto {

    @NotNull
    private NotificationStatus notificationStatus;

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}
