/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.validation.interfaces;

import moonlit.edupl.account.data.Confirmation;
import moonlit.edupl.account.data.Account;

/**
 *
 * @author umar_
 */
public interface IValidator {
     public Confirmation  generateAndSaveToken( Account account);
    public String validateAccout( String token) throws Exception;
}
