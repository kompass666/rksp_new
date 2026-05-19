# Цой Ангелина, вариант 2

1. **ingest-service** (порт 8081)
    - Swagger: http://localhost:8081/swagger-ui.html

2. **processor-service** (порт 8082)
    - Swagger: http://localhost:8082/swagger-ui.html


## Структура базы данных

### Таблица PostgreSQL `сырые_события_университета`
- идентификатор (BIGSERIAL PRIMARY KEY)
- фио_преподавателя (VARCHAR(200))
- дисциплина (VARCHAR(200))
- аудитория (VARCHAR(50))
- дата_события (TIMESTAMP)

### Таблица ClickHouse `university_event_aggregates`
- recorded_at (DateTime)
- record_count (UInt64)

## Инструкция

### 1. Поднять инфраструктуру (Docker):

```bash
docker-compose up -d
```
### 2. Запуск ingest-service

```bash
cd ingest-service
./mvnw spring-boot:run
```
### 3. Запуск processor-service

```bash
cd processor-service
./mvnw spring-boot:run
```
### 4. Тестирование

```bash
curl -X 'POST' \
  'http://localhost:8081/api/v1/events' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "фиоПреподавателя": "Иванов И. И.",
  "дисциплина": "Базы данных",
  "аудитория": "101",
  "датаСобытия": "2026-02-25T10:00:00"
}'
```
```bash
curl -X 'POST' \
'http://localhost:8081/api/v1/events' \
-H 'accept: */*' \
-H 'Content-Type: application/json' \
-d '{
"фиоПреподавателя": "Петров П. П.",
"дисциплина": "Программирование на Java",
"аудитория": "202",
"датаСобытия": "2026-02-26T14:30:00"
}'
```
### 5. Подсчет количества событий:

```bash
curl.exe -X POST http://localhost:8082/api/v1/events/count -H "accept: */*"
```





