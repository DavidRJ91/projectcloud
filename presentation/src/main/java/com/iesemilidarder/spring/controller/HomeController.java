package com.iesemilidarder.spring.controller;

import com.iesemilidarder.projectcloud.core.base.ReadDB;
import com.iesemilidarder.projectcloud.core.dao.Restaurants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(@ModelAttribute("model") ModelMap model) {
        ReadDB dbManager = new ReadDB();
        List<Restaurants> leeRestaurants = dbManager.LeerRestaurantsAPI();
        model.addAttribute("list",leeRestaurants);
        return "index";
    }
}
