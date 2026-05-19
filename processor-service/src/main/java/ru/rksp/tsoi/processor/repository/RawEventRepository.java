package ru.rksp.tsoi.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rksp.tsoi.processor.entity.RawEvent;

@Repository
public interface RawEventRepository extends JpaRepository<RawEvent, Long> {
    // JpaRepository уже содержит методы save(), findById(), count() и т.д.
}