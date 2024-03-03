/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.impl;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.account.data.Groups;
import moonlit.edupl.account.interfaces.IAccountManagement;

/**
 *
 * @author umar_
 */
//@Default
@Stateless
public class AccountManagementImpl implements IAccountManagement{
@PersistenceContext(unitName ="RoughPU")
private EntityManager entityManager;
    @Override
    public void createAccount(Account account, Groups group) {
        entityManager.persist(account);
        entityManager.persist(group);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

    @Override
    public void retreiveAccount(Account account) {
       //entityManager.f
    }
    
}
