package nl.greentrak.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

@Entity
@PrimaryKey(validation = IdValidation.NULL)
@Table(name = "PROFILES", schema = "DEV_GREENTRAK00")
public class ProfilesEntity {
    private UUID id;
    private String birthDate;
    private String businessEmail;
    private String citizenServiceNr;
    private String fullName;
    private String gender;
    private String jobTitle;
    private String landlinePhone;
    private String mobilePhone;
    private String nationality;
    private String nickname;
    private String privateEmail;
    private OffsetDateTime tillDate;
    private String userName;
    private String imageUrl;
    private UUID organization;
    private Collection<AttendanceEventsAllEntity> attendanceEventsAllsById;
    private Collection<P0000ProjectsEntity> p0000ProjectsById;
    private ProfilesEntity profilesByOrganization;
    private Collection<ProfilesEntity> profilesById;

    @Id
    @Column(name = "ID", nullable = false)
    @Convert(converter = UUIDAttributeConverter.class)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"BirthDate\"", nullable = true, length = 36)
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "\"BusinessEmail\"", nullable = true, length = 10)
    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    @Basic
    @Column(name = "\"CitizenServiceNr\"", nullable = true, length = 36)
    public String getCitizenServiceNr() {
        return citizenServiceNr;
    }

    public void setCitizenServiceNr(String citizenServiceNr) {
        this.citizenServiceNr = citizenServiceNr;
    }

    @Basic
    @Column(name = "\"FullName\"", nullable = true, length = 40)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "\"Gender\"", nullable = true, length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "\"JobTitle\"", nullable = true, length = 36)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "\"LandlinePhone\"", nullable = true, length = 40)
    public String getLandlinePhone() {
        return landlinePhone;
    }

    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    @Basic
    @Column(name = "\"MobilePhone\"", nullable = true, length = 40)
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "\"Nationality\"", nullable = true, length = 40)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "\"Nickname\"", nullable = true, length = 40)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "\"PrivateEmail\"", nullable = true, length = 40)
    public String getPrivateEmail() {
        return privateEmail;
    }

    public void setPrivateEmail(String privateEmail) {
        this.privateEmail = privateEmail;
    }

    @Basic
    @Column(name = "\"TillDate\"", nullable = true)
    public OffsetDateTime getTillDate() {
        return tillDate;
    }

    public void setTillDate(OffsetDateTime tillDate) {
        this.tillDate = tillDate;
    }

    @Basic
    @Column(name = "\"UserName\"", nullable = true, length = 40)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "\"ImageURL\"", nullable = true, length = 40)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "\"Organization\"", nullable = true)
    @Convert(converter = UUIDAttributeConverter.class)
    public UUID getOrganization() {
        return organization;
    }

    public void setOrganization(UUID organization) {
        this.organization = organization;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfilesEntity that = (ProfilesEntity) o;

        if (!Arrays.equals(id, that.id)) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (businessEmail != null ? !businessEmail.equals(that.businessEmail) : that.businessEmail != null) return false;
        if (citizenServiceNr != null ? !citizenServiceNr.equals(that.citizenServiceNr) : that.citizenServiceNr != null)
            return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (landlinePhone != null ? !landlinePhone.equals(that.landlinePhone) : that.landlinePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (privateEmail != null ? !privateEmail.equals(that.privateEmail) : that.privateEmail != null) return false;
        if (tillDate != null ? !tillDate.equals(that.tillDate) : that.tillDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (!Arrays.equals(organization, that.organization)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(id);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (businessEmail != null ? businessEmail.hashCode() : 0);
        result = 31 * result + (citizenServiceNr != null ? citizenServiceNr.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (landlinePhone != null ? landlinePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (privateEmail != null ? privateEmail.hashCode() : 0);
        result = 31 * result + (tillDate != null ? tillDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(organization);
        return result;
    }*/

    @OneToMany(mappedBy = "profilesByUserId")
    public Collection<AttendanceEventsAllEntity> getAttendanceEventsAllsById() {
        return attendanceEventsAllsById;
    }

    public void setAttendanceEventsAllsById(Collection<AttendanceEventsAllEntity> attendanceEventsAllsById) {
        this.attendanceEventsAllsById = attendanceEventsAllsById;
    }

    @OneToMany(mappedBy = "profilesByProjOwner")
    public Collection<nl.greentrak.model.P0000ProjectsEntity> getP0000ProjectsById() {
        return p0000ProjectsById;
    }

    public void setP0000ProjectsById(Collection<nl.greentrak.model.P0000ProjectsEntity> p0000ProjectsById) {
        this.p0000ProjectsById = p0000ProjectsById;
    }

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Organization\"", referencedColumnName = "ID", insertable = false, updatable = false)
    public ProfilesEntity getProfilesByOrganization() {
        return profilesByOrganization;
    }

    public void setProfilesByOrganization(ProfilesEntity profilesByOrganization) {
        this.profilesByOrganization = profilesByOrganization;
    }

    @OneToMany(mappedBy = "profilesByOrganization")
    public Collection<ProfilesEntity> getProfilesById() {
        return profilesById;
    }

    public void setProfilesById(Collection<ProfilesEntity> profilesById) {
        this.profilesById = profilesById;
    }

}