package com.example.bmjwhere.repository.search;

import com.example.bmjwhere.entity.Resturant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchResturantRepository {
    Resturant search1();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
