package batch02_ssf_assessment.ssf.assessment.Model;

import java.io.Serializable;

import jakarta.json.JsonObject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Item implements Serializable {

    @NotNull(message = "please choose an item")
    private String name;

    @Min(value = 1, message = "You must add at least 1 item")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", quantity=" + quantity + "]";
    }

    public static Item create(JsonObject json) {
        Item item = new Item();
        item.setName(json.getString("name"));
        item.setQuantity(json.getInt("quantity"));
        return item;
    }

}
