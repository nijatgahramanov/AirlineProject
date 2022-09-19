package com.company.dao.inter;

import com.company.entity.Company;
import com.company.entity.Directory;

import java.util.List;

public interface CompanyInter {
   public boolean addCompany(Company company);
   public Company getByCompanyId(Integer id);
   public List<Company> getCompanyFlights();
}
