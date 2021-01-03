package nl.greentrak.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "PROFILES", schema = "DEV_GREENTRAK00", catalog = "PUBLIC")
public class ProfilesEntity {
    private java.util.UUID id;
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
    private java.time.OffsetDateTime tillDate;
    private String userName;
    private String imageUrl;
    private java.util.UUID organization;
    private ProfilesEntity profilesByOrganization;
    private Collection<ProfilesEntity> profilesById;

    @Id
    @Column(name = "ID", nullable = false)
    public java.util.UUID getId() {
        return id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BirthDate", nullable = true, length = 36)
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "BusinessEmail", nullable = true, length = 10)
    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    @Basic
    @Column(name = "CitizenServiceNr", nullable = true, length = 36)
    public String getCitizenServiceNr() {
        return citizenServiceNr;
    }

    public void setCitizenServiceNr(String citizenServiceNr) {
        this.citizenServiceNr = citizenServiceNr;
    }

    @Basic
    @Column(name = "FullName", nullable = true, length = 40)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Gender", nullable = true, length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "JobTitle", nullable = true, length = 36)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "LandlinePhone", nullable = true, length = 40)
    public String getLandlinePhone() {
        return landlinePhone;
    }

    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    @Basic
    @Column(name = "MobilePhone", nullable = true, length = 40)
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "Nationality", nullable = true, length = 40)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "Nickname", nullable = true, length = 40)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "PrivateEmail", nullable = true, length = 40)
    public String getPrivateEmail() {
        return privateEmail;
    }

    public void setPrivateEmail(String privateEmail) {
        this.privateEmail = privateEmail;
    }

    @Basic
    @Column(name = "TillDate", nullable = true)
    public java.time.OffsetDateTime getTillDate() {
        return tillDate;
    }

    public void setTillDate(java.time.OffsetDateTime tillDate) {
        this.tillDate = tillDate;
    }

    @Basic
    @Column(name = "UserName", nullable = true, length = 40)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "ImageURL", nullable = true, length = 40)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "Organization", nullable = true)
    public java.util.UUID getOrganization() {
        return organization;
    }

    public void setOrganization(java.util.UUID organization) {
        this.organization = organization;
    }

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "Organization", referencedColumnName = "ID", insertable = false, updatable = false)
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
