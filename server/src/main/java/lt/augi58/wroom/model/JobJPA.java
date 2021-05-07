package lt.augi58.wroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.utils.ObjectMapperUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "jobs")
public class JobJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private UserJPA client;
    @ManyToOne
    private VehicleJPA vehicle;
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
    private Double labor;
    @Column
    private Double rate;
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

    public VehicleJPA getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleJPA vehicle) {
        this.vehicle = vehicle;
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

    public Double getLabor() {
        return labor;
    }

    public void setLabor(Double labor) {
        this.labor = labor;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
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

    public JobDTO createDTO() {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(getId());
        jobDTO.setClient(ObjectMapperUtils.map(getClient(), UserDTO.class));
        jobDTO.setVehicle(ObjectMapperUtils.map(getVehicle(), VehicleDTO.class));
        jobDTO.setTechnician(ObjectMapperUtils.map(getTechnician(), UserDTO.class));
        jobDTO.setParts(getParts().stream().map(part -> ObjectMapperUtils.map(part, InventoryItemDTO.class)).collect(Collectors.toList()));
        jobDTO.setName(getName());
        jobDTO.setStatus(getStatus());
        jobDTO.setLabor(getLabor());
        jobDTO.setRate(getRate());
        jobDTO.setDueDate(getDueDate());
        jobDTO.setDoorToDoor(getDoorToDoor());
        jobDTO.setNotes(getNotes());
        return jobDTO;
    }
}
