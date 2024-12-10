package com.weddinghost.weddinghost.service;

import com.weddinghost.weddinghost.dto.BookingDto;
import com.weddinghost.weddinghost.dto.FreeDaysCount;
import com.weddinghost.weddinghost.entity.BookingEntity;
import com.weddinghost.weddinghost.mapper.BookingMapper;
import com.weddinghost.weddinghost.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public List<BookingDto> getBookingsForMonth(int month) {
        List<BookingEntity> bookings = bookingRepository.findByMonth(month);
        return bookings.stream()
                .map(bookingMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public void createBooking(BookingDto bookingDto) {
        if (bookingRepository.exists(bookingDto.getMonth(), bookingDto.getDay())) {
            throw new IllegalArgumentException("Бронирование на эту дату уже существует: "
                    + "месяц = " + bookingDto.getMonth() + ", день = " + bookingDto.getDay());
        }
        BookingEntity bookingEntity = bookingMapper.convertToEntity(bookingDto);
        bookingRepository.save(bookingEntity);
    }

    public FreeDaysCount getBookedDaysCount(int month) {
        long bookedDays = bookingRepository.countBookedDaysInMonth(month);
        return new FreeDaysCount((int) bookedDays);
    }
}
