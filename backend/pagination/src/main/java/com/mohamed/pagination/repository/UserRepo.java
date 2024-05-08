package com.mohamed.pagination.repository;

import com.mohamed.pagination.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
