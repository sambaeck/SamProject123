import model.GebeurtenisType;
import model.Wedstrijd;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OEM on 4/08/2015.
 */
public class QueryTest {
    private Session session;

    public QueryTest(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Wedstrijd> toonWedstrijden(String naam, GebeurtenisType type){
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT DISTINCT (w) FROM Wedstrijd w JOIN w.gebeurtenissen g JOIN g.speler WHERE g.speler.name = :naam AND g.gebeurtenisType = :type");
        query.setParameter("naam",naam);
        query.setParameter("type",type);
        List<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>(query.list());
        tx.commit();
        return wedstrijden;

    }
}
