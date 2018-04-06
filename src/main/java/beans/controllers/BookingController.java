package beans.controllers;

import beans.models.Ticket;
import beans.models.User;
import beans.services.AuditoriumService;
import beans.services.BookingService;
import beans.services.EventService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingServiceImpl;

    @Autowired
    UserService userServiceImpl;

    @Autowired
    EventService eventServiceImpl;

    @Autowired
    AuditoriumService auditoriumService;

    @RequestMapping(value = "/getTicketPrice", method = RequestMethod.GET)
    public Double getTicketPrice(@RequestParam String eventName,
                                 @RequestParam String auditorium,
                                 @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTime,
                                 @RequestParam List<Integer> seats,
                                 @RequestParam String userEmail) {
        User user = userServiceImpl.getUserByEmail(userEmail);

        return bookingServiceImpl.getTicketPrice(eventName, auditorium, dateTime, seats, user);
    }

    @RequestMapping(value = "/getTicketsForEvent", method = RequestMethod.GET)
    public List<Ticket> getTicketsForEvent(@RequestParam String eventName,
                                           @RequestParam String auditorium,
                                           @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateEvent) {
        return bookingServiceImpl.getTicketsForEvent(eventName, auditorium, dateEvent);
    }

    @RequestMapping(value = "/getTicketsForEventPdf", method = RequestMethod.GET,  headers = "accept=application/pdf")
    public ModelAndView test(@RequestParam String eventName,
                             @RequestParam String auditorium,
                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateEvent) {
        List<Ticket> tickets = bookingServiceImpl.getTicketsForEvent(eventName, auditorium, dateEvent);

        if(CollectionUtils.isEmpty(tickets)) {
            tickets = new ArrayList<>();
        }

        return new ModelAndView("pdfView", "tickets",  tickets);
    }
}
