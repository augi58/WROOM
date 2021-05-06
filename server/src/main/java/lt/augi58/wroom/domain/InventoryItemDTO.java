package lt.augi58.wroom.domain;

import java.util.List;

public class InventoryItemDTO {

    private Long id;
    private String name;
    private String make;
    private String serialNo;
    private List<String> fitsFor;
    private Long workshopId;
    private Integer quantity;

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

    public List<String> getFitsFor() {
        return fitsFor;
    }

    public void setFitsFor(List<String> fitsFor) {
        this.fitsFor = fitsFor;
    }

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
