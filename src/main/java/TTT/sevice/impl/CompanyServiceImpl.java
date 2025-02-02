package TTT.sevice.impl;

import TTT.dao.CompanyDao;
import TTT.dao.impl.CompanyDaoImpl;
import TTT.models.Company;
import TTT.sevice.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    CompanyDao companyDao = new CompanyDaoImpl();
    @Override
    public String addCompany(Company company) {
        try {
            companyDao.save(company);
        }catch (Exception e) {
            return e.getMessage();
        }
        return "success saved";
    }

    @Override
    public Company updateCompany(Company company,Long id) {
        return companyDao.update(company,id);
    }

    @Override
    public Company findById(Long id) {
        return  companyDao.findById(id);

    }
}
