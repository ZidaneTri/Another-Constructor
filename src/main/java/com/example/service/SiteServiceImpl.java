package com.example.service;


import com.example.model.Site;
import com.example.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService{
    @Autowired
    private SiteRepository siteRepository;

    @Override
    public void save(Site site) {
        siteRepository.save(site);
    }

    @Override
    public List<Site> findBySiteId(long siteId){
        return siteRepository.findBySiteId(siteId);
    }
}
