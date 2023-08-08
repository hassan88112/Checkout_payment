package com.example.StripePayment.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {


    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    public String checkout(Model model, @RequestParam(required = true) String systemUserId,@RequestParam(required = true) Integer amount){

        model.addAttribute("amount",amount*1000);
        model.addAttribute("stripePublicKey",stripePublicKey);
        model.addAttribute("currency","USD");
        model.addAttribute("systemUserId",systemUserId);

        return "checkout";
    }
}
