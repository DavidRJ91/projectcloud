package com.iesemilidarder.spring.controller;

import com.iesemilidarder.projectcloud.core.base.ReadDB;
import com.iesemilidarder.projectcloud.core.dao.Restaurants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class RestaurantsController {

    @RequestMapping(path = "/restaurants")//, method = RequestMethod.GET)
    public List<Restaurants> getAll(@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        ReadDB dbManager = new ReadDB();
        List<Restaurants> leeRestaurants = dbManager.LeerRestaurantsAPI();
        return leeRestaurants;
    }
}
