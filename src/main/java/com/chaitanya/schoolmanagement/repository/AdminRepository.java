package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findAdminByEmail(String email);
}
