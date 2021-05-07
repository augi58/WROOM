package lt.augi58.wroom.domain;

import lt.augi58.wroom.enums.JobStatus;

import java.util.Date;
import java.util.List;

public class JobDTO {

    private Long id;
    private String name;
    private UserDTO client;
    private UserDTO technician;
    private JobStatus status;
    private List<InventoryItemDTO> parts;
    private Double labor;
    private Double rate;
    private Date dueDate;
    private Boolean doorToDoor;
    private String notes;
    private VehicleDTO vehicle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDTO getClient() {
        return client;
    }

    public void setClient(UserDTO client) {
        this.client = client;
    }

    public UserDTO getTechnician() {
        return technician;
    }

    public void setTechnician(UserDTO technician) {
        this.technician = technician;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public List<InventoryItemDTO> getParts() {
        return parts;
    }

    public void setParts(List<InventoryItemDTO> parts) {
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
}
