/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.validation.impl;

import moonlit.edupl.account.config.AbstractMessageConfig;

/**
 *
 * @author umar_
 */
public class AccountCreationMessage extends AbstractMessageConfig{

    public AccountCreationMessage(String name, String subject, String content, String signature) {
           super(name, subject, content, signature);
    }
    
}
