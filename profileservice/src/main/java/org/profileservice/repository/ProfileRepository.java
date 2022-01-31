package org.profileservice.repository;

import org.profileservice.pojo.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository < EmployeeProfile, Integer > {
    
}