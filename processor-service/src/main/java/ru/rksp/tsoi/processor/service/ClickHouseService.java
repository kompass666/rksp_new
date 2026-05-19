package ru.rksp.tsoi.processor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ClickHouseService {

    private static final Logger log = LoggerFactory.getLogger(ClickHouseService.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final DataSource clickHouseDataSource;

    public ClickHouseService(@Qualifier("clickHouseDataSource") DataSource clickHouseDataSource) {
        this.clickHouseDataSource = clickHouseDataSource;
    }

    public void saveEventCount(long count, LocalDateTime recordedAt) {
        String sql = "INSERT INTO university_event_aggregates (recorded_at, record_count) VALUES (?, ?)";

        try (Connection connection = clickHouseDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, recordedAt.format(FORMATTER));
            statement.setLong(2, count);
            statement.executeUpdate();

            log.info("Записано в ClickHouse: record_count={}, recorded_at={}", count, recordedAt);

        } catch (SQLException e) {
            log.error("Ошибка при записи в ClickHouse: {}", e.getMessage());
            throw new RuntimeException("Ошибка при записи в ClickHouse", e);
        }
    }
}