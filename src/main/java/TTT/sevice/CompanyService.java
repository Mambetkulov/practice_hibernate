package TTT.sevice;

import TTT.models.Company;

public interface CompanyService {

    //save
    String addCompany(Company company);

    Company findById(Long id);
}
