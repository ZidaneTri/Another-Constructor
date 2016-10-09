package com.example.site_controller;

import com.example.model.Site;
import com.example.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/")
public class SiteListController {

    @Autowired
    SiteService siteService;

    @Autowired
    SiteListController(SiteService siteService){this.siteService = siteService;}

    @RequestMapping(value = "/site/info/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Site> ViewSites(HttpSession httpSession, @PathVariable("id") long id){
        List<Site> sites;
        Site site;
        sites = siteService.findBySiteId( 1);
        return sites;
    }
}
