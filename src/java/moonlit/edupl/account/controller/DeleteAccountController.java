/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.account.interfaces.IDeleteManager;

/**
 *
 * @author umar_
 */
@Named
@RequestScoped
public class DeleteAccountController {

    @EJB
    IDeleteManager deleteManager;
    Account account;
}
