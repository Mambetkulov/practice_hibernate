package TTT.dao.impl;

import TTT.config.DataBaseConfig;
import TTT.dao.CompanyDao;
import TTT.models.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

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

        return List.of();
    }

    @Override
    public Company findByid(Long id) {
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
    public void update(Company company, Long id) {

    }
}
