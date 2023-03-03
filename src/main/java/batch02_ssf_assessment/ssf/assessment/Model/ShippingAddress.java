package batch02_ssf_assessment.ssf.assessment.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ShippingAddress {

    @NotNull(message = "Please enter your name")
    @Size(min = 2, message = "Your name must be longer than 1 character")
    private String name;

    @NotNull(message = "Please enter your address")
    private String address;

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

    @Override
    public String toString() {
        return "ShippingAddress [name=" + name + ", address=" + address + "]";
    }

}
