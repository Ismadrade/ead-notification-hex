package br.com.ismadrade.eadnotificationhex.adapters.inbound.consumers;

import br.com.ismadrade.eadnotificationhex.adapters.dtos.NotificationCommandDto;
import br.com.ismadrade.eadnotificationhex.core.domain.NotificationDomain;
import br.com.ismadrade.eadnotificationhex.core.domain.enums.NotificationStatus;
import br.com.ismadrade.eadnotificationhex.core.ports.NotificationServicePort;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class NotificationConsumer {

    final NotificationServicePort notificationServicePort;

    public NotificationConsumer(NotificationServicePort notificationServicePort) {
        this.notificationServicePort = notificationServicePort;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ead.broker.queue.notificationCommandQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${ead.broker.exchange.notificationCommandExchange}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ead.broker.key.notificationCommandKey}")
    )
    public void listen(@Payload NotificationCommandDto notificationCommandDto) {
        var notificationDomain = new NotificationDomain();
        BeanUtils.copyProperties(notificationCommandDto, notificationDomain);
        notificationDomain.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        notificationDomain.setNotificationStatus(NotificationStatus.CREATED);
        notificationServicePort.saveNotification(notificationDomain);
    }

}