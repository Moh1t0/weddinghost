package com.weddinghost.weddinghost.storage;


import com.weddinghost.weddinghost.entity.BookingEntity;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookingStorage {
    private final Map<String, BookingEntity> bookings = new HashMap<>();

    public Map<String, BookingEntity> getBookings() {
        return bookings;
    }
}
