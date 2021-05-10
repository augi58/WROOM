package lt.augi58.wroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "inventory_items")
public class InventoryItemJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String make;
    @Column
    private String serialNo;
    @ElementCollection
    @OrderColumn(name = "pos")
    private String[] fitsFor;
    @ManyToOne
    @JsonIgnore
    private WorkshopJPA workshop;
    @Column
    private Integer quantity;
    @Column
    private Double cost;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<JobJPA> jobs;

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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String[] getFitsFor() {
        return fitsFor;
    }

    public void setFitsFor(String[] fitsFor) {
        this.fitsFor = fitsFor;
    }

    public WorkshopJPA getWorkshop() {
        return workshop;
    }

    public void setWorkshop(WorkshopJPA workshop) {
        this.workshop = workshop;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
