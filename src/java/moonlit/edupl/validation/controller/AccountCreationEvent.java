/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.validation.controller;

import java.io.Serializable;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.validation.impl.AccountCreationMessage;

/**
 *
 * @author umar_
 */
public class AccountCreationEvent implements Serializable {
    
    Account userAccount;
    AccountCreationMessage accountMessage;

    public AccountCreationEvent(Account account, AccountCreationMessage message) {
        
        this.userAccount = account;
        this.accountMessage = message;
    }

    public AccountCreationMessage getAccountMessage() {
        return accountMessage;
    }

    public Account getAccount() {
        return userAccount;
    }
    
    
    
    
    
    
}
