package br.ufes.inf.labes.finance.core.application;

import br.ufes.inf.labes.finance.core.domain.Account;
import br.ufes.inf.labes.jbutler.ejb.application.CrudService;
import jakarta.ejb.Local;

@Local
public interface ManageAccountsService extends CrudService<Account> {
}
