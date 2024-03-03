/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.application.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import moonlit.edupl.account.data.Account;

/**
 *
 * @author umar_
 */
@Named
@SessionScoped
public class ApplicationController implements Serializable {

    private String username;
    private Account account;

  
    @PostConstruct
    public void init() {
        String tt = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        System.out.println(" GA USER PRINCIPLA" + tt);
        String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        String sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
        
        System.out.println(" remote user "+ remoteUser);
        System.out.println(" remSession id "+ sessionId);
        this.username = tt;
        //Also extract and initialize account from Databases (account Manager)
        // Model application object as one of properties of Account Object
        //The Application itsslf is compoes of othe objects
       String tt2 = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser().toLowerCase();
    }

    public String getUsername() {
        return username;
    }
}
