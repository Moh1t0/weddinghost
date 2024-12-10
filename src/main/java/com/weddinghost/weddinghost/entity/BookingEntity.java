package com.weddinghost.weddinghost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    private int monthNumber;
    private int dayNumber;
    private boolean booked;
}
