package com.meeting.task.repository;

import com.meeting.task.models.Building;
import com.meeting.task.models.Floor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {

    Building findById(long id);
    List<Floor> findAllByFloor(Floor floor);
}
