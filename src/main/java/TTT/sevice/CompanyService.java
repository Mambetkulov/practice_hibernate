package TTT.sevice;

import TTT.models.Company;

import java.util.List;

public interface CompanyService {

    //save
    String addCompany(Company company);
    Company updateCompany(Company company,Long id);
    List<Company> findAllCompanies();
}
