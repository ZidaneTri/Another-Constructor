package com.example.service;


import com.example.model.Site;

import java.util.List;


public interface SiteService {
    List<Site> findBySiteId(long siteId);

    void save(Site site);

}
