package bbangshop;

public class QuantityChanged extends AbstractEvent {

    private Long breadId;
    private String breadName;
    private Integer quantity;

    public Long getBreadId() {
        return breadId;
    }
    public void setBreadId(Long breadId) {
        this.breadId = breadId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getBreadName() {
        return breadName;
    }
    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }
}
