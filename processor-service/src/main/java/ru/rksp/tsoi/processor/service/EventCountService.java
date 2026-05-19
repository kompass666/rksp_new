package ru.rksp.tsoi.processor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.rksp.tsoi.processor.dto.CountResponseDto;
import ru.rksp.tsoi.processor.repository.RawEventRepository;

import java.time.LocalDateTime;

@Service
public class EventCountService {

    private static final Logger log = LoggerFactory.getLogger(EventCountService.class);
    private final RawEventRepository rawEventRepository;
    private final ClickHouseService clickHouseService;

    public EventCountService(RawEventRepository rawEventRepository, ClickHouseService clickHouseService) {
        this.rawEventRepository = rawEventRepository;
        this.clickHouseService = clickHouseService;
    }

    public CountResponseDto countAndSave() {
        log.info("Получение количества записей из PostgreSQL");

        long count = rawEventRepository.count();
        LocalDateTime recordedAt = LocalDateTime.now();

        log.info("Количество записей в PostgreSQL (сырые_события_университета): {}", count);

        clickHouseService.saveEventCount(count, recordedAt);

        return new CountResponseDto(count, recordedAt, "success");
    }
}