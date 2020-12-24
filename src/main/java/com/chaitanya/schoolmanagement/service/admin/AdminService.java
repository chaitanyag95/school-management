package com.chaitanya.schoolmanagement.service.admin;

import com.chaitanya.schoolmanagement.model.admin.Admin;
import com.chaitanya.schoolmanagement.payload.RegisterAdminDto;
import com.chaitanya.schoolmanagement.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin findAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    public Boolean isAdminExist(String email) {
        Admin admin = adminRepository.findAdminByEmail(email);
        if (admin != null) {
            return true;
        }
        return false;
    }

    public Admin registerAdmin(RegisterAdminDto registerAdminDto) {
        if (findAdminByEmail(registerAdminDto.getEmail()) == null) {
            Admin admin = new Admin();
            admin.setEmail(registerAdminDto.getEmail());
            admin.setPassword(bCryptPasswordEncoder.encode(registerAdminDto.getPassword()));
            return admin;
        }
        return null;
    }
}
