package bbangshop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Bread")
public class Bread {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long breadId;
    private String breadName;
    private Integer quantity;

    @PostUpdate
    public void pulishQuantityChecked(){
        QuantityChanged quantityChanged = new QuantityChanged();
        BeanUtils.copyProperties(this, quantityChanged);
        quantityChanged.publishAfterCommit();
    }

/*    @PrePersist
    public void onPrePersist(){
        QuantityChanged quantityChanged = new QuantityChanged();
        BeanUtils.copyProperties(this, quantityChanged);
        quantityChanged.publishAfterCommit();
    }*/

    public Long getBreadId() {
        return breadId;
    }

    public void setBreadId(Long breadId) {
        this.breadId = breadId;
    }
    public String getBreadName() {
        return breadName;
    }

    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}
