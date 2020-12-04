package nl.greentrak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@PrimaryKey(validation = IdValidation.NULL)
@Table(name = "\"AttendanceEventsAll\"", schema = "DEV_GREENTRAK00")
public class AttendanceEventsAllEntity2 {

    @Id
    @Column(name = "\"UserID\"", nullable = false)
    @Convert(converter = UUIDAttributeConverter.class)
    private UUID userID;

    @Column(name = "\"Version\"")
    private Integer version;

    @Id
    @Column(name = "\"CheckInDateTime\"", nullable = false)
    private OffsetDateTime checkInDateTime;

    @Column(name = "\"ApprovalDateTime\"")
    private OffsetDateTime approvalDateTime;

    @Column(name = "\"ApprovalBy\"", length = 40)
    private String approvalBy;


    @Column(name = "\"CheckOutDateTime\"")
    private OffsetDateTime checkOutDateTime;


    @Column(name = "\"Description\"", length = 160) private String description;
    @Column(name = "\"ProjectCode\"", nullable = false, length = 10) private String projectCode;

    @Column(name = "\"ProjOwner\"", nullable = false)
    @Convert(converter = UUIDAttributeConverter.class)
    private UUID projOwner;

    @Column(name = "\"Remarks\"", length = 480) private String remarks;

    @Column(name = "\"AggStartDate\"") private OffsetDateTime aggStartDate;
    @Column(name = "\"AggTotalTime\"") private String aggTotalTime;
    @Column(name = "\"AggApprTime\"") private String aggApprTime;

    @Column(name = "\"TermGuidIn\"", nullable = false, length = 36) private String termGuidIn;
    @Column(name = "\"TermGuidOut\"", length = 36) private String termGuidOut;

    @Column(name = "\"UserName\"", nullable = false, length = 40)
    private String userName;

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public AttendanceEventsAllEntity2() {
        // required for JPA
    }

    public String getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(String approvalBy) {
        this.approvalBy = approvalBy;
    }

    public OffsetDateTime getApprovalDateTime() {
        return approvalDateTime;
    }

    public void setApprovalDateTime(OffsetDateTime approvalDateTime) {
        this.approvalDateTime = approvalDateTime;
    }

    public OffsetDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(OffsetDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public OffsetDateTime getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(OffsetDateTime checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public UUID getProjOwner() {
        return projOwner;
    }

    public void setProjOwner(UUID projOwner) {
        this.projOwner = projOwner;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /*public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }*/

    public String getTermGuidIn() {
        return termGuidIn;
    }

    public void setTermGuidIn(String termGuidIn) {
        this.termGuidIn = termGuidIn;
    }

    public String getTermGuidOut() {
        return termGuidOut;
    }

    public void setTermGuidOut(String termGuidOut) {
        this.termGuidOut = termGuidOut;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "\"UserID\"", referencedColumnName = "\"UserID\"", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "\"CheckInDateTime\"", referencedColumnName = "\"CheckInDateTime\"", nullable = false, insertable = false, updatable = false)
            })
    private VAttendanceEventsAllEntity attendanceEventsAllEntity2_CompositeKey;

}