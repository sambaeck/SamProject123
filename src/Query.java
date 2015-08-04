import model.GebeurtenisType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 * Created by OEM on 4/08/2015.
 */
public class Query {
    private Session session;

    public Query(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void toonWedstrijden(String naam){
        session.createQuery("SELECT w FROM Wedstrijd w, Gebeurtenis g WHERE g.gebeurtenisType = " + GebeurtenisType.DOELPUNT.toString() + " AND g.speler.name = :naam");
        //TODO wedstrijd - gebeurtenis (link)
    }
}
