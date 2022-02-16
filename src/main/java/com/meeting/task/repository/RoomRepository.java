package com.meeting.task.repository;

import com.meeting.task.models.Floor;
import com.meeting.task.models.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Room findByCode(long code);
    List<Room> findAllById(long id);

    @Query("SELECT e FROM Room e JOIN FETCH e.id d WHERE e.date = :date and e.time = :time and e.maximumAllocation = :attendees and e.multimedia = :multimedia")
    List<Room> findByParams(@Param("date") Date date, @Param("time") String time, @Param("attendees") int attendees, @Param("multimedia") boolean multimedia);
}
