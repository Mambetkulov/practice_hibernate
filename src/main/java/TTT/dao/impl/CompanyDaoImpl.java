package TTT.dao.impl;

import TTT.config.DataBaseConfig;
import TTT.dao.CompanyDao;
import TTT.models.Company;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {
    EntityManager entityManager = DataBaseConfig.entityManagerFactory().createEntityManager();


    @Override
    public void save(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
            companies = entityManager.createQuery("select c from Company c").getResultList();
            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return companies;
    }

    @Override
    public Company findByid(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Company company, Long id) {

    }
}
