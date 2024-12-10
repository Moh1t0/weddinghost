package com.weddinghost.weddinghost.storage;


import com.weddinghost.weddinghost.entity.BookingEntity;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookingStorage {
    private final Map<String, BookingEntity> bookings = new HashMap<>();

    public BookingStorage() {
        bookings.put("1:10", new BookingEntity(1, 10, true));
        bookings.put("1:15", new BookingEntity(1, 15, true));
        bookings.put("2:5", new BookingEntity(2, 5, true));
    }

    public Map<String, BookingEntity> getBookings() {
        return bookings;
    }
}
