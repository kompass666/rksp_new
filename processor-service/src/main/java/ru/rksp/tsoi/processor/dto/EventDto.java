package ru.rksp.tsoi.processor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("фиоПреподавателя")
    private String фиоПреподавателя;

    @JsonProperty("дисциплина")
    private String дисциплина;

    @JsonProperty("аудитория")
    private String аудитория;

    @JsonProperty("датаСобытия")
    private LocalDateTime датаСобытия;

}