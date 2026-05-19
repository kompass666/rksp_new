package ru.rksp.tsoi.processor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "сырые_события_университета")
public class RawEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор")
    private Long идентификатор;

    @Column(name = "фио_преподавателя", nullable = false)
    private String фиоПреподавателя;

    @Column(name = "дисциплина", nullable = false)
    private String дисциплина;

    @Column(name = "аудитория", nullable = false)
    private String аудитория;

    @Column(name = "дата_события", nullable = false)
    private LocalDateTime датаСобытия;

    public RawEvent() {
    }

    public RawEvent(String фиоПреподавателя, String дисциплина,
                    String аудитория, LocalDateTime датаСобытия) {
        this.фиоПреподавателя = фиоПреподавателя;
        this.дисциплина = дисциплина;
        this.аудитория = аудитория;
        this.датаСобытия = датаСобытия;
    }
}