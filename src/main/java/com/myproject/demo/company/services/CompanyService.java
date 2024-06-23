package com.myproject.demo.company.services;

import com.myproject.demo.company.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompanyById(Long id, Company companyData);

    boolean deleteCompanyById(Long id);
}
