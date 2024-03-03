
package moonlit.edupl.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class HashedPasswordGenerator {

    public static String generateHash(String password) {

        String hash
                = Hashing.sha256()
                .hashString(password, Charsets.UTF_8).toString();

        return hash;

    }

    public static void main (String [] args){
        HashedPasswordGenerator hpg = new HashedPasswordGenerator ();
      String hs=  hpg.generateHash("password");
        System.out.println("HASHED: "+hs);
        
    }

}
