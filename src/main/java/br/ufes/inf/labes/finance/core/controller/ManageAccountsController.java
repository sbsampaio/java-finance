package br.ufes.inf.labes.finance.core.controller;

import br.ufes.inf.labes.finance.core.application.ManageAccountsService;
import br.ufes.inf.labes.finance.core.domain.Account;
import br.ufes.inf.labes.jbutler.ejb.application.CrudService;
import br.ufes.inf.labes.jbutler.ejb.controller.CrudController;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ManageAccountsController extends CrudController<Account> {
    @EJB
    private ManageAccountsService manageAccountsService;

    @Override
    protected CrudService<Account> getCrudService() {
        return manageAccountsService;
    }
}
