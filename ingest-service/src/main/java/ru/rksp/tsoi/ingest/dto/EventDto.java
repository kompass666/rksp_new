package ru.rksp.tsoi.ingest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto implements Serializable {

    @NotBlank(message = "ФИО преподавателя обязательно")
    @JsonProperty("фиоПреподавателя")
    private String фиоПреподавателя;

    @NotBlank(message = "Дисциплина обязательна")
    @JsonProperty("дисциплина")
    private String дисциплина;

    @NotBlank(message = "Аудитория обязательна")
    @JsonProperty("аудитория")
    private String аудитория;

    @NotNull(message = "Дата события обязательна")
    @JsonProperty("датаСобытия")
    private LocalDateTime датаСобытия;

    @Override
    public String toString() {
        return "EventDto{" +
                "фиоПреподавателя='" + фиоПреподавателя + '\'' +
                ", дисциплина='" + дисциплина + '\'' +
                ", аудитория='" + аудитория + '\'' +
                ", датаСобытия=" + датаСобытия +
                '}';
    }
}