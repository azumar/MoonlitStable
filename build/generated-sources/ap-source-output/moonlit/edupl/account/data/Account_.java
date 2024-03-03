package moonlit.edupl.account.data;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import moonlit.edupl.account.data.Confirmation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-28T13:51:19")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> firstName;
    public static volatile SingularAttribute<Account, String> lastName;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile CollectionAttribute<Account, Confirmation> confirmationCollection;
    public static volatile SingularAttribute<Account, String> middleName;
    public static volatile SingularAttribute<Account, String> telephone;
    public static volatile SingularAttribute<Account, String> userrole;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;

}