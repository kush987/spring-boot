package com.myproject.demo.company.services.impl;

import com.myproject.demo.company.model.Company;
import com.myproject.demo.company.repository.CompanyRepository;
import com.myproject.demo.company.services.CompanyService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompanyById(Long id, Company companyData) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setCompanyLocation(companyData.getCompanyLocation());
            company.setCompanyName(companyData.getCompanyName());
            company.setAbout(companyData.getAbout());
            company.setCompanySize(companyData.getCompanySize());
            company.setCompanyType(companyData.getCompanyType());

            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            if(companyRepository.existsById(id)){
                companyRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


}
