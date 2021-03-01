package nl.greentrak.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

@Entity
@PrimaryKey(validation = IdValidation.NULL)
@Table(name = "\"VAttendanceEventsAll\"", schema = "DEV_GREENTRAK00")
@IdClass(AttendanceEventsAllEntityPK.class)
public class VAttendanceEventsAllEntity {
    private Integer version;
    private OffsetDateTime checkInDateTime;
    private String fullProjOwner;
    private String projectCode;
    private String termGuidIn;
    private UUID userId;
    private String userName;
    private String fullName;
    private String aggApprTime;
    private OffsetDateTime aggStartDate;
    private String aggTotalTime;
    private String approvalBy;
    private OffsetDateTime approvalDateTime;
    private OffsetDateTime checkOutDateTime;
    private String description;
    private String remarks;
    private String termGuidOut;
    private ProfilesEntity profilesByUserId;

    @Id
    @Column(name = "\"Version\"", nullable = false)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Id
    @Column(name = "\"CheckInDateTime\"", nullable = false)
    public OffsetDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(OffsetDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    @Basic
    @Column(name = "\"FullProjOwner\"", nullable = true, length = 40)
    public String getFullProjOwner() {
        return fullProjOwner;
    }

    public void setFullProjOwner(String fullProjOwner) {
        this.fullProjOwner = fullProjOwner;
    }

    @Basic
    @Column(name = "\"ProjectCode\"", nullable = false, length = 10)
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Basic
    @Column(name = "\"TermGuidIn\"", nullable = false, length = 36)
    public String getTermGuidIn() {
        return termGuidIn;
    }

    public void setTermGuidIn(String termGuidIn) {
        this.termGuidIn = termGuidIn;
    }

    @Id
    @Convert(converter = UUIDAttributePrimitiveConverter.class)
    @Column(name = "\"UserID\"", nullable = false)
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "\"AggApprTime\"", nullable = true, length = 255)
    public String getAggApprTime() {
        return aggApprTime;
    }

    public void setAggApprTime(String aggApprTime) {
        this.aggApprTime = aggApprTime;
    }

    @Basic
    @Column(name = "\"AggStartDate\"", nullable = true)
    public OffsetDateTime getAggStartDate() {
        return aggStartDate;
    }

    public void setAggStartDate(OffsetDateTime aggStartDate) {
        this.aggStartDate = aggStartDate;
    }

    @Basic
    @Column(name = "\"AggTotalTime\"", nullable = true, length = 255)
    public String getAggTotalTime() {
        return aggTotalTime;
    }

    public void setAggTotalTime(String aggTotalTime) {
        this.aggTotalTime = aggTotalTime;
    }

    @Basic
    @Column(name = "\"ApprovalBy\"", nullable = true, length = 40)
    public String getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(String approvalBy) {
        this.approvalBy = approvalBy;
    }

    @Basic
    @Column(name = "\"ApprovalDateTime\"", nullable = true)
    public OffsetDateTime getApprovalDateTime() {
        return approvalDateTime;
    }

    public void setApprovalDateTime(OffsetDateTime approvalDateTime) {
        this.approvalDateTime = approvalDateTime;
    }

    @Basic
    @Column(name = "\"CheckOutDateTime\"", nullable = true)
    public OffsetDateTime getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(OffsetDateTime checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    @Basic
    @Column(name = "\"Description\"", nullable = true, length = 160)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "\"Remarks\"", nullable = true, length = 480)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "\"TermGuidOut\"", nullable = true, length = 36)
    public String getTermGuidOut() {
        return termGuidOut;
    }

    public void setTermGuidOut(String termGuidOut) {
        this.termGuidOut = termGuidOut;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VAttendanceEventsAllEntity that = (VAttendanceEventsAllEntity) o;

        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (checkInDateTime != null ? !checkInDateTime.equals(that.checkInDateTime) : that.checkInDateTime != null) return false;
        if (fullProjOwner != null ? !fullProjOwner.equals(that.fullProjOwner) : that.fullProjOwner != null) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;
        if (termGuidIn != null ? !termGuidIn.equals(that.termGuidIn) : that.termGuidIn != null) return false;
        if (!Arrays.equals(userId, that.userId)) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (aggApprTime != null ? !aggApprTime.equals(that.aggApprTime) : that.aggApprTime != null) return false;
        if (aggStartDate != null ? !aggStartDate.equals(that.aggStartDate) : that.aggStartDate != null) return false;
        if (aggTotalTime != null ? !aggTotalTime.equals(that.aggTotalTime) : that.aggTotalTime != null) return false;
        if (approvalBy != null ? !approvalBy.equals(that.approvalBy) : that.approvalBy != null) return false;
        if (approvalDateTime != null ? !approvalDateTime.equals(that.approvalDateTime) : that.approvalDateTime != null)
            return false;
        if (checkOutDateTime != null ? !checkOutDateTime.equals(that.checkOutDateTime) : that.checkOutDateTime != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (termGuidOut != null ? !termGuidOut.equals(that.termGuidOut) : that.termGuidOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (checkInDateTime != null ? checkInDateTime.hashCode() : 0);
        result = 31 * result + (fullProjOwner != null ? fullProjOwner.hashCode() : 0);
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        result = 31 * result + (termGuidIn != null ? termGuidIn.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(userId);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (aggApprTime != null ? aggApprTime.hashCode() : 0);
        result = 31 * result + (aggStartDate != null ? aggStartDate.hashCode() : 0);
        result = 31 * result + (aggTotalTime != null ? aggTotalTime.hashCode() : 0);
        result = 31 * result + (approvalBy != null ? approvalBy.hashCode() : 0);
        result = 31 * result + (approvalDateTime != null ? approvalDateTime.hashCode() : 0);
        result = 31 * result + (checkOutDateTime != null ? checkOutDateTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (termGuidOut != null ? termGuidOut.hashCode() : 0);
        return result;
    }*/

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "\"UserID\"", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ProfilesEntity getProfilesByUserId() {
        return profilesByUserId;
    }

    public void setProfilesByUserId(ProfilesEntity profilesByUserId) {
        this.profilesByUserId = profilesByUserId;
    }

}