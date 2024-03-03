/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.account.data.Groups;
import moonlit.edupl.account.interfaces.IAccounControl;
import moonlit.edupl.account.interfaces.IAccountManagement;


/**
 *
 * @author umar_
 */
@Named
@RequestScoped
public class AccountController implements Serializable, IAccounControl {
//@Default
    @Inject 
   IAccountManagement accountManager;
//   @Inject  private ValidationController validationController;

    @Inject
    private Event<Account> accountEvent;

    private Account account;
    private Groups group;

    @PostConstruct
    public void init() {
        account = new Account();
        group = new Groups();
    }

    // @Asynchronous
    @Override
    public String createAccount() {
        String toReturn = "applicant/confirmation";
        try {
            // populateAccount();

            group.setGroupname("eduplapplicant");
            account.setUsername(account.getLastName().toLowerCase());
            group.setUsername(account.getLastName().toLowerCase());
            account.setUserrole("eduplapplicant");
            accountManager.createAccount(account, group);

            accountEvent.fire(account);
            // THIS IS A DIRECT COUPLING WITH VALIDATION CONTROLLER THAT WILL BE REPLACED BY EVENT?MESSAGE
            // validationController.validateAccount(account);
            //END TEST

        } catch (Exception e) {
            toReturn = "error";
        }
        return toReturn;
    }

    public Account getAccount() {
        return account;
    }

}
