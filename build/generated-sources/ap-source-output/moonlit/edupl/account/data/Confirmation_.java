package moonlit.edupl.account.data;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.account.data.ConfirmationPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-28T13:51:19")
@StaticMetamodel(Confirmation.class)
public class Confirmation_ { 

    public static volatile SingularAttribute<Confirmation, Date> timeGenerated;
    public static volatile SingularAttribute<Confirmation, String> hasExpired;
    public static volatile SingularAttribute<Confirmation, String> tokenGenerated;
    public static volatile SingularAttribute<Confirmation, String> isConfirmed;
    public static volatile SingularAttribute<Confirmation, ConfirmationPK> confirmationPK;
    public static volatile SingularAttribute<Confirmation, Account> account;

}