package br.ufes.inf.labes.finance.core.persistence;

import br.ufes.inf.labes.finance.core.domain.Account;
import br.ufes.inf.labes.jbutler.ejb.persistence.BaseDAO;
import jakarta.ejb.Local;

@Local
public interface AccountDAO extends BaseDAO<Account> {
}
