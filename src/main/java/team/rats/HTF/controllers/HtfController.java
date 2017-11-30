package main.java.team.rats.HTF.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.rats.HTF.models.Alert;
import team.rats.HTF.models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/API")
public class HtfController {

    @Autowired
    HtfController(){ }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));

    }

    @GetMapping("/users")
    public ArrayList<User> getAllUsers(){
        return null;
    }

    @GetMapping("/alerts")
    public ArrayList<Alert> getAllAlerts(){
        return null;
    }
}
