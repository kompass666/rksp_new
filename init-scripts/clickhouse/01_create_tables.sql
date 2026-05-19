CREATE TABLE IF NOT EXISTS university_event_aggregates (
    recorded_at DateTime,
    record_count UInt64
) ENGINE = MergeTree()
ORDER BY recorded_at;