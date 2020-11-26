package nl.greentrak.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "P0000PROJECTS", schema = "DEV_GREENTRAK00")
public class P0000ProjectEntity {
    public P0000ProjectEntity() {
    }

    @Id
    @Column(name = "\"Id\"")
    private int id;

    @Column(name = "\"ProjOwner\"", nullable = false)
    @Convert(converter = UUIDAttributeConverter.class)
    private java.util.UUID projOwner;

    @Column(name = "\"StartDate\"", nullable = false)
    private java.time.OffsetDateTime startDate;

    @Column(name = "\"ProjectCode\"", nullable = false, length = 20)
    private String projectCode;

    @Column(name = "\"ProjectName\"", length = 20)
    private String projectName;

    @Column(name = "\"Description\"", length = 320)
    private String description;

}