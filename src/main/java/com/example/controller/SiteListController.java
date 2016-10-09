package com.example.controller;

import com.example.model.Site;
import com.example.model.User;
import com.example.service.SiteService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/")
public class SiteListController {

    @Autowired
    SiteService siteService;

    @Autowired
    UserService userService;

    @Autowired
    SiteListController(SiteService siteService){this.siteService = siteService;}

    @RequestMapping(value = "/site/get_all", method = RequestMethod.GET)
    public @ResponseBody List<Site> getAllSites(){
        List<Site> sites;
        sites = siteService.findAll();
        return sites;
    }

    @RequestMapping(value = "/site/get_user_data", method = RequestMethod.GET)
    public @ResponseBody List<Site> getUserSites(Authentication principal){
        List<Site> sites;
        User user;
        user = userService.findByUserId((String)principal.getCredentials());
        sites = siteService.findByUser(user);
        return sites;
    }

    @RequestMapping(value = "/site/info/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Site> ViewSite(HttpSession httpSession, @PathVariable("id") long id){
        List<Site> sites;
        sites = siteService.findById(id);
        return sites;
    }
}