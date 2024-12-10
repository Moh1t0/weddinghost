package com.weddinghost.weddinghost.controller;

import com.weddinghost.weddinghost.dto.BookingDto;
import com.weddinghost.weddinghost.dto.FreeDaysCount;
import com.weddinghost.weddinghost.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/month/{month}")
    public List<BookingDto> getBookingsForMonth(@PathVariable int month) {
        return bookingService.getBookingsForMonth(month);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
    }

    @GetMapping("/month/{month}/free")
    public FreeDaysCount getFreeDaysCount(@PathVariable int month) {
        return bookingService.getBookedDaysCount(month);
    }
}
