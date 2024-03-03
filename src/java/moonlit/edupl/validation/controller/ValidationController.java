/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.validation.controller;

import java.io.Serializable;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import moonlit.edupl.account.data.Confirmation;
import moonlit.edupl.account.data.Account;
//import moonlit.edupl.message.impl.EmailNotifier;
//import moonlit.edupl.message.impl.UKTextNotifier;
//import moonlit.edupl.message.interfaces.IMessageManager;
import moonlit.edupl.validation.impl.AccountCreationMessage;
import moonlit.edupl.validation.interfaces.IValidator;

/**
 *
 * @author umar_
 */
@Named
@RequestScoped

public class ValidationController implements Serializable {
@EJB
private IValidator  validator;
//@Inject
//   private  static IMessageManager en1;//static wthout injection
//    private  static IMessageManager en2;
@Inject
 private Event <AccountCreationEvent> accountcreationEvent;
 
 //WE HAVE TO CREATE ACCOUNT CREATION EVENT CLASS/OBJECT WITH USERACCAOUNT AND ACCOUNT CREATIONMESSAGE AS MEMBERS PASSED THROUGH THE CONSTRUCTOR
 //THE SAME WITH MESSAGE

    public ValidationController() {
//       en1 = new UKTextNotifier();
//        en2 = new EmailNotifier();
        System.out.println("Validation Controller Created ");
    }
    //@Observes 
    //Testing michrophone
  //

 //  @Asynchronous

    public void validateAccount( @Observes Account account) throws Exception{
      Confirmation confirmation =  validator.generateAndSaveToken(account);
        AccountCreationMessage am = new AccountCreationMessage("the Name", "Account creation", "Account Created", "Managment");
          am.setContent("http://localhost:8080/Moonlit.EduplJSF/validate?" + confirmation.getTokenGenerated());
       
          
         accountcreationEvent.fire(new AccountCreationEvent(account, am));
         // Put both email and text message here as event or message
//        en1.sendNotification(account, am);
//         en2.sendNotification(account, am);
          //JUST FOR TEST
          
       
    }
    
    public void validateToken(String token) throws Exception{
        String res = validator.validateAccout(token);
          
          System.out.println("GA RESULT :"+res);
                  
    }
   
}
