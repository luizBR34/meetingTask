package com.meeting.task.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Table(name = "room")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "maximum_allocation")
    private int maximumAllocation;

    @Column(name = "multimedia")
    private boolean multimedia;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "time")
    private String time;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="floor_id")
    private Floor floor;
}
