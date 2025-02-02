package TTT.dao;

import TTT.models.Company;

import java.util.List;

public interface CompanyDao {

    //save
    void save(Company company);

    //get all
    List<Company> getAll();

    //get by id
    Company findById (Long id);

    //delete
    void deleteById(Long id);

    //update
    Company update(Company company,Long id);
}
