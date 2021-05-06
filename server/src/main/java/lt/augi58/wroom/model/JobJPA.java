package lt.augi58.wroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.augi58.wroom.enums.JobStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "jobs")
public class JobJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private UserJPA client;
    @Column
    private Long vehicleId;
    @ManyToOne
    @JsonIgnore
    private UserJPA technician;
    @Column
    private String name;
    @Column
    private JobStatus status;
    @ManyToMany
    private Set<InventoryItemJPA> parts;
    @Column
    private Long labor;
    @Column
    private Long rate;
    @Column
    private Date dueDate;
    @Column
    private Boolean doorToDoor;
    @Column
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserJPA getClient() {
        return client;
    }

    public void setClient(UserJPA client) {
        this.client = client;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UserJPA getTechnician() {
        return technician;
    }

    public void setTechnician(UserJPA technician) {
        this.technician = technician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Set<InventoryItemJPA> getParts() {
        return parts;
    }

    public void setParts(Set<InventoryItemJPA> parts) {
        this.parts = parts;
    }

    public Long getLabor() {
        return labor;
    }

    public void setLabor(Long labor) {
        this.labor = labor;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDoorToDoor() {
        return doorToDoor;
    }

    public void setDoorToDoor(Boolean doorToDoor) {
        this.doorToDoor = doorToDoor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
