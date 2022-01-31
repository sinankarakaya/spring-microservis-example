package org.profileservice.service;

import java.util.List;

import org.profileservice.pojo.EmployeeProfile;

public interface EmployeeProfileService {
    void addEmployeeProfile(EmployeeProfile profile);
    List < EmployeeProfile > getEmployeeProfiles();
}