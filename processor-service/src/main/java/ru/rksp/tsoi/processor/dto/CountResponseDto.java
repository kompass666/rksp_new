package ru.rksp.tsoi.processor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountResponseDto {

    private Long count;
    private LocalDateTime recordedAt;
    private String status;

}