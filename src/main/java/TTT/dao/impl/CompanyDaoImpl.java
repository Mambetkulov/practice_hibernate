package TTT.dao.impl;

import TTT.config.DataBaseConfig;
import TTT.dao.CompanyDao;
import TTT.models.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

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
    public Company findById(Long id) {
        Company company = null;

        try {
            entityManager.getTransaction().begin();

            company = (Company) entityManager.createQuery("select c from Company c where c.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            entityManager.getTransaction().rollback();
            System.out.println("Компания табылган жок!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }

        return company;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Company update(Company company, Long id) {
        entityManager.getTransaction().begin();
        Company company1 = entityManager.find(Company.class, id);
        company1.setName(company.getName());
        company1.setAddress(company.getAddress());
        entityManager.merge(company1);
        entityManager.getTransaction().commit();
        return company1;
    }
}
