package ru.rksp.tsoi.ingest.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rksp.tsoi.ingest.dto.EventDto;
import ru.rksp.tsoi.ingest.service.EventProducerService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    private final EventProducerService eventProducerService;

    public EventController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createEvent(@Valid @RequestBody EventDto eventDto) {
        log.info("Запрос на создание события: {}", eventDto);
        eventProducerService.sendEvent(eventDto);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Событие успешно отправлено"
        ));
    }
}
