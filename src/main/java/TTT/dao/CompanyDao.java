package TTT.dao;

import TTT.models.Company;

import java.util.List;

public interface CompanyDao {

    //save
    void save(Company company);

    //get all
    List<Company> getAll();

    //get by id
    Company findByid (Long id);

    //delete
    void deleteById(Long id);

    //update
    void update(Company company,Long id);
}
