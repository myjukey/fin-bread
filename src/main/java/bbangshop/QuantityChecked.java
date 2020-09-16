
package bbangshop;

public class QuantityChecked extends AbstractEvent {

    private Long breadId;
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
}
