package com.feedhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.feedhub.entity.FeedSource;

@Repository
public interface FeedSourceRepository extends PagingAndSortingRepository<FeedSource, Long>, JpaRepository<FeedSource, Long>{

}
