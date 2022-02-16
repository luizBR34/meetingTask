package com.meeting.task.repository;

import com.meeting.task.models.Floor;
import com.meeting.task.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends CrudRepository<Floor, Long> {

    Floor findById(long id);
    List<Room> findAllByRoom(Room room);
}
