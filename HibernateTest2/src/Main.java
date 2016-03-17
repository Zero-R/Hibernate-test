
import db.HibernateUtil;
import entity.Users;
import org.hibernate.*;

/**
 * Created by dell on 2015/11/2 0002.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        Transaction tx = null;

        try {
            Session session = HibernateUtil.getCurrentSession();
            tx = session.beginTransaction();
            Users user = new Users();
            user.setName("王重阳");
            user.setTel(110);
            user.setIMEI(123456789012345L);
            session.save(user);
            tx.commit();

        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }
}
