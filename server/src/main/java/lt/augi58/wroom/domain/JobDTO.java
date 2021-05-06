package lt.augi58.wroom.domain;

import lt.augi58.wroom.enums.JobStatus;

import java.util.Date;
import java.util.List;

public class JobDTO {

    private Long id;
    private String name;
    private Long clientId;
    private Long technicianId;
    private Long vehicleId;
    private JobStatus status;
    private List<Long> parts;
    private Long labor;
    private Long rate;
    private Date dueDate;
    private Boolean doorToDoor;
    private String notes;

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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public List<Long> getParts() {
        return parts;
    }

    public void setParts(List<Long> parts) {
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
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
