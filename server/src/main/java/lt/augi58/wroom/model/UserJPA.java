package lt.augi58.wroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.augi58.wroom.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Role role;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String mobileNumber;
    @Column
    private String address;
    @ManyToOne
    @JsonIgnore
    private AccountJPA account;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<JobJPA> jobs;
    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<JobJPA> tasks;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<VehicleJPA> vehicles;

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

    public Set<VehicleJPA> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<VehicleJPA> vehicles) {
        this.vehicles = vehicles;
    }
}
