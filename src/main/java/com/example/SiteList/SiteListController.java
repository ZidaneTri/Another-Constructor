package com.example.SiteList;

import com.example.model.Site;
import com.example.repository.SiteRepository;
import com.example.service.SiteService;
import com.example.service.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/siteList")
public class SiteListController {
   //@Autowired
   private SiteServiceImpl siteService = new SiteServiceImpl();

    @RequestMapping(value = "/site/info/{id}", method = RequestMethod.GET)
    public List<Site> ViewSites(HttpSession httpSession, @PathVariable("id") long id){
        List<Site> sites;
        sites = siteService.findBySiteId(id);
        return sites;
    }
}
