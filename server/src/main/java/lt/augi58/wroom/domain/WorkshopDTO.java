package lt.augi58.wroom.domain;

import java.util.List;

public class WorkshopDTO {
    private Long id;
    private Long accountId;
    private String name;
    private List<InventoryItemDTO> inventoryItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InventoryItemDTO> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItemDTO> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}
