/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.validation.impl;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import moonlit.edupl.account.data.Confirmation;
import moonlit.edupl.account.data.ConfirmationPK;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.validation.interfaces.IValidator;

/**
 *
 * @author umar_
 */
@Stateless
public class ValidatorImpl implements IValidator {
    @EJB
    TokenGenerator tk;
    @PersistenceContext(unitName = "RoughPU")
    private EntityManager entityManager;

    public ValidatorImpl() {
        //en = new EmailNotification();
    }
    @Override
    public Confirmation generateAndSaveToken(Account account) {

        String token = tk.getAccessCodes();
        Confirmation con = persistToken(account, token);
        return con;
   }

    @Override
    public String validateAccout(String token) throws Exception {
        String toReturn = "success";

        String isConfirmed = "NO";
        //   UserAccount account = findById(accountId);
        Query query = entityManager.createQuery("SELECT c FROM Confirmation c WHERE c.tokenGenerated = :token");
        query.setParameter("token", token);
        //   query.setParameter("account", account);
        Confirmation confirmation = (Confirmation) query.getSingleResult();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //  UserAccount uc = confirmation.getUserAccount();

        Timestamp oldTimestamp = new Timestamp(confirmation.getTimeGenerated().getTime());
        long diff = timestamp.getTime() - oldTimestamp.getTime();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

        if (minutes <= 60) {
            isConfirmed = "YES";
            confirmation.setIsConfirmed(isConfirmed);
            entityManager.merge(confirmation);

        }

        return toReturn;

    }

//     private UserAccount findById(int accountId) throws Exception {
//        Query query = entityManager.createQuery("SELECT u FROM UserAccount u WHERE u.id = :id");
//        query.setParameter("id", accountId);
//        return (UserAccount) query.getSingleResult();
//    }
    private Confirmation persistToken(Account account, String token) {
        ConfirmationPK cPk = new ConfirmationPK();

        cPk.setUserAccountId(account.getId());
        Confirmation confirmation = new Confirmation();
        confirmation.setConfirmationPK(cPk);
        confirmation.setAccount(account);
        confirmation.setTokenGenerated(token);
        confirmation.setHasExpired("No");
        confirmation.setIsConfirmed("NO");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        confirmation.setTimeGenerated(timestamp);

        try {
            entityManager.persist(confirmation);
        } catch (Exception e) {
            System.out.println("PRINT ERROR HERE");
        }

        return confirmation;

    }
}
