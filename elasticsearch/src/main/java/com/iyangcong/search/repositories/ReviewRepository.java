package com.iyangcong.search.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iyangcong.search.entities.Review;

public interface ReviewRepository {

	public long hitsByKeywords(String keywords);

	public Page<Review> searchContentByKeywords(String keywords, Pageable pageable);

}
