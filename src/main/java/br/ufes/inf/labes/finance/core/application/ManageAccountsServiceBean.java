package br.ufes.inf.labes.finance.core.application;

import br.ufes.inf.labes.finance.core.domain.Account;
import br.ufes.inf.labes.finance.core.persistence.AccountDAO;
import br.ufes.inf.labes.jbutler.ejb.application.CrudServiceImpl;
import br.ufes.inf.labes.jbutler.ejb.persistence.BaseDAO;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
@PermitAll
public class ManageAccountsServiceBean extends CrudServiceImpl<Account> implements ManageAccountsService {
    @EJB
    private AccountDAO accountDAO;

    @Override
    public BaseDAO<Account> getDAO() {
        return accountDAO;
    }
}
