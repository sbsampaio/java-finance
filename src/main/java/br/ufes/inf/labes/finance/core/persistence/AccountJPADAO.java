package br.ufes.inf.labes.finance.core.persistence;

import br.ufes.inf.labes.finance.core.domain.Account;
import br.ufes.inf.labes.jbutler.ejb.persistence.BaseJPADAO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AccountJPADAO extends BaseJPADAO<Account> implements AccountDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
