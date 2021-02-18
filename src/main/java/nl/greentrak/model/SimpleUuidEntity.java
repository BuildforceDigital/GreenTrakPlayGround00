package nl.greentrak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

@Entity
@PrimaryKey(validation = IdValidation.NULL)
@Table(name = "SIMPLEUUIDS", schema = "DEV_GREENTRAK00")
public class SimpleUuidEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @Convert(converter = UUIDAttributeBoxedConverter.class)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}