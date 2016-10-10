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
import java.util.Map;

@RestController
@RequestMapping("/")
public class SiteController {

    @Autowired
    SiteService siteService;

    @Autowired
    UserService userService;

    @Autowired
    SiteController(SiteService siteService){this.siteService = siteService;}

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
    Site ViewSite(HttpSession httpSession, @PathVariable("id") long id){
        Site site;
        site = siteService.findById(id);
        return site;
    }

    @RequestMapping(value = "/site/delete/{id}", method = RequestMethod.GET)
    public void deleteSite(@PathVariable("id")long id){
        siteService.delete(id);
    }

    @RequestMapping(value = "/site/update", method = RequestMethod.POST)
    public void updateSite(@RequestBody Map map){
        Site site = siteService.findById((Long)map.get("id"));
        siteService.save(site);
    }

    @RequestMapping(value = "/site/save", method = RequestMethod.POST)
    public void saveSite(@RequestBody Map map, Authentication principal){
        Site site = new Site();
        site.setSiteName((String)map.get("name"));
        site.setUser(userService.findByUserId((String)principal.getCredentials()));
        siteService.save(site);
    }
}