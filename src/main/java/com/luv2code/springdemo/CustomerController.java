package com.luv2code.springdemo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //add an initbinder.... to convert trim input strings
    //remove leading and trailing whitespace
    //resolve issue for our validation
/*    @InitBinder
    public void bindMyCustomValidator(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor (String.class,stringTrimmerEditor);
    }*/


//NB:::Instead of using the above code I have use the below to avoid white spaces and trimming

//public void setLastName(String lastName) {
//    this.lastName = lastName.trim ();
//}

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        theModel.addAttribute ( "customer",new Customer () );

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {
        System.out.println ("Last Name: |" +theCustomer.getLastName ()+"|");
        if (theBindingResult.hasErrors ()) {
            return "customer-form";
        } else {
            return "customer_confirmation";
        }
    }
}
