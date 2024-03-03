/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.interfaces;


import javax.inject.Named;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.account.data.Groups;

/**
 *
 * @author umar_
 */
@Named
public interface  IAccountManagement {
    
    public void createAccount(Account account, Groups group);
    public void updateAccount(Account account);
    public void retreiveAccount(Account account);
    
}
