package nl.greentrak.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

@Entity
@PrimaryKey(validation = IdValidation.NULL)
@Table(name = "P0000PROJECTS", schema = "DEV_GREENTRAK00")
public class P0000ProjectsEntity {
    private Integer id;
    private OffsetDateTime startDate;
    private String projectCode;
    private UUID projOwner;
    private String projectName;
    private String description;
    private ProfilesEntity profilesByProjOwner;

    @Id
    @Column(name = "\"Id\"", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"StartDate\"", nullable = false)
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "\"ProjectCode\"", nullable = false, length = 20)
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Basic
    @Column(name = "\"ProjOwner\"", nullable = false)
    @Convert(converter = UUIDAttributeConverter.class)
    public UUID getProjOwner() {
        return projOwner;
    }

    public void setProjOwner(UUID projOwner) {
        this.projOwner = projOwner;
    }

    @Basic
    @Column(name = "\"ProjectName\"", nullable = true, length = 20)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "\"Description\"", nullable = true, length = 320)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        P0000ProjectsEntity that = (P0000ProjectsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;
        if (!Arrays.equals(projOwner, that.projOwner)) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(projOwner);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
*/
    @ManyToOne
    @JoinColumn(name = "\"ProjOwner\"", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ProfilesEntity getProfilesByProjOwner() {
        return profilesByProjOwner;
    }

    public void setProfilesByProjOwner(ProfilesEntity profilesByProjOwner) {
        this.profilesByProjOwner = profilesByProjOwner;
    }

}