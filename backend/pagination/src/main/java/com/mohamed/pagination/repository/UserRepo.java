package com.mohamed.pagination.repository;

import com.mohamed.pagination.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User,Long> {
    Page<User> findUsersByNameContaining(String name, Pageable pageable);
}
