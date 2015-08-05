package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.GebeurtenisType;
import model.Wedstrijd;
import persistence.HibernateUtil;

public class WedstrijdDAO {

	private Session session;

    public WedstrijdDAO(){
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
