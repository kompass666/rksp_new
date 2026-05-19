package ru.rksp.tsoi.processor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rksp.tsoi.processor.config.RabbitMQConfig;
import ru.rksp.tsoi.processor.dto.EventDto;
import ru.rksp.tsoi.processor.entity.RawEvent;
import ru.rksp.tsoi.processor.repository.RawEventRepository;

@Service
public class EventConsumerService {

    private static final Logger log = LoggerFactory.getLogger(EventConsumerService.class);
    private final RawEventRepository rawEventRepository;

    public EventConsumerService(RawEventRepository rawEventRepository) {
        this.rawEventRepository = rawEventRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.EVENTS_RAW_QUEUE)
    @Transactional
    public void consumeEvent(EventDto eventDto) {
        log.info("Получено событие университета из очереди {}: {}", RabbitMQConfig.EVENTS_RAW_QUEUE, eventDto);

        RawEvent event = new RawEvent(
                eventDto.getФиоПреподавателя(),
                eventDto.getДисциплина(),
                eventDto.getАудитория(),
                eventDto.getДатаСобытия()
        );

        RawEvent savedEvent = rawEventRepository.save(event);
        log.info("Событие университета сохранено в PostgreSQL с идентификатором: {}", savedEvent.getИдентификатор());
    }
}