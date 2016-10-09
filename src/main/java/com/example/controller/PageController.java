package com.example.controller;

import com.example.model.Page;
import com.example.model.Site;
import com.example.service.PageService;
import com.example.service.SiteService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class PageController {
    @Autowired
    SiteService siteService;

    @Autowired
    UserService userService;

    @Autowired
    PageService pageService;

    @RequestMapping(value = "/site/{site_name}/page", method = RequestMethod.GET)
    public @ResponseBody
    List<Page> getSitePages(@PathVariable("site_name") Site site){
        List<Page> pages;
        pages = pageService.findBySite(site);
        return pages;
    }

    @RequestMapping(value = "/site/page/{page_number}", method = RequestMethod.GET)
    public @ResponseBody
    List<Page> getPage(@PathVariable("page_number")long id){
        List<Page> pages;
        pages = pageService.findById(id);
        return pages;
    }

    @RequestMapping(value = "/site/page/{id}", method = RequestMethod.GET)
    public void deletePage(@PathVariable("id")long id){
        pageService.delete(id);
    }

    @RequestMapping(value = "/site/page/update", method = RequestMethod.POST)
    public void updatePage(@RequestBody Map map){
        Page page = pageService.findById((Long)map.get("id")).get(0);
        pageService.save(page);
    }

    @RequestMapping(value = "/site/{site_name}/page/save", method = RequestMethod.POST)
    public void savePage(@RequestBody Map map,@PathVariable("site_name") long id){
        Page page = new Page();
        page.setContent((String)map.get("content"));
        page.setPageName((String)map.get("name"));
        page.setSite(siteService.findById(id));
        pageService.save(page);
    }

}
