package batch02_ssf_assessment.ssf.assessment.Model;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Cart implements Serializable {

    @NotNull(message = "please choose an item")
    private String item;

    @Min(value = 1, message = "You must add at least 1 item")
    private int quantity;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart [item=" + item + ", quantity=" + quantity + "]";
    }

    
}
