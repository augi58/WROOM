package lt.augi58.wroom.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshops")
public class WorkshopJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private AccountJPA account;
    @Column
    private String name;
    @Column
    private String address;
    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<InventoryItemJPA> inventoryItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountJPA getAccount() {
        return account;
    }

    public void setAccount(AccountJPA account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<InventoryItemJPA> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Set<InventoryItemJPA> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}
