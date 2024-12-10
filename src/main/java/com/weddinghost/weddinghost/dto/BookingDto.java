package com.weddinghost.weddinghost.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDto {
    @JsonProperty("monthNumber")
    private int month;
    @JsonProperty("dayNumber")
    private int day;
    private boolean booked;
}
