/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.account.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author umar_
 */
@Embeddable
public class ConfirmationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_account_id")
    private int userAccountId;

    public ConfirmationPK() {
    }

    public ConfirmationPK(int id, int userAccountId) {
        this.id = id;
        this.userAccountId = userAccountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) userAccountId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfirmationPK)) {
            return false;
        }
        ConfirmationPK other = (ConfirmationPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.userAccountId != other.userAccountId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moonlit.edupl.account.data.ConfirmationPK[ id=" + id + ", userAccountId=" + userAccountId + " ]";
    }
    
}
