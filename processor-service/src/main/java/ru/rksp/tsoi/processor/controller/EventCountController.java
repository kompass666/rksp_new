package ru.rksp.tsoi.processor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rksp.tsoi.processor.dto.CountResponseDto;
import ru.rksp.tsoi.processor.service.EventCountService;

@RestController
@RequestMapping("/api/v1/events")
public class EventCountController {

    private static final Logger log = LoggerFactory.getLogger(EventCountController.class);
    private final EventCountService eventCountService;

    public EventCountController(EventCountService eventCountService) {
        this.eventCountService = eventCountService;
    }

    @PostMapping("/count")
    public ResponseEntity<CountResponseDto> countEvents() {
        log.info("Запрос на подсчёт событий");
        CountResponseDto response = eventCountService.countAndSave();
        return ResponseEntity.ok(response);
    }
}
