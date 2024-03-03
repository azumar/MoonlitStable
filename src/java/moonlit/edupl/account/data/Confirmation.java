/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author umar_
 */
@Entity
@Table(name = "confirmation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Confirmation.findAll", query = "SELECT c FROM Confirmation c")
    , @NamedQuery(name = "Confirmation.findById", query = "SELECT c FROM Confirmation c WHERE c.confirmationPK.id = :id")
    , @NamedQuery(name = "Confirmation.findByHasExpired", query = "SELECT c FROM Confirmation c WHERE c.hasExpired = :hasExpired")
    , @NamedQuery(name = "Confirmation.findByIsConfirmed", query = "SELECT c FROM Confirmation c WHERE c.isConfirmed = :isConfirmed")
    , @NamedQuery(name = "Confirmation.findByTimeGenerated", query = "SELECT c FROM Confirmation c WHERE c.timeGenerated = :timeGenerated")
    , @NamedQuery(name = "Confirmation.findByTokenGenerated", query = "SELECT c FROM Confirmation c WHERE c.tokenGenerated = :tokenGenerated")
    , @NamedQuery(name = "Confirmation.findByUserAccountId", query = "SELECT c FROM Confirmation c WHERE c.confirmationPK.userAccountId = :userAccountId")})
public class Confirmation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConfirmationPK confirmationPK;
    @Size(max = 45)
    @Column(name = "hasExpired")
    private String hasExpired;
    @Size(max = 45)
    @Column(name = "isConfirmed")
    private String isConfirmed;
    @Column(name = "timeGenerated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeGenerated;
    @Size(max = 45)
    @Column(name = "tokenGenerated")
    private String tokenGenerated;
    @JoinColumn(name = "user_account_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;

    public Confirmation() {
    }

    public Confirmation(ConfirmationPK confirmationPK) {
        this.confirmationPK = confirmationPK;
    }

    public Confirmation(int id, int userAccountId) {
        this.confirmationPK = new ConfirmationPK(id, userAccountId);
    }

    public ConfirmationPK getConfirmationPK() {
        return confirmationPK;
    }

    public void setConfirmationPK(ConfirmationPK confirmationPK) {
        this.confirmationPK = confirmationPK;
    }

    public String getHasExpired() {
        return hasExpired;
    }

    public void setHasExpired(String hasExpired) {
        this.hasExpired = hasExpired;
    }

    public String getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(String isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Date getTimeGenerated() {
        return timeGenerated;
    }

    public void setTimeGenerated(Date timeGenerated) {
        this.timeGenerated = timeGenerated;
    }

    public String getTokenGenerated() {
        return tokenGenerated;
    }

    public void setTokenGenerated(String tokenGenerated) {
        this.tokenGenerated = tokenGenerated;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (confirmationPK != null ? confirmationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Confirmation)) {
            return false;
        }
        Confirmation other = (Confirmation) object;
        if ((this.confirmationPK == null && other.confirmationPK != null) || (this.confirmationPK != null && !this.confirmationPK.equals(other.confirmationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moonlit.edupl.account.data.Confirmation[ confirmationPK=" + confirmationPK + " ]";
    }
    
}
