package batch02_ssf_assessment.ssf.assessment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import batch02_ssf_assessment.ssf.assessment.Model.Cart;
import batch02_ssf_assessment.ssf.assessment.Model.Confirmation;
import batch02_ssf_assessment.ssf.assessment.Model.Item;
import batch02_ssf_assessment.ssf.assessment.Model.ShippingAddress;
import batch02_ssf_assessment.ssf.assessment.Service.ItemService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PurchaseOrderController {

    @Autowired
    private ItemService itemSvc;

    @GetMapping(path = { "/", "/view1" })
    public String getIndex(Model model) {

        model.addAttribute("item", new Item());
        return "view1";
    }

    @GetMapping(path = "/view2")
    public String getCart(Model model, HttpSession session, @Valid Item Item, BindingResult br) {

        if (br.hasErrors())
            return "view1";

        List<ObjectError> errors = itemSvc.validateItem(Item);
        if (!errors.isEmpty()) {
            for (ObjectError err : errors)
                br.addError(err);
            return "view1";
        }

        session.setAttribute("item", Item);

        model.addAttribute("shippingaddress", new ShippingAddress());

        return "view2";
    }

    @PostMapping(path = "/view2/view3")
    public String cartConfirmation(Model model, HttpSession session, @Valid ShippingAddress shippingaddress,
            BindingResult br) {

        if (br.hasErrors())
            return "view2";

        // Item item =(Item)session.getAttribute("item");

        model.addAttribute("confirmation", new Confirmation());

        return "view3";
    }
}
