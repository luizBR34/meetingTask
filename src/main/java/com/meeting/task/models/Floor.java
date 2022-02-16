package com.meeting.task.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "floor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="floor",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Room> rooms;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="building_id")
    private Building building;
}
