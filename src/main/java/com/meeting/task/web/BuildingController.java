package com.meeting.task.web;

import com.meeting.task.mappers.DateUtils;
import com.meeting.task.models.Room;
import com.meeting.task.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    private RoomRepository roomRepo;

    @PostMapping("/book")
    public void bookMeetingRoom(@RequestParam("date") String date,
                                @RequestParam("time") String time,
                                @RequestParam("attendees") int attendees,
                                @RequestParam("multimedia") boolean multimedia) throws ParseException {


        List<Room> bookedRooms = roomRepo.findByParams(DateUtils.parseDate(date), time, attendees, multimedia);

        //No room was booked
        if (bookedRooms.isEmpty()) {
            Room room = Room.builder().date(DateUtils.parseDate(date)).time(time).maximumAllocation(attendees).multimedia(multimedia).build();
            roomRepo.save(room);
        }
    }
}
