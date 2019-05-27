package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {

    //Need a controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }


    //Need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //new controller method to read form data
    //add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request,Model model) {

        //read the request parameter from the HTML form
        String theName = request.getParameter ( "studentName" );
        //convert the data to all caps
        theName = theName.toUpperCase ();
        //create the message
        String result = "Yo! " + theName;
        //add message to the model

        model.addAttribute ( "message",result );

        return "helloworld";
    }
}
