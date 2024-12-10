package com.weddinghost.weddinghost.repository;

import com.weddinghost.weddinghost.entity.BookingEntity;
import com.weddinghost.weddinghost.storage.BookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookingRepository {
    private final BookingStorage bookingStorage;

    public List<BookingEntity> findByMonth(int month) {
        List<BookingEntity> result = bookingStorage.getBookings().values().stream()
                .filter(booking -> booking.getMonthNumber() == month)
                .collect(Collectors.toList());
        return result;
    }
    public void save(BookingEntity bookingEntity) {
        String key = generateKey(bookingEntity.getMonthNumber(), bookingEntity.getDayNumber());
        bookingStorage.getBookings().put(key, bookingEntity);
    }

    public boolean exists(int month, int day) {
        String key = generateKey(month, day);
        return bookingStorage.getBookings().containsKey(key);
    }

    public long countBookedDaysInMonth(int month) {
        return bookingStorage.getBookings().values().stream()
                .filter(booking -> booking.getMonthNumber() == month && booking.isBooked())
                .count();
    }

    private String generateKey(int month, int day) {
        return month + ":" + day;
    }
}
