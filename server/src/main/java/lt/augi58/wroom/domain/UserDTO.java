package lt.augi58.wroom.domain;

import lt.augi58.wroom.enums.Role;
import lt.augi58.wroom.model.AccountJPA;
import lt.augi58.wroom.model.JobJPA;
import lt.augi58.wroom.model.VehicleJPA;

import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long id;
    private Role role;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String mobileNumber;
    private String address;
    private AccountJPA account;
    private Set<JobJPA> jobs;
    private List<VehicleJPA> vehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccountJPA getAccount() {
        return account;
    }

    public void setAccount(AccountJPA account) {
        this.account = account;
    }

    public Set<JobJPA> getJobs() {
        return jobs;
    }

    public void setJobs(Set<JobJPA> jobs) {
        this.jobs = jobs;
    }

    public List<VehicleJPA> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleJPA> vehicles) {
        this.vehicles = vehicles;
    }
}
