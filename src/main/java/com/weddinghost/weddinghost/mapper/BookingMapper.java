package com.weddinghost.weddinghost.mapper;

import com.weddinghost.weddinghost.dto.BookingDto;
import com.weddinghost.weddinghost.entity.BookingEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingDto convertToDto(BookingEntity booking) {
        return new BookingDto(booking.getMonthNumber(), booking.getDayNumber(), booking.isBooked());
    }

    public BookingEntity convertToEntity(BookingDto bookingDto) {
        return new BookingEntity(bookingDto.getMonth(), bookingDto.getDay(), bookingDto.isBooked());
    }
}
