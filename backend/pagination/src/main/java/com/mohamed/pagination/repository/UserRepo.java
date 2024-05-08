package com.mohamed.pagination.repository;

import com.mohamed.pagination.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User,Long> {
}
