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
import batch02_ssf_assessment.ssf.assessment.Model.ShippingAddress;
import batch02_ssf_assessment.ssf.assessment.Service.CartService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PurchaseOrderController {

    @Autowired
    private CartService cartSvc;
  
    @GetMapping(path={"/", "/index.html"})
    public String getIndex(Model model) {

        model.addAttribute("cart", new Cart());
        return "index";
    }

    @GetMapping(path="/shippingaddress")
    public String postCart(Model model, HttpSession session, @Valid Cart cart, BindingResult br) {
        
        if(br.hasErrors())
        return "index";
        
        List<ObjectError> errors = cartSvc.validateCart(cart);
		if (!errors.isEmpty()) {
			for (ObjectError err: errors)
				br.addError(err);
			return "index";
		}

        session.setAttribute("cart", cart);

        model.addAttribute("shippingaddress", new ShippingAddress());

        return "shippingaddress";
    }

    @PostMapping(path="/shippingaddress/confirmation")
    public String cartConfirmation(Model model, HttpSession session, @Valid ShippingAddress shippingAddress, BindingResult br) {
        
        if(br.hasErrors())
        return "shippingaddress";
        
        // List<ObjectError> errors = cartSvc.validateCart(cart);
		// if (!errors.isEmpty()) {
		// 	for (ObjectError err: errors)
		// 		br.addError(err);
		// 	return "index";
		// }

        session.setAttribute("shippingaddress", shippingAddress);

        model.addAttribute("confirmation", new Confirmation());

        return "confirmation";
    }
}
