/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.message.interfaces;

import javax.enterprise.event.Observes;
import moonlit.edupl.account.config.AbstractMessageConfig;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.validation.controller.AccountCreationEvent;

/**
 *
 * @author umar_
 */
public interface IMessageManager {
      public void sendNotification(Account messageReceiver, AbstractMessageConfig message);
        public void sendNotification(@Observes AccountCreationEvent event);
}
