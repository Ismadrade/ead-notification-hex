package br.com.ismadrade.eadnotificationhex.adapters.configs;

import br.com.ismadrade.eadnotificationhex.EadNotificationHexApplication;
import br.com.ismadrade.eadnotificationhex.core.ports.NotificationPersistencePort;
import br.com.ismadrade.eadnotificationhex.core.services.NotificationServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = EadNotificationHexApplication.class)
public class BeanConfiguration {

    @Bean
    NotificationServicePortImpl notificationServicePortImpl(NotificationPersistencePort persistence) {
        return new NotificationServicePortImpl(persistence);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
