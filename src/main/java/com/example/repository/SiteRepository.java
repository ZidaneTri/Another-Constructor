package com.example.repository;

import com.example.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SiteRepository extends JpaRepository<Site,Long> {
    List<Site> findBySiteId(Long siteId);
}
