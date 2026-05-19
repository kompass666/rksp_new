package ru.rksp.tsoi.ingest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.rksp.tsoi.ingest.config.RabbitMQConfig;
import ru.rksp.tsoi.ingest.dto.EventDto;

@Service
public class EventProducerService {

    private static final Logger log = LoggerFactory.getLogger(EventProducerService.class);
    private final RabbitTemplate rabbitTemplate;

    public EventProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEvent(EventDto event) {
        log.info("Отправка события университета в очередь {}: {}", RabbitMQConfig.EVENTS_RAW_QUEUE, event);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EVENTS_RAW_QUEUE, event);
        log.info("Событие университета успешно отправлено");
    }
}