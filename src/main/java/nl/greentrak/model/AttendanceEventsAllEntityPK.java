package nl.greentrak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;
import java.time.OffsetDateTime;

public class AttendanceEventsAllEntityPK implements Serializable {
    private Integer version;
    private OffsetDateTime checkInDateTime;
    private UUID userId;

    @Column(name = "\"Version", nullable = false)
    @Id
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "\"CheckInDateTime", nullable = false)
    @Id
    public OffsetDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(OffsetDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    @Id
    @Column(name = "\"UserID", nullable = false)
    @Convert(converter = UUIDAttributeConverter.class)
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceEventsAllEntityPK that = (AttendanceEventsAllEntityPK) o;

        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (checkInDateTime != null ? !checkInDateTime.equals(that.checkInDateTime) : that.checkInDateTime != null) return false;
        if (!Arrays.equals(userId, that.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (checkInDateTime != null ? checkInDateTime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(userId);
        return result;
    }*/
}
